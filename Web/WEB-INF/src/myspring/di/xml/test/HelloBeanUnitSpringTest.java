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
		// 1. Ioc 컨테이너 생성
		context = new GenericXmlApplicationContext("config/beans.xml");
		
	}
	
	@Test
	public void test1() {
		
		// 2. Hello bean 가져오기
		Hello hello = (Hello)context.getBean("hello2");
		
		// 2-1. Hello 객체의 안에서 단독으로 실행
		Assert.assertEquals("Hello Spring", hello.sayHello());
		
		// 2-2. Hello 객체의 안에서 beans.xml에서 생성된  Printer를 참조(ref)하여 출력 
		hello.print();

		Assert.assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value:list){
			System.out.println(value);
		}
		
		// 3. StringPrinter bean 가져오기
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
