package com.pranav.shield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.entity.UserPrivilege;
import com.pranav.shield.pojo.UserInfoPojo;
import com.pranav.shield.repository.UserInfoRepository;
import com.pranav.shield.repository.UserPrivilegeRepository;
import com.pranav.shield.utils.Enums.UserTypes;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Autowired
	private UserPrivilegeRepository userPrivilegeRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void saveUser(UserInfoPojo userInfoPojo) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(userInfoPojo.getName());
		userInfo.setUsername(userInfoPojo.getUsername());
		userInfo.setPassword(passwordEncoder.encode(userInfoPojo.getPassword()));
		UserPrivilege userPrivilege = userPrivilegeRepo.findByUserType(userInfoPojo.getUserType());
		userInfo.setUserPrivilege(userPrivilege);
		userInfoRepo.save(userInfo);
	}

	public UserInfo getUserById(Long id) {
		return userInfoRepo.findById(id).get();
	}

	public String getUserType(Long id) {
		return userPrivilegeRepo.findUserTypeById(userInfoRepo.findUserTypeId(id));
	}
}
