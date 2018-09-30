package myspring.di.xml;

public class StringPrinter implements Printer {
	public StringBuffer buffer = new StringBuffer();
	
	public void print(String message) {
		buffer.append(message);
		
	}
	
	public String toString(){
		return buffer.toString();
	}
}
