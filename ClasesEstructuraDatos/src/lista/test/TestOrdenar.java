package lista.test;

import java.util.Date;

import listaversionfinal.ListaOrdenada;
import utils.Persona;

public class TestOrdenar {

	public static void main(String[] args) {
		ListaOrdenada<String> l = new ListaOrdenada<String>();
		
		l.insertar("juan");
		l.insertar("pedro");
		l.insertar("alicia");
		l.insertar("maria");
		
		System.out.println(l);
		
		ListaOrdenada<Persona> p = new ListaOrdenada<Persona>();
		p.insertar(new Persona("juan", new Date(), 3000));
		p.insertar(new Persona("pedro", new Date(), 2500));
		p.insertar(new Persona("alicia", new Date(), 4500));
		p.insertar(new Persona("maria", new Date(), 3500));
		
		System.out.println(p);
	}
}
