package com.tanghaohang.bs.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Aoptest {

    @Pointcut("execution(public * com.tanghaohang.bs.service.Impl.StudentServiceImpl.trans())")
    public void aop(){}

    @Before("aop()")
    public void before(){
        log.error("前置增强");
    }

    @After("aop()")
    public void after(){
        log.error("后置增强");
        log.info("后置增强");
    }
}
