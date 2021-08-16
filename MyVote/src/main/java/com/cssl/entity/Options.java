package com.cssl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Options {
    @TableId
    private Integer oid;
    private String content;
    private Integer op_sid;
}
