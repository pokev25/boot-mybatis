package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.example.demo..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch(joinPoint.toString());
        stopWatch.start();
        try {
            return joinPoint.proceed();
        }finally {
            stopWatch.stop();
            //System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
            System.out.println("time:" + stopWatch.getLastTaskTimeMillis() + "ms");
            System.out.println(stopWatch.shortSummary());
        }
    }
}
