package com.lin.test.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*Spring AOP支持的切入点指示符：
(1)execution:用来匹配执行方法的连接点
A:@Pointcut("execution(* com.lin.test.service..*.*(..))")
第一个*表示匹配任意的方法返回值，..(两个点)表示零个或多个，上面的第一个..表示service包及其子包,第二个*表示所有类,第三个*表示所有方法，第二个..表示
方法的任意参数个数
B:@Pointcut("within(com.aijava.springcode.service.*)")
within限定匹配方法的连接点,上面的就是表示匹配service包下的任意连接点

C:@Pointcut("this(com.aijava.springcode.service.UserService)")

this用来限定AOP代理必须是指定类型的实例，如上，指定了一个特定的实例，就是UserService

D:@Pointcut("bean(userService)")

bean也是非常常用的,bean可以指定IOC容器中的bean的名称
* */
@Component
@Aspect
public class AopLogAspect {
    private static final Logger logger= LoggerFactory.getLogger(AopLogAspect.class);
    @Pointcut("execution(* com.lin.test.service..*.*(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void boBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method Name : [" + methodName + "] ---> AOP before ");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method Name : [" + methodName + "] ---> AOP after ");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method Name : [" + methodName + "] ---> AOP after return ,and result is : " + result.toString());
    }

    @AfterThrowing(pointcut = "pointCut()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method Name : [" + methodName + "] ---> AOP after throwing ,and throwable message is : " + throwable.getMessage());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        try {
            logger.info("Method Name : [" + methodName + "] ---> AOP around start");
            long startTimeMillis = System.currentTimeMillis();
            //调用 proceed() 方法才会真正的执行实际被代理的方法
            Object result = joinPoint.proceed();
            long execTimeMillis = System.currentTimeMillis() - startTimeMillis;
            logger.info("Method Name : [" + methodName + "] ---> AOP method exec time millis : " + execTimeMillis);
            logger.info("Method Name : [" + methodName + "] ---> AOP around end , and result is : " + result.toString());
            return result;
        } catch (Throwable te) {
            logger.error(te.getMessage(),te);
            throw new RuntimeException(te.getMessage());
        }
    }
    /*步骤：
    * 首先，需要创建一个类，然后在类名上加上两个注解

@Component
@Aspect
@Component 注解是让这个类被spring当作一个bean管理，@Aspect 注解是标明这个类是一个切面对象

类里面每个方法的注解含义如下：

@Pointcut  用于定义切面的匹配规则，如果想要同事匹配多个的话，可以使用 || 把两个规则连接起来，具体可以参照上面的代码
@Before  目标方法执行前调用
@After  目标方法执行后调用
@AfterReturning  目标方法执行后调用，可以拿到返回结果，执行顺序在 @After 之后
@AfterThrowing  目标方法执行异常时调用
@Around  调用实际的目标方法，可以在目标方法调用前做一些操作，也可以在目标方法调用后做一些操作。使用场景有：事物管理、权限控制，日志打印、性能分析等等
以上就是各个注解的含义和作用，重点的两个注解就是 @Pointcut 和 @Around 注解，@Pointcut用来指定切面规则，决定哪些地方使用这个切面；@Around 会实际的去调用目标方法，这样就可以在目标方法的调用前后做一些处理，例如事物、权限、日志等等。

需要注意的是，这些方法的执行顺序：

执行目标方法前： 先进入 around ，再进入 before
目标方法执行完成后： 先进入 around ，再进入 after ，最后进入 afterreturning
* */
}
