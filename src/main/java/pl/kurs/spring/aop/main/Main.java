package pl.kurs.spring.aop.main;

import org.omg.IOP.TransactionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.kurs.spring.aop.service.CalculatorService;
import pl.kurs.spring.aop.service.TranslationService;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		TranslationService translationEnglish = context.getBean("english", TranslationService.class);
		System.out.println(translationEnglish.translate("tak"));
//		System.out.println(translationEnglish.translate("nie"));
//		System.out.println(translationEnglish.translate("dlaczego"));
//		
//		TranslationService translationGerman = context.getBean("german", TranslationService.class);
//		System.out.println(translationGerman.translate("tak"));
//		System.out.println(translationGerman.translate("nie"));
//		System.out.println(translationGerman.translate("dlaczego"));
		
		CalculatorService calculator = context.getBean(CalculatorService.class);
		
		//System.out.println(calculator.add(5, -10));
		//System.out.println(calculator.divide(10, 903));
		System.out.println(calculator.subtract(100, -90));
		
		/*
		 * Stworz adnotacje @CountTime, ktora mozna stawiac przy metodach i wykonuje sie ona w fazie RunTime
		 * adnotacja ta powinna byc obslugiwana przez aspekt CountTimeAspekt
		 * ktory uzywa advice typu Around i jej zadaniem jest wypisywanie na konsoli informacji jak dlugo 
		 * dana metoda sie wykonywala 
		 * w ms
		 * np:
		 * metoda divide z klasy CalculatorService wykonywala sie 1ms.
		 */

	}
}
