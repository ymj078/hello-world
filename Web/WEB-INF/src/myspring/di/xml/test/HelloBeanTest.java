package myspring.di.xml.test;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// 1. Ioc �����̳� ����
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		
		// 2. Hello bean ��������
		Hello hello = (Hello)context.getBean("hello");
		
		// 2-1. Hello ��ü�� �ȿ��� �ܵ����� ����
		System.out.println(hello.sayHello());
		
		// 2-2. Hello ��ü�� �ȿ��� beans.xml���� ������  Printer�� ����(ref)�Ͽ� ��� 
		hello.print();

		
		// 3. StringPrinter bean ��������
		Printer printer = context.getBean("printer", Printer.class);
		System.out.println(printer.toString());
			
		Hello hello2 = context.getBean("hello", Hello.class);
		
		System.out.println(hello == hello2);
	}

}
