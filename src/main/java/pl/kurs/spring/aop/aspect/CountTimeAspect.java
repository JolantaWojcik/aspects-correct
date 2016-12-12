package pl.kurs.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.annotation.CountTime;

@Service
@Aspect
public class CountTimeAspect {
	
	@Around("@annotation(countTime)")
	public Object countTime(ProceedingJoinPoint pjp, CountTime countTime) throws Throwable{
		long start = System.currentTimeMillis();
		Object result = pjp.proceed();
		long time = System.currentTimeMillis()-start;
		System.out.println("metoda: "+pjp.getSignature().getName()+" wykonała sie w czasie: "+time+" ms");
		return result;
	}
}
