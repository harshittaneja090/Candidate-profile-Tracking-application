package com.harshit.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.harshit.services.UserDetailsServiceimpl;





@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtAuthenticationEntryPoint unauthorisedHandler;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
@Autowired
UserDetailsServiceimpl UserDetailsServiceimpl;
	

@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
}
/*
@Bean
public PasswordEncoder passwordEncoder() {
	
	return  NoOpPasswordEncoder.getInstance();
	
}*/

@Bean
public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	
}

@Override
protected void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http
	.csrf()
	.disable()
	.cors()
	.disable()
	.authorizeHttpRequests()
	.antMatchers("/api/v1/generate-token","/api/v1/user/")
	.permitAll()
	.antMatchers(HttpMethod.OPTIONS)
	//.antMatchers()
	.permitAll()
	.anyRequest()
	.authenticated()
	.and()
	.exceptionHandling()
	.authenticationEntryPoint(unauthorisedHandler)
	.and()
	.sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	
	http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	
}

@Override
	protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(UserDetailsServiceimpl).passwordEncoder(passwordEncoder());

	
}

}
