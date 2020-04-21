package hanoi;

import java.util.Stack;

public class Torre {

	private Stack anillos;
	
	public Torre() {
		anillos = new Stack();
	}
	
	public Torre(int n) {
		anillos = new Stack();
		
		for(int i=n; i>0; i--) {
			Anillo a = new Anillo(i);
			anillos.push(a);
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		for(Object o : anillos) {
			result.append(o);
			result.append("-");
		}
		
		return result.toString();
	}

	public Anillo sacar() {
		return (Anillo)(anillos.pop());
	}
	
	public void meter(Anillo a) {
		anillos.push(a);
	}

	public Stack getAnillos() {
		return anillos;
	}
}
