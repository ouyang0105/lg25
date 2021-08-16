package com.cssl.vo;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersVo {
	

	private Integer id;	
	private String username;
	private String password;

}
