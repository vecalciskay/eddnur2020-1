package arbol;

public abstract class Operador extends ElementoAritmetico {

	protected String signo;

	public abstract double evaluar(double ope1, double ope2);

	public static ElementoAritmetico construir(String signoString) throws Exception {
		ElementoAritmetico result = null;
		switch (signoString) {
		case OperadorSuma.CARACTER:
			result = new OperadorSuma();
			break;
		case OperadorSustraccion.CARACTER:
			result = new OperadorSustraccion();
			break;
		case OperadorDivision.CARACTER:
			result = new OperadorDivision();
			break;
		case OperadorMultiplicacion.CARACTER:
			result = new OperadorMultiplicacion();
			break;
		default:
			throw new Exception("No hay operacion para el signo " + signoString);
		}

		return result;
	}
}
