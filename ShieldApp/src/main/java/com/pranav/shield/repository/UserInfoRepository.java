package com.pranav.shield.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pranav.shield.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	Optional<UserInfo> findByUsername(String string);
	
	@Query("select u.userPrivilege.id from UserInfo u where u.id=:id")
	Long findUserTypeId(@Param("id") Long id);
	
	@Query("select u.id from UserInfo u where u.username=:username")
	Long findIdByUsername(@Param("username") String username);

	Optional<UserInfo> findByName(String name);

	@Query("select u.id from UserInfo u where u.name=:name")
	Long findIdByName(@Param("name")String name);

}
