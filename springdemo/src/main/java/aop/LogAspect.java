package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class LogAspect {
	public LogAspect() {
		System.out.println("LogAspect()");
	}

	// Before Advice
	@Before(value = "execution (* aop.OrderService.place*(..))") // pointcut
	public void beforeAdviceMethod(JoinPoint jp) {
		//System.out.println(jp.getClass());
		System.out.println("Before Advice --> " + jp.getSignature());
	}

	@After(value = "execution (* aop.OrderService.place*(..))")
	public void afterAdviceMethod(JoinPoint jp) {
		System.out.println("After Advice --> " + jp.getSignature());
	}

	@Around(value = "execution (* aop.OrderService.cancel*(..))")
	public Object aroundAdviceMethod(ProceedingJoinPoint pjp) {
		System.out.println("Before calling : " + pjp.getSignature());
		try {
			Object obj = pjp.proceed(pjp.getArgs()); // Call method in Target Object
			System.out.println("Success : " + obj);
			return obj;
		} catch (Throwable ex) {
			System.out.println("Exception : " + ex);
			return null;
		}
	}

	// After Throwing
	//@AfterThrowing(value = "execution (* aop.OrderService.*(..))", throwing = "ex")
	public void afterThrowingAdviceMethod(JoinPoint jp, Exception ex) {
		System.out.println("After Throwing Advice --> " + jp.getSignature());
		System.out.println("Exception is : " + ex.getMessage());
	}
}
