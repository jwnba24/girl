package com.jw.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * aop的类
 * Created by Administrator on 2017/5/10.
 */
@Aspect
@Component
public class HttpAspect {

    Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.jw.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获取请求的上下文对象
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName());

        //参数
        logger.info("class_args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        System.out.println("结束时候输出的信息！");
    }

    @AfterReturning(returning ="obj",pointcut = "log()")
    public void doAfterReturn(Object obj){
        logger.info("response={}",obj);
    }

}
