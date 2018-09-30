package myspring.di.xml.test;

import junit.framework.Assert;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanUnitTest {

	@Autowired
	ApplicationContext context;
		
	@Test
	public void test1() {
		
		// 2. Hello bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		
		// 2-1. Hello 객체의 안에서 단독으로 실행
		Assert.assertEquals("Hello Spring", hello.sayHello());
		
		// 2-2. Hello 객체의 안에서 beans.xml에서 생성된  Printer를 참조(ref)하여 출력 
		hello.print();

		
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
