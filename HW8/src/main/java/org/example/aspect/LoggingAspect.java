package org.example.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.model.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * Аспект для ведения журнала вызовов методов и измерения времени выполнения.
 */
@Aspect
@Component
@Log
public class LoggingAspect {

    /**
     * Ведет журнал вызова метода, украшает вызов метода и ведет журнал завершения украшения метода.
     * Выполняется перед методом saveUser из UserService.
     *
     * @param joinPoint ProceedingJoinPoint, представляющий перехватываемый метод.
     * @return Объект, возвращаемый перехваченным методом.
     * @throws Throwable если перехваченный метод генерирует исключение.
     */
    @Around("execution(* org.example.service.UserService.saveUser(..))")
    @Order(1)
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        System.out.println("\nМетод '" + methodName + "' будет выполнен с параметрами: " + Arrays.asList(arguments) + ".");
        System.out.println("Начато украшение метода.");

        User user = new User();
        user.setFirstName("Михаил");
        user.setLastName("Смирнов");

        Object[] newArguments = {user};
        Object returnedByMethod = joinPoint.proceed(newArguments);
        System.out.println("Завершено украшение метода.");

        return returnedByMethod;
    }

    /**
     * Ведет журнал времени выполнения аннотированных методов.
     *
     * @param joinPoint ProceedingJoinPoint, представляющий перехватываемый метод.
     * @return Объект, возвращаемый перехваченным методом.
     * @throws Throwable если перехваченный метод генерирует исключение.
     */
    @Around("@annotation(org.example.aspect.TrackUserAction)")
    @Order(2)
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Метод '" + joinPoint.getSignature().getName() + "' выполнен за " + executionTime + " мс.");
        return proceed;
    }
}