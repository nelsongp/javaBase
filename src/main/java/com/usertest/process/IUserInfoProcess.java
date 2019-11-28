package com.usertest.process;

import java.util.List;

import com.usertest.pojo.userresponse.ReportUserAge;

public interface IUserInfoProcess {
	public List<ReportUserAge> getUserByAge(Integer pre, Integer sec);
}
