package myspring.di.xml;

import java.util.List;

public class Hello {
	
	public Hello(){	}
	
	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}

	private String name;
	private Printer printer;
	private List<String> names;
	
	public void setNames(List<String> names) {
		this.names = names;
	}
	
	
	public List<String> getNames() {
		return names;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello(){
		return "Hello " + name;
	}
	
	public void print(){
		this.printer.print(sayHello());
	}
}
