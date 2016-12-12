package pl.kurs.spring.aop.service.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.annotation.CheckNegativeNumbers;
import pl.kurs.spring.aop.annotation.CountTime;
import pl.kurs.spring.aop.annotation.LogToFile;
import pl.kurs.spring.aop.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	@LogToFile("addition.txt")
	@CountTime
	public double add(double a, double b) {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a + b;
	}

	@Override
	@LogToFile("subtraction.txt")
	@CheckNegativeNumbers
	public double subtract(double a, double b) {
		return a - b;
	}

	@Override
	@LogToFile("multiplication.txt")
	public double multiply(double a, double b) {
		return a * b;
	}

	@Override
	@LogToFile("division.txt")
	@CheckNegativeNumbers
	public Double divide(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Nie wolno dzielic przez zero");
		}
		return a / b;
	}

}
