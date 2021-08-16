package com.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    @TableId(value = "empno")
    private Integer empno;
    private String ename;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    private Integer sal;
    private  Integer deptno;
    @TableField(exist = false)
    private Dept dept;

}
