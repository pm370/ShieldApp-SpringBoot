package com.pranav.shield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.shield.entity.UserPrivilege;
import com.pranav.shield.pojo.UserPrivilegePojo;
import com.pranav.shield.repository.UserPrivilegeRepository;
import com.pranav.shield.utils.Enums.UserTypes;

@Service
public class UserPrivilegeService {

	@Autowired
	private UserPrivilegeRepository userPrivilegeRepo;

	public void saveUserType(UserPrivilegePojo userPrivilegePojo) {
		UserPrivilege userPrivilege = new UserPrivilege();
		userPrivilege.setUserType(userPrivilegePojo.getUserType());

		userPrivilegeRepo.save(userPrivilege);
	}
}
