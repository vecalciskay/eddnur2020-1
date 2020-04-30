package lista.test;

import listaversionfinal.Pila;

public class TestPila {
	public static void main(String[] args) {
		Pila<String> p = new Pila<String>();

		p.push("hugo");
		p.push("paco");
		p.push("luis");

		System.out.println(p);
		
		String s;
		try {
			s = p.pop();
			System.out.println("Saco a: " + s);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
