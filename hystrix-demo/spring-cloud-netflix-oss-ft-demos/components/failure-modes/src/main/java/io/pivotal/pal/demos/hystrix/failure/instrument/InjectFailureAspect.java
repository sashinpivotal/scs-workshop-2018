package io.pivotal.pal.demos.hystrix.failure.instrument;

import io.pivotal.pal.demos.hystrix.failure.FailureFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;;

@Aspect
public class InjectFailureAspect {
    private final FailureFactory failureFactory;

    public InjectFailureAspect(FailureFactory failureFactory) {
        this.failureFactory = failureFactory;
    }

    @Around("@annotation(io.pivotal.pal.demos.hystrix.failure.instrument.InstrumentForFailure)")
    public Object invokeFailure(ProceedingJoinPoint joinPoint)
            throws Throwable {

        failureFactory.getFailure().execute();

        return joinPoint.proceed();
    }
}
