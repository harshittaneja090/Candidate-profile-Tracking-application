import { Injectable } from '@angular/core';
import { LoginService } from './login.service';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HTTP_INTERCEPTORS,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';



//const TOKEN_HEADER="Authorization";

//injectable hoga to khi bhi inject kar payenge
@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private loginservice: LoginService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    //add the jwt token(loaclstorage) request

    //console.log(token)
    //let authReq = req;
    //console.log("inside interceptor")
    const token = this.loginservice.getToken();
    //putting token form local storage to header  
   // if (token != null) {}
      // console.log("inisde if condition token:",token)
      // authReq=authReq.clone({
      //   setHeaders: { Authorization: `Bearer ${token}` } ,
      // });

      
      // authReq = req.clone({
      //   headers: req.headers.append('Authorization', `Bearer ${token}`)
      // });


      

   var authReq = req.clone({
         headers: new HttpHeaders({
               Authorization:`Bearer ${token}` ,
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin":  "http://localhost:8080/api/v1/current-user",
              "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
              "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"

             })
          });

      // console.log("authrequest  header:" + authReq.headers)
    
 
 return next.handle(authReq);


    
    
    
    // const yourToken = token;

    // if (yourToken) {
    //     req = req.clone({
    //         setHeaders: {
    //             'Content-Type': 'application/json; charset=utf-8',
    //             Accept: 'application/json',
    //             Authorization: `Bearer ${yourToken}`,
    //             "Access-Control-Allow-Origin": "*"
    //         }
    //     });
    //     console.log("inisde if condition token:",token)
    // } else {
    //     req = req.clone({
    //         setHeaders: {
    //             'Content-Type': 'application/json; charset=utf-8',
    //             Accept: 'application/json',
                
    //         }
            
    //     }
    //     ,);
        
    // }

    // return next.handle(req);

    

  
  
//}
}
}

 

