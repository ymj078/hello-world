package myspring.user.controller;

import myspring.di.xml.Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@Autowired
	Hello hello;
	
	@RequestMapping("/hello.do")
	public String hello(Model model){
		String msg = hello.sayHello();
		model.addAttribute("greet", msg);
		
		return "hello.jsp";
	}
}
