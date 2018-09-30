package edu.iot.capricorn.model;

import java.util.Date;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	private int			seq;
	private String 		userId;
	private String 		name;
	private String 		password;
	private String 		salt;
	private UserLevel 	userLevel;
	private String 		phoneNumber;
	private String 		nickName;
	private String 		email;
	private String 		address;
	private Date 		regDate;
	private Date 		updateDate;
}
