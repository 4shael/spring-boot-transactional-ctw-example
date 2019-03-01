package my.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

    @Before("execution(* save(..)) && !within(my.test.DemoAspect)")
    public void logEnter(JoinPoint joinPoint) {
        System.out.print(joinPoint.getStaticPart());
        System.out.print(" -> ");
        System.out.println(joinPoint.getSignature());
    }
}
