package arbol;

public class OperadorSustraccion extends Operador {

	public OperadorSustraccion() {
		signo = "-";
	}
	
	public String toString() {
		return this.signo;
	}

	@Override
	public double evaluar(double ope1, double ope2 ) {
		
		return ope1 - ope2;
	}
}
