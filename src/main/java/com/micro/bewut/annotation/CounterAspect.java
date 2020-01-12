package com.micro.bewut.annotation;

import com.micro.bewut.entity.MeasurementPoint;
import com.micro.bewut.service.MeasurementPointService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;

@Aspect
@Component
public class CounterAspect {

    @Autowired
    MeasurementPointService service;

    @AfterReturning("@annotation(Counter)")
    public void counter(JoinPoint joinPoint){

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Object[] args = joinPoint.getArgs();
        Map map = AnnotationProcessor.processCounterAnnotation(method, args);

        MeasurementPoint point = MeasurementPoint.builder()
                .time(LocalDateTime.now())
                .label("bookinfo")
                .data(map)
                .build();

        service.savePoint(point);

    }

}
