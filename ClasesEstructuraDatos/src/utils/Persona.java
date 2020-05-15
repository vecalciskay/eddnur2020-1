package utils;

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
	
	
}
