package com.tanghaohang.bs.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Date;


@Data
@TableName("records")
public class Records {
    @TableId
    private String num;

    private String id;
    private String name;
    private String major;
    private String cls;
    private String blinks;
    private String yawning;
    private String state;

    @TableField("time")
    private LocalDateTime time;

    @TableField("time")
    private Time times;

    @TableField("time")
    private Date date;

}
