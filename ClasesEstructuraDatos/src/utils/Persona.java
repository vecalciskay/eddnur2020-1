package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import listaversionfinal.Hashable;

public class Persona implements Comparable<Persona>, Hashable {

	private String nombre;
	private Date fechaNacimiento;
	private int salario;
	
	public Persona() {
		
	}
	
	public Persona(String nombre, Date fecha, int salario) {
		this.nombre = nombre;
		this.fechaNacimiento = fecha;
		this.salario = salario;
	}
	
	public String toString() {
		return "(" + this.nombre + " - " + fechaNacimiento.toString() + " - " + String.valueOf(salario) + ")";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	@Override
	public int compareTo(Persona o) {
		// si this es menor que o --> return -1
		if (this.salario < o.getSalario())
			return -1;
		
		// si this es mayor que o --> return 1
		if (this.salario > o.getSalario())
			return 1;
		
		// si this es igual que o --> return 0
		return 0;
	}

	/**
	 * Metodo wrapper
	 */
	@Override
	public int getHash() {
		return getHash(nombre);
	}
	
	@Override
	public int getHash(String identificador) {
		int hash = 0;
		for (byte b : identificador.getBytes()) {
			int charInt = (int)b;
			hash += charInt;
		}
		hash = hash % 1000;
		
		return hash;
	}

	@Override
	public String getIdentificador() {
		return nombre;
	}

	public static Persona buildPersona(String linea) throws ParseException {
		String[] campos = new String[3];
		
		int idx0 = 0;
		campos[0] = linea.substring(0,linea.indexOf("|"));
		idx0 = campos[0].length() + 1;
		campos[1] = linea.substring(idx0,linea.indexOf("|", idx0));
		idx0 = idx0 + campos[1].length() + 1;
		campos[2] = linea.substring(idx0);
		
		Persona persona = new Persona();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		persona.fechaNacimiento = formatter.parse(campos[1]);
		persona.nombre = campos[0];
		persona.salario = Integer.parseInt(campos[2]);
		
		return persona;
	}
	
}
