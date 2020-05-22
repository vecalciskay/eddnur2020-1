package redes.circulo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComandoRadio extends ComandoCirculo {

	private int radio;
	
	public ComandoRadio(String linea) {
		String regexString = "^RADIO\\s+([1-9][0-9])$";

		Pattern pattern = Pattern.compile(regexString);
		Matcher matcher = pattern.matcher(linea);

		matcher.find();
		
		comando = "RADIO";
		argumentos = matcher.group(1);
		
		radio = Integer.parseInt(argumentos);
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
}
