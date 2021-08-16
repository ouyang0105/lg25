package com.cssl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {


    private Integer userId;
    private String userName;
    private String passWord;
    private Integer status;
    private Integer isAdmin;
}
