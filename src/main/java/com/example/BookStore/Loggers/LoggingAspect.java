package com.example.BookStore.Loggers;


import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Pointcut;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Define pointcuts for the methods to be logged
    @Pointcut("execution(* com.example.BookStore.Services.BookService.*(..))")
    public void bookServiceMethods() {}

    @Pointcut("execution(* com.example.BookStore.Services.PatronService.*(..))")
    public void patronServiceMethods() {}
    @Pointcut("execution(* com.example.BookStore.Services.BorrowBookService.*(..))")
    public void borrowBookServiceMethods() {}

    // Log method execution
    @Around("bookServiceMethods() || patronServiceMethods() || borrowBookServiceMethods()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Log method entry
        logger.info("Entering method: " + joinPoint.getSignature().toShortString());

        Object result;
        try {
            result = joinPoint.proceed(); // Proceed with method execution
        } catch (Exception e) {
            // Log exceptions
            logger.error("Exception in method: " + joinPoint.getSignature().toShortString(), e);
            throw e; // Rethrow the exception
        }

        long elapsedTime = System.currentTimeMillis() - start;
        // Log method exit and execution time
        logger.info("Exiting method: " + joinPoint.getSignature().toShortString() + " with execution time: " + elapsedTime + " ms");

        return result;
    }
}
