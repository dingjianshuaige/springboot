package com.tanghaohang.bs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("user")
public class User {

    @TableId
    private String username;
    private String password;
    private String name;

}
