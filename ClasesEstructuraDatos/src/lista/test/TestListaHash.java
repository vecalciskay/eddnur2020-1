package lista.test;

import java.util.Date;
import java.util.Hashtable;

import listaversionfinal.ListaHash;
import utils.Persona;

public class TestListaHash {
	public static void main(String[] args) {
		ListaHash p = new ListaHash();
		p.insertar(new Persona("juan", new Date(), 3000));
		p.insertar(new Persona("pedro", new Date(), 2500));
		p.insertar(new Persona("alicia", new Date(), 4500));
		p.insertar(new Persona("maria", new Date(), 3500));
		
		p.insertar(new Persona("lusia", new Date(), 4500));
		p.insertar(new Persona("luisa", new Date(), 3500));

		System.out.println(p);
		
		Persona ejemploPersona = new Persona();
		Persona objPersona = (Persona)p.buscar("luisa", ejemploPersona);
		
		System.out.println(objPersona);
		
		
		Hashtable<String, Persona> personas = new Hashtable<>();
		personas.put("juan", new Persona("juan", new Date(), 3000));
		personas.put("pedro", new Persona("pedro", new Date(), 2500));
		personas.put("alicia", new Persona("alicia", new Date(), 4500));
		personas.put("maria", new Persona("maria", new Date(), 3500));
		
		objPersona = personas.get("maria");
		System.out.println(objPersona);
	}
}
