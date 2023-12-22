package com.kh.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //매개변수 없는 생성자
@AllArgsConstructor   //매개변수 다 있는 생성자
@Builder
@Getter
@Setter
@ToString
public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String birthday;
	private String gender;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;

}
