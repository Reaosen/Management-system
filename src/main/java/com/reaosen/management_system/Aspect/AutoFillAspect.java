package com.reaosen.management_system.Aspect;

import com.reaosen.management_system.Annotation.AutoFill;
import com.reaosen.management_system.Enumeration.OperationType;
import jdk.jshell.MethodSnippet;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    // 切入点
    @Pointcut("execution(* com.reaosen.management_system.Service.*.*(..)) " +
            "&& @annotation(com.reaosen.management_system.Annotation.AutoFill)")
    public void autoFillPointCut() {
    }

    // 前置通知
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("开始进行公共字段自动填充...");

        // 获取操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();
        // 获取拦截方法的参数
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];

        // 时间
        long timeStepMillis = System.currentTimeMillis();
        Integer timeStep = Math.toIntExact(timeStepMillis / 1000);

        // 修改
        if (operationType == OperationType.INSERT) {
            try {
                Method setGmtCreate = entity.getClass().getDeclaredMethod("setGmtCreate", Integer.class);
                Method setGmtModified = entity.getClass().getDeclaredMethod("setGmtModified", Integer.class);

                setGmtCreate.invoke(entity, timeStep);
                setGmtModified.invoke(entity, timeStep);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (operationType == OperationType.UPDATE) {
            Method setGmtModified = null;
            try {
                setGmtModified = entity.getClass().getDeclaredMethod("setGmtModified", Integer.class);
                setGmtModified.invoke(entity, timeStep);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }


    }
}
