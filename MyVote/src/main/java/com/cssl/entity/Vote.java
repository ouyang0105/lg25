package com.cssl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    private Integer vid;
    private Integer userId;
    private Integer sid;
    private Integer oid;
}
