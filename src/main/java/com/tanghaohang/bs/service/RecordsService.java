package com.tanghaohang.bs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tanghaohang.bs.entity.Records;

import java.sql.Time;

public interface RecordsService extends IService<Records> {

    int belongtime(Time time);

}
