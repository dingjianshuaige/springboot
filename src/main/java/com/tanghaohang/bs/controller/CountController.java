package com.tanghaohang.bs.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanghaohang.bs.common.Result;
import com.tanghaohang.bs.entity.Records;
import com.tanghaohang.bs.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/count")
public class CountController {

    @Autowired
    private RecordsService recordsService;

    @GetMapping("/example")
    public Result get() {
        Map<String, Object> map = new HashMap<>();
        map.put("x", CollUtil.newArrayList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
        map.put("y", CollUtil.newArrayList(150, 230, 224, 218, 135, 147, 260));
        return Result.success(map);
    }

    @GetMapping("/class")
    public Result members(@RequestParam(defaultValue = "") String major,
                          @RequestParam(defaultValue = "") String cls) {
        QueryWrapper<Records> queryWrapper = new QueryWrapper<>();
        if (!"".equals(major)) {
            queryWrapper.like("major", major);
        }
        if (!"".equals(cls)) {
            queryWrapper.like("cls", cls);
        }
        List<Records> list = recordsService.list(queryWrapper);
        int c1 = 0; // 第一节课
        int c2 = 0; // 第二节课
        int c3 = 0; // 第三节课
        int c4 = 0; // 第四节课
        int c5= 0; //第五节课
        for (Records records : list) {
            Time time = records.getTimes();
            switch (recordsService.belongtime(time)){
                case 1: c1 += 1; break;
                case 2: c2 += 1; break;
                case 3: c3 += 1; break;
                case 4: c4 += 1; break;
                case 5: c5 += 1; break;
                default: break;
            }

        }
        return Result.success(CollUtil.newArrayList(c1, c2, c3, c4 ,c5));
    }

}
