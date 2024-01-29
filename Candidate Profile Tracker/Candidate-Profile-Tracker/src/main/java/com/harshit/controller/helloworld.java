package com.harshit.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {

	@RequestMapping("/hello")
    @ResponseBody
public String helloworldcontroller() {
	return "hello controller";
}
}
