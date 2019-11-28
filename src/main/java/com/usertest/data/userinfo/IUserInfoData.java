package com.usertest.data.userinfo;

import java.util.List;

import com.usertest.entity.UserInfo;

public interface IUserInfoData {
	public Boolean saveUserInfoData(UserInfo userInfo);
	public List<UserInfo> getUserByAge(Integer pre, Integer sec);
}
