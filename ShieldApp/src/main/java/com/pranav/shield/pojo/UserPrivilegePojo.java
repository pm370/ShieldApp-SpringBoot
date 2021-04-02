package com.pranav.shield.pojo;

import java.util.List;

import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.utils.Enums.UserTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPrivilegePojo {

	private UserTypes userType;
	
//	private List<UserInfo> userInfos;
}
