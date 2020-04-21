package hanoi;

public class Anillo {

	private int tamano;
	
	public Anillo(int n) {
		tamano = n;
	}
	
	public String toString() {
		return String.valueOf(tamano);
	}

	public int getTamano() {
		return tamano;
	}
}
