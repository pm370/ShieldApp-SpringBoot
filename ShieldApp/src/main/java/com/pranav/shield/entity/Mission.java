package com.pranav.shield.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.utils.Enums.MissionStatus;
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
public class Mission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(CommonJsonView.class)
	private Long id;
	
	@JsonView(CommonJsonView.class)
	private String title;
	
	@JsonView(CommonJsonView.class)
	private String details;
	
	@Enumerated(EnumType.STRING)
	@JsonView(CommonJsonView.class)
	private MissionStatus status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="assign_to", referencedColumnName = "id")
	@JsonView(UserInfoJsonView.class)
	private UserInfo userInfo;
}
