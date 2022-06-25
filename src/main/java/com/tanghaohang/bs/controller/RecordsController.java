package com.tanghaohang.bs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.corba.se.impl.protocol.giopmsgheaders.ReplyMessage_1_0;
import com.tanghaohang.bs.entity.Records;
import com.tanghaohang.bs.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordsController {


    @Autowired
    private RecordsService recordsService;

    @GetMapping("/count")
    public long count(@RequestParam(defaultValue = "") String major,
                      @RequestParam(defaultValue = "") String cls){
        QueryWrapper<Records> queryWrapper = new QueryWrapper<>();
        if (!"".equals(major)) {
            queryWrapper.like("major", major);
        }
        if (!"".equals(cls)) {
            queryWrapper.like("cls", cls);
        }
        return  recordsService.count(queryWrapper);
    }


    @GetMapping("/")
    public List<Records> findAll() {
        return recordsService.list();
    }

    @GetMapping("/page")
    public IPage<Records> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String id,
                                   @RequestParam(defaultValue = "") String major) {
        IPage<Records> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Records> queryWrapper = new QueryWrapper<>();
        if (!"".equals(id)) {
            queryWrapper.like("id", id);
        }
        if (!"".equals(major)) {
            queryWrapper.like("major", major);
        }

        return recordsService.page(page, queryWrapper);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<String> ids) { // [1,2,3]
        return recordsService.removeByIds(ids);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id) {

        return recordsService.removeById(id);
    }
}