package com.tanghaohang.bs.controller;

import cn.hutool.core.util.StrUtil;
import com.tanghaohang.bs.common.Constants;
import com.tanghaohang.bs.common.Result;
import com.tanghaohang.bs.controller.dto.UserDTO;
import com.tanghaohang.bs.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {

        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) ||StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        UserDTO login = userService.login(userDTO);
        return Result.success(login);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){

        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) ||StrUtil.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success(userService.register(userDTO));
    }


}
