package lista.test;

import listaversionfinal.Cola;

public class TestCOla {
	public static void main(String[] args) {
		Cola<String> p = new Cola<String>();

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
