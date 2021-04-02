package com.pranav.shield.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pranav.shield.entity.Mission;
import com.pranav.shield.entity.UserInfo;
import com.pranav.shield.utils.Enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long> {

	@Query("select m.status from Mission m where id=:id")
	String findStatusById(@Param("id") Long id);

	@Query("select m from Mission m where m.userInfo.id=:id")
	List<Mission> findMissionsByUserId(Long id);
	
	@Query("select m from Mission m where status=:status")
	List<Mission> findPendingMissions(@Param("status") MissionStatus status);
	
	@Query("select m from Mission m where status=:status")
	List<Mission> findCompletedMissions(@Param("status") MissionStatus status);
	
	@Modifying
	@Transactional
	@Query("update Mission m set m.title=:title where m.id=:id")
	void updateMissionTitle(@Param("title") String title, @Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update Mission m set m.details=:details where m.id=:id")
	void updateMissionDetails(@Param("details") String details, @Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query("update Mission m set m.status=:status where m.id=:id")
	void updateMissionStatus(@Param("status") MissionStatus status, @Param("id") Long id);

	@Query("select m from Mission m where m.userInfo.name=:name AND m.status=:pending")
	List<Mission> findByNameAndStatus(@Param("name") String name, @Param("pending") MissionStatus pending);
	
}
