package redes.circulo;

public abstract class ComandoCirculo {

	protected String comando;
	protected String argumentos;
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public String getArgumentos() {
		return argumentos;
	}
	public void setArgumentos(String argumentos) {
		this.argumentos = argumentos;
	}
	
	public String toString() {
		return ("Es un comando " + comando + " con arg " + argumentos);
	}
}
