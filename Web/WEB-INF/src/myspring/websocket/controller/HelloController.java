package myspring.websocket.controller;

//import myspring.di.xml.Hello;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//	@Autowired
//	Hello hello;
	
	@RequestMapping("/chatting.do")
	public ModelAndView chat(ModelAndView mv){
	//	String msg = hello.sayHello();
	//	model.addAttribute("greet", msg);
		
		mv.setViewName("chattingview.jsp");
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("user name : " + user.getUsername());
		
		System.out.println("normal chat page");
		
		mv.addObject("userid", user.getUsername());
		
		return mv;
	}
}
