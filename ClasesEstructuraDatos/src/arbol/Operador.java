package arbol;

public abstract class Operador extends ElementoAritmetico{

	protected String signo;
	
	public abstract double evaluar(double ope1, double ope2);
}
