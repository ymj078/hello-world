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
		
		// 2. Hello bean ��������
		Hello hello = (Hello)context.getBean("hello");
		
		// 2-1. Hello ��ü�� �ȿ��� �ܵ����� ����
		Assert.assertEquals("Hello Spring", hello.sayHello());
		
		// 2-2. Hello ��ü�� �ȿ��� beans.xml���� ������  Printer�� ����(ref)�Ͽ� ��� 
		hello.print();

		
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
