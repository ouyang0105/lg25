package com.cssl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {


   private Integer id;
   private String name;
   private String sex;
   private  Integer age;
}
