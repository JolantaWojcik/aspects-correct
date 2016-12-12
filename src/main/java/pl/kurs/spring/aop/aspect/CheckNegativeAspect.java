package pl.kurs.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.annotation.CheckNegativeNumbers;

@Aspect
@Service
public class CheckNegativeAspect {

	@Around("@annotation(checkNegativeNumbers)")
	public Object checkNegativeNumbers(ProceedingJoinPoint joinPoint, CheckNegativeNumbers checkNegativeNumbers)
			throws Throwable {
		double[] args = convertToDouble(joinPoint.getArgs());
		boolean hasNegatives = false;
		for (double arg : args) {
			if (arg < 0) {
				hasNegatives = true;
				break;
			}
		}
		if (!hasNegatives) {
			return joinPoint.proceed();
		}
		return null;
	}

	private double[] convertToDouble(Object[] args) {
		double[] result = new double[args.length];
		for (int i = 0; i < args.length; i++) {
			result[i] = (double) args[i];
		}
		return result;
	}
}
