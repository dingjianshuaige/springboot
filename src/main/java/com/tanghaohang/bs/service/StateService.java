package com.tanghaohang.bs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tanghaohang.bs.entity.State;

public interface StateService extends IService<State> {
    int resetnum(String id);
}
