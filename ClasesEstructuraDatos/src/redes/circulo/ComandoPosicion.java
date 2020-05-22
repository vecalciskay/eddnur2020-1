package redes.circulo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComandoPosicion extends ComandoCirculo {

	private int x;
	private int y;

	public ComandoPosicion(String linea) {
		String regexString = "^POSICION\\s+\\(\\s*([0-9]{1,3})\\s*,\\s*([0-9]{1,3})\\s*\\)$";

		Pattern pattern = Pattern.compile(regexString);
		Matcher matcher = pattern.matcher(linea);

		matcher.find();
		
		comando = "POSICION";
		x = Integer.parseInt(matcher.group(1));
		y = Integer.parseInt(matcher.group(2));
		argumentos = "(" + x + "," + y + ")";		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

}
