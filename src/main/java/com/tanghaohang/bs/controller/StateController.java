package com.tanghaohang.bs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tanghaohang.bs.entity.State;
import com.tanghaohang.bs.service.StateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Resource
    private StateService stateService;

    @GetMapping("/")
    public List<State> findAll() {
        return stateService.list();
    }

    @PutMapping("/{id}")
    public int reset(@PathVariable String id) {
        // 更新
        return stateService.resetnum(id);
    }

    @GetMapping("/page")
    public IPage<State> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String id,
                                   @RequestParam(defaultValue = "") String major ) {
        IPage<State> page = new Page<>(pageNum, pageSize);
        QueryWrapper<State> queryWrapper = new QueryWrapper<>();
        if (!"".equals(id)) {
            queryWrapper.like("id", id);
        }
        if (!"".equals(major)) {
            queryWrapper.like("major", major);
        }

        return stateService.page(page, queryWrapper);
    }
}
