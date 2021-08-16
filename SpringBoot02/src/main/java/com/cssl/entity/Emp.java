package com.cssl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer empno;
    private String ename;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    private Integer sal;
    private  String deptno;

    private Dept dept;


}
