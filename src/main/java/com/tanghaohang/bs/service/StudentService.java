package com.tanghaohang.bs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tanghaohang.bs.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    public boolean saveStudent(Student student);

    List<Student> duobiao(String id);

    void trans();

}
