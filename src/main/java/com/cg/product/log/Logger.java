package com.cg.product.log;

import com.cg.product.model.Category;
import com.cg.product.service.impl.CategoryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class Logger {

    @Around("execution(public * com.cg.product.service.impl.CategoryService.*(..))")
    public Object m1(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

    @Before("execution(public * com.cg.product.controller.CategoryController.*(..))")
    public void m2() {
        System.out.println("Ok!");
    }
}
