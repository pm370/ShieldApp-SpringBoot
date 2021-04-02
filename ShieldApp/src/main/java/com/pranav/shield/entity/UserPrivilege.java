package com.pranav.shield.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.utils.Enums.UserTypes;
import com.pranav.shield.view.JsonViews.CommonJsonView;
import com.pranav.shield.view.JsonViews.UserInfoJsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserPrivilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(CommonJsonView.class)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@JsonView(CommonJsonView.class)
	private UserTypes userType;
	
	@OneToMany(mappedBy = "userPrivilege")
	@JsonView(UserInfoJsonView.class)
	private List<UserInfo> userInfos;
	
	public void setUserInfo(UserInfo userInfo) {
		if(userInfos!=null) {
			userInfo.setUserPrivilege(this);
			userInfos.add(userInfo);
			return;
		}
		userInfos=new ArrayList<>();
		userInfo.setUserPrivilege(this);
		userInfos.add(userInfo);
	}
}
