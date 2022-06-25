package com.tanghaohang.bs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tanghaohang.bs.controller.dto.UserDTO;
import com.tanghaohang.bs.entity.User;

public interface UserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);
}

