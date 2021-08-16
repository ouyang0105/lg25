package com.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Document
@EqualsAndHashCode(of="id")
public class Users implements Serializable {
    //新增返回新增后对象
    @TableId(value = "id", type = IdType.AUTO)
    @Indexed
    @MongoId
    private Integer id;
    private String name;
    private String sex;

    private Integer age;
}
