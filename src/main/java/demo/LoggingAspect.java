package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect  // this is some aspect of our program (eg logging aspect)
@Component
public class LoggingAspect {
/*
* these are used to define where we want ot define & what we want to define
* */
    @Before("execution(* demo.ShoppingCart.checkout(..))") //before calling this(checkout), run this(beforeLogger) method
    public void beforeLogger(JoinPoint jp) {
        //System.out.println(jp.getSignature());//to get signature of the method being called
        System.out.println("Before Logger : "+ jp.getArgs()[0].toString());
    }

    @After("execution(* *.*.checkout(..))") // after this point run this
    public void afterLogger() {
        System.out.println("After Logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))") //at this pointcut run this method
    public void afterReturningPointCut() {}

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    // returning= means return value..will return to "retVal" variable
    // that's been passed as an input here
    public void afterReturning(int retVal) {
        System.out.println("After Returning : " + retVal);
    }
}
