package arbol;

public class OperadorDivision extends Operador {

	public OperadorDivision() {
		signo = "/";
	}
	
	public String toString() {
		return this.signo;
	}

	@Override
	public double evaluar(double ope1, double ope2 ) {
		
		return ope1 / ope2;
	}
}

