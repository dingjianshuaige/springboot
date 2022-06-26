package com.tanghaohang.bs.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanghaohang.bs.entity.Student;
import com.tanghaohang.bs.mapper.StudentMapper;
import com.tanghaohang.bs.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    StudentMapper studentMapper;

    public boolean saveStudent(Student student) {

        return saveOrUpdate(student);
    }
    @Override
    public List<Student> duobiao(String id) {
        return studentMapper.duobiao(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void trans(){
        try {
            studentMapper.mtel();
            studentMapper.myear();
            int a=1/0;
            studentMapper.mtel();
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("发生错误。");
            //throw e;
            //throw new RuntimeException();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

            //对分支hot-fix的修改
        }

        //开启事务后发生异常会自动回滚，但是如果将语句用try/catch处理后就不会自动回滚，要么不使用try/catch，
        // 要么就在catch语句块之类自己抛出一个异常，或者自己在catch语句块中手动回滚。
        //手动回滚 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

}
