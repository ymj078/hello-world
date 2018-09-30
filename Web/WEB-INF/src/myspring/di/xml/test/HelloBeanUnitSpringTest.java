package myspring.di.xml.test;

import java.util.List;

import junit.framework.Assert;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanUnitSpringTest {

	ApplicationContext context;
	
	@Before
	public void init(){
		// 1. Ioc �����̳� ����
		context = new GenericXmlApplicationContext("config/beans.xml");
		
	}
	
	@Test
	public void test1() {
		
		// 2. Hello bean ��������
		Hello hello = (Hello)context.getBean("hello2");
		
		// 2-1. Hello ��ü�� �ȿ��� �ܵ����� ����
		Assert.assertEquals("Hello Spring", hello.sayHello());
		
		// 2-2. Hello ��ü�� �ȿ��� beans.xml���� ������  Printer�� ����(ref)�Ͽ� ��� 
		hello.print();

		Assert.assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value:list){
			System.out.println(value);
		}
		
		// 3. StringPrinter bean ��������
		Printer printer = context.getBean("printer", Printer.class);
		Assert.assertEquals("Hello Spring", printer.toString());
			
		Hello hello2 = context.getBean("hello", Hello.class);
		
		System.out.println(hello == hello2);
	}

	@Test
	public void test2(){
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		Assert.assertSame(hello, hello2);
	}
}
