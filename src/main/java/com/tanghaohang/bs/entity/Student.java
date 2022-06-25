package com.tanghaohang.bs.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("student")
public class Student {
    @TableId
    private String id;

    private String name;
    private String sex;
    private Integer year;
    private String major;
    private String cls;
    private String tel;

    //@TableField(字段名) 指定数据表中的字段与该注解注解的变量绑定

    @TableField(exist = false)
    private List<State> state;
}
