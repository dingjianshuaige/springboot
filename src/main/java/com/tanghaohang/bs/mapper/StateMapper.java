package com.tanghaohang.bs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanghaohang.bs.entity.State;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StateMapper extends BaseMapper<State> {

    @Update("update stu_state set blinks = 0 ,yawning = 0 ,mild = 0,severe = 0 where id=#{id}")
    int resetnum(String id);
    /*int resetnum(@Param("id") String id);*/
}
