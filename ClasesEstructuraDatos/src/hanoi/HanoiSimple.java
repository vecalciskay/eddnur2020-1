package hanoi;

public class HanoiSimple {

	public static void main(String[] args) {
		HanoiSimple h = new HanoiSimple(3);

		try {
			h.hanoi(1, 3);
		} catch (Exception e) {
			System.out.println("No se puede hacer");
			e.printStackTrace();
		}
	}

	private int n;

	public HanoiSimple(int n) {
		this.n = n;
	}

	public void hanoi(int desde, int hasta) throws Exception {
		int pp = desde == 1 && hasta == 3 ? 2 : desde == 1 && hasta == 2 ? 3 : desde == 2 && hasta == 3 ? 1 : 4;

		if (pp == 4)
			throw new Exception("No pudo calcular pp");

		resolverHanoi(desde, hasta, pp, n);
	}

	private void resolverHanoi(int desde, int hasta, int pp, int anillos) {
		if (anillos == 1) {
			System.out.println(desde + " -> " + hasta);
			return;
		}

		resolverHanoi(desde, pp, hasta, anillos - 1);
		resolverHanoi(desde, hasta, pp, 1);
		resolverHanoi(pp, hasta, desde, anillos - 1);
	}
}
