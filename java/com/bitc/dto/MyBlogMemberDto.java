package com.bitc.dto;

import lombok.Data;

@Data
public class MyBlogMemberDto {

	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userPhone;
	private int userAge;
}
