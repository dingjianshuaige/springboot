package com.tanghaohang.bs.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanghaohang.bs.entity.State;
import com.tanghaohang.bs.mapper.StateMapper;
import com.tanghaohang.bs.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements StateService  {
    //最开始没有实现stateservice接口，导致controller扫描不到接口的bean浪费我好多时间，何其愚蠢

    @Autowired
    private StateMapper stateMapper;


    @Override
    public int resetnum(String id) {
        
        return stateMapper.resetnum(id);
    }

}
