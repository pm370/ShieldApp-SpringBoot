package com.pranav.shield.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.pranav.shield.entity.Mission;
import com.pranav.shield.pojo.MissionPojo;
import com.pranav.shield.service.MissionService;
import com.pranav.shield.view.JsonViews.CommonJsonView;
import com.pranav.shield.view.JsonViews.UserInfoJsonView;

@RestController
@RequestMapping("/mission")
public class MissionController {

	@Autowired
	private MissionService missionService;
	
	@PostMapping("/assign")
	public void assignMission(@RequestBody MissionPojo missionPojo) {
		missionService.assignMission(missionPojo);
	}
	
	@GetMapping("/view/{id}")
	@JsonView(CommonJsonView.class)
	public Mission viewMissionById(@PathVariable("id") Long id) {
		return missionService.viewMissionById(id);
	}
	
	@GetMapping("/view/all")
	@JsonView(CommonJsonView.class)
	public List<Mission> viewAllMissions() {
		return missionService.viewAllMissions();
	}
	
	@GetMapping("/view/{id}/status")
	@JsonView(CommonJsonView.class)
	public String viewMissionStatusById(@PathVariable("id") Long id) {
		return missionService.viewMissionStatusById(id);
	}
	
	@GetMapping("/view/status/{username}")
	@JsonView(UserInfoJsonView.class)
	public List<Mission> viewMissionsStatusByUser(@PathVariable("username") String username) {
		return missionService.viewMissionsStatusByUser(username);
	}
	
	@GetMapping("/view/pending")
	@JsonView(CommonJsonView.class)
	public List<Mission> viewPendingMissions() {
		return missionService.viewPendingMissions();
	}
	
	@GetMapping("/view/completed")
	@JsonView(CommonJsonView.class)
	public List<Mission> viewCompletedMissions() {
		return missionService.viewCompletedMissions();
	}
	
	@PutMapping("/update/title/{id}")
	public void updateMissionTitle(@RequestBody MissionPojo missionPojo, @PathVariable("id") Long id) {
		missionService.updateMissionTitle(missionPojo, id);
	}
	
	@PutMapping("/update/details/{id}")
	public void updateMissionDetails(@RequestBody MissionPojo missionPojo, @PathVariable("id") Long id) {
		missionService.updateMissionDetails(missionPojo, id);
	}
	
	@PutMapping("/update/status/{id}")
	public void updateMissionStatus(@RequestBody MissionPojo missionPojo, @PathVariable("id") Long id) {
		missionService.updateMissionStatus(missionPojo, id);
	}
	

	
}
