package tw.tedu.stock.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeElapseAspect {
	
	@Around("execution(* tw.tedu.stock.service.impl.*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		
		// 業務方法執行前
		long start = System.currentTimeMillis();
		
		Object obj = pjp.proceed();
		
		// 業務方法執行後
		long end = System.currentTimeMillis();
		System.err.println("執行時間:" + (end - start) + "ms.");
		
		return obj;
	}
	
}
