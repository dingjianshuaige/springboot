package com.tanghaohang.bs.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("stu_state")
public class State {

    @TableId
    private String id;
    private String name;
    private String major;
    private String cls;
    private String blinks;
    private Integer yawning;
    private Integer mild;
    private Integer severe;
}
