package com.usertest.pojo.userresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportUserAge {
	private String userName;
	private String usrFirstName;
	private String usrLastName;
	private Integer age;
}
