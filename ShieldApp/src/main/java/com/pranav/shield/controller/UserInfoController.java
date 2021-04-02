package com.pranav.shield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.pojo.UserInfoPojo;
import com.pranav.shield.service.UserInfoService;
import com.pranav.shield.view.JsonViews.CommonJsonView;
import com.pranav.shield.view.JsonViews.UserPrivilegeJsonView;

@RestController
@RequestMapping("/user/info")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/saveUser")
	public void saveUser(@RequestBody UserInfoPojo userInfoPojo) {
		userInfoService.saveUser(userInfoPojo);
	}
	
	@GetMapping("/view/{id}")
	@JsonView(CommonJsonView.class)
	public UserInfo getUserById(@PathVariable Long id) {
		return userInfoService.getUserById(id);
	}
	
	@GetMapping("/view/userType/{id}")
	@JsonView(UserPrivilegeJsonView.class)
	public String getUserType(@PathVariable Long id) {
		return userInfoService.getUserType(id);
	}
}
