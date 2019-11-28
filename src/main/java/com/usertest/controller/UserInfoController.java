package com.usertest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usertest.pojo.userresponse.ReportUserAge;
import com.usertest.process.IUserInfoProcess;

@RestController
public class UserInfoController {
	private IUserInfoProcess process;
	
	public UserInfoController(IUserInfoProcess process) {
		this.process = process;
	}
	
	@GetMapping("${config.endpoints.usuarios-info.range}")
	public List<ReportUserAge> getListUser(
			@PathVariable("pre") Integer pre,
			@PathVariable("sec") Integer sec){
		return process.getUserByAge(pre, sec);
	}
}
