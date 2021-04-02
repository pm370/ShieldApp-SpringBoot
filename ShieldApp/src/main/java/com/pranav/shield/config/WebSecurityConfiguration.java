package com.pranav.shield.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pranav.shield.repository.UserInfoRepository;
import com.pranav.shield.security.JpaUserDetailService;
import com.pranav.shield.service.UserContactDetailService;
import com.pranav.shield.utils.Enums.UserTypes;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserInfoRepository userInfoRepo;
	
	@Bean
	protected UserDetailsService userDetailsService() {
		return new JpaUserDetailService(userInfoRepo);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic();
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/user/privilege/save/type").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/user/info/saveUser").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/user/info/view/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/user/info/view/userType/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/user/contact/save").hasAnyAuthority(UserTypes.DIRECTOR.name(), UserTypes.AVENGER.name())
		.antMatchers("/user/contact/view/{id}").hasAnyAuthority(UserTypes.DIRECTOR.name(), UserTypes.AVENGER.name())
		.antMatchers("/user/contact/view/{username}").hasAnyAuthority(UserTypes.DIRECTOR.name(), UserTypes.AVENGER.name())
		.antMatchers("/user/contact/update/contactInfo/{id}").hasAnyAuthority(UserTypes.DIRECTOR.name(), UserTypes.AVENGER.name())
		.antMatchers("/user/contact/update/notificationChannel/{id}").hasAnyAuthority(UserTypes.DIRECTOR.name(), UserTypes.AVENGER.name())
		.antMatchers("/user/contact/update/user/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/user/contact/update/contactDetails/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/assign").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/view/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/view/all").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/status/{username}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/view/pending").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/view/completed").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/update/title/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/update/details/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/mission/update/status/{id}").hasAnyAuthority(UserTypes.DIRECTOR.name(), UserTypes.AVENGER.name())
		.antMatchers("/notification/save").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/notification/view/all").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/notification/view/{id}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/notification/view/{contactDetail}").hasAuthority(UserTypes.DIRECTOR.name())
		.antMatchers("/notification/view/{username}").hasAuthority(UserTypes.DIRECTOR.name())
		.anyRequest().fullyAuthenticated().and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
