package com.tanghaohang.bs.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanghaohang.bs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
