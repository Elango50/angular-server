package com.user.details.user.controller;


import com.user.details.user.model.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

	@GetMapping("/users/{name}")
	public List<UserDetails> getUserDetails(@PathVariable String name) {
	    System.out.println("get User called.....");
    List user = new ArrayList();
    UserDetails userDetail = new UserDetails();
    userDetail.setDepartment("Testing");
    userDetail.setName("test");
    userDetail.setId(45785);
    userDetail.setSalary(1000);
    user.add(userDetail);

	return user;
		//return studentRepository.findAll();
	}



}
