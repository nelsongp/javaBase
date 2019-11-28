package com.usertest.pojo.userresponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	private String responseCode;
	private String msg;
	private Boolean response;
}
