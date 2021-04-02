package com.pranav.shield.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.view.JsonViews.CommonJsonView;
import com.pranav.shield.view.JsonViews.UserContactDetailJsonView;
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
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(CommonJsonView.class)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonView(UserInfoJsonView.class)
	private UserInfo userInfo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id",referencedColumnName = "id")
	@JsonView(UserContactDetailJsonView.class)
	private UserContactDetail userContactDetail;
	
	@JsonView(CommonJsonView.class)
	private String message;
	
}
