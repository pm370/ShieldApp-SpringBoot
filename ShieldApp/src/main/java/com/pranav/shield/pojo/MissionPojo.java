package com.pranav.shield.pojo;

import com.pranav.shield.utils.Enums.MissionStatus;
import com.pranav.shield.utils.Enums.NotificationChannels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionPojo {

	private String title;
	
	private String details;
	
	private MissionStatus status;
	
	private String name;
	
	private NotificationChannels channel;
}
