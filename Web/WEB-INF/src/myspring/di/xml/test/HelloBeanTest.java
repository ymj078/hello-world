package myspring.di.xml.test;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// 1. Ioc 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		
		// 2. Hello bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		
		// 2-1. Hello 객체의 안에서 단독으로 실행
		System.out.println(hello.sayHello());
		
		// 2-2. Hello 객체의 안에서 beans.xml에서 생성된  Printer를 참조(ref)하여 출력 
		hello.print();

		
		// 3. StringPrinter bean 가져오기
		Printer printer = context.getBean("printer", Printer.class);
		System.out.println(printer.toString());
			
		Hello hello2 = context.getBean("hello", Hello.class);
		
		System.out.println(hello == hello2);
	}

}
