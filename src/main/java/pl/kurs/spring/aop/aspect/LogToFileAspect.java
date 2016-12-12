package pl.kurs.spring.aop.aspect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.annotation.LogToFile;

@Aspect
@Service
public class LogToFileAspect {

	@Before("@annotation(logToFile)")
	public void saveToFile(JoinPoint joinPoint, LogToFile logToFile) {
		//"try with resource" javy 1.7
		//try(podac strumien ktory implementuje interfejs AutoCloseable)
		//jvm automatycznie zmaknie strumien bezposrednio po zrealizowaniu bloku try-catch
		//bez wzgledu na to czy wyjdzie trajem czy kaczem.
		try (BufferedWriter out = new BufferedWriter(new FileWriter(logToFile.value(), true))) {
			out.write(Arrays.toString(joinPoint.getArgs()));
			out.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
