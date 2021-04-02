package com.pranav.shield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.shield.pojo.UserPrivilegePojo;
import com.pranav.shield.service.UserPrivilegeService;

@RestController
@RequestMapping("/user/privilege")
public class UserPrivilegeController {

	@Autowired
	private UserPrivilegeService userPrivilegeService;
	
	@PostMapping("/save/type")
	public void saveUserType(@RequestBody UserPrivilegePojo userPrivilegePojo) {
		userPrivilegeService.saveUserType(userPrivilegePojo);
	}
}
