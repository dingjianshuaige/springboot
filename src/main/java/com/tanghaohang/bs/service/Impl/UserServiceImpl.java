package com.tanghaohang.bs.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanghaohang.bs.common.Constants;
import com.tanghaohang.bs.controller.dto.UserDTO;
import com.tanghaohang.bs.entity.User;
import com.tanghaohang.bs.excpetion.ServiceException;
import com.tanghaohang.bs.mapper.UserMapper;
import com.tanghaohang.bs.service.UserService;
import com.tanghaohang.bs.utils.TokenUtils;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public UserDTO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one = getOne(queryWrapper); // 从数据库查询用户信息
        if (one != null) {
            BeanUtil.copyProperties(one, userDTO, true);
            String token = TokenUtils.genToken(one.getUsername().toString(),one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        //queryWrapper.eq("password", userDTO.getPassword());
        User one = getOne(queryWrapper);;// 从数据库查询用户信息
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

}