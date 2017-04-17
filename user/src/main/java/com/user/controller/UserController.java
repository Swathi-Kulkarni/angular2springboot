package com.user.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.LoanTypeEnum;
import com.user.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/second")
public class UserController {

	public static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// -------------------Validate
	// User---------------------------------------------
	
	@ResponseBody
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<LoanTypeEnum> validateUser(@RequestBody User user)
			throws IOException {
		System.out.println(user.getName() + "********");
		LoanTypeEnum isEligible = null;
		if (user != null) {
			isEligible = userService.validateUserEligibilityForLoan(user);
		}
		return new ResponseEntity<LoanTypeEnum>(isEligible, HttpStatus.OK);
	}
}
