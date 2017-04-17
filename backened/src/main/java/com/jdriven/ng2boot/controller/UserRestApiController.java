package com.jdriven.ng2boot.controller;
 
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdriven.ng2boot.model.User;
import com.jdriven.ng2boot.service.UserService;

 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserRestApiController {
 
    public static final Logger logger = LoggerFactory.getLogger(UserRestApiController.class);
 
    @Autowired
 private   UserService userService; //Service which will do all data retrieval/manipulation work
 
    // -------------------Validate User---------------------------------------------
 
    
    @ResponseBody
    @RequestMapping(value = "/user/", method = RequestMethod.POST,produces={"application/json"},consumes={"application/json"})
    public ResponseEntity<String> validateUser(@RequestBody User user) throws IOException {
    	System.out.println(user.getName()+"********");
    	ResponseEntity<String>  isEligible=null;
    	if(user!=null){
    		  isEligible = userService.validateUser(user);
    	}
    	HttpHeaders headers = addAccessControllAllowOrigin();
            return isEligible;
    }
    private HttpHeaders addAccessControllAllowOrigin() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }

}
