package com.xiaoqi.cloudss.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * AOP面向切面编程
 * 用于计算方法耗时
 */
@Component
@Aspect
@Slf4j
public class ConsumeAspect {

    @Around("execution(* com.xiaoqi.cloudss.controller.*.*(..))")
    public Object controllerConsume(ProceedingJoinPoint pjd) throws Throwable {
        long begin = System.currentTimeMillis();
        String method = pjd.getSignature().getName();
        String clazz = pjd.getTarget().getClass().getName();
        String argInfo = "";
        Object[] args = pjd.getArgs();
        if (args != null) {
            argInfo = Arrays.toString(args);
        }
        Object ret = pjd.proceed();
        long end = System.currentTimeMillis();
        long consume = end - begin;

        // log.warn(String.format("Controller耗时0级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        if (consume >= 30_000L) {
            log.warn(String.format("Controller耗时4级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        } else if (consume >= 20_000L) {
            log.warn(String.format("Controller耗时3级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        } else if (consume >= 10_000L) {
            log.warn(String.format("Controller耗时2级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        } else if (consume >= 5_000L) {
            log.warn(String.format("Controller耗时1级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        }
        return ret;
    }

    @Around("execution(* com.xiaoqi.cloudss.service.impl.*Service*.*(..))")
    public Object serviceConsume(ProceedingJoinPoint pjd) throws Throwable {
        long begin = System.currentTimeMillis();
        String method = pjd.getSignature().getName();
        String clazz = pjd.getTarget().getClass().getName();
        String argInfo = "";
        Object[] args = pjd.getArgs();
        if (args != null) {
            argInfo = Arrays.toString(args);
        }
        Object ret = pjd.proceed();
        long end = System.currentTimeMillis();
        long consume = end - begin;

        // log.warn(String.format("Service耗时0级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        if (consume >= 30_000L) {
            log.warn(String.format("Service耗时4级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        } else if (consume >= 20_000L) {
            log.warn(String.format("Service耗时3级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        } else if (consume >= 10_000L) {
            log.warn(String.format("Service耗时2级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        } else if (consume >= 5_000L) {
            log.warn(String.format("Service耗时1级警告：%sms，参数：%s, %s, %s", consume, clazz, method, argInfo));
        }
        return ret;
    }
}
