package arbol;

public class Numero extends ElementoAritmetico {

	private double valor;
	
	public Numero(double v) {
		valor = v;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return String.valueOf(valor);
	}
}
