package photoshop.cmd;

import photoshop.IComando;
import photoshop.Imagen;

public class ComandoOscurecer implements IComando  {
	private Imagen imagen;
	private int nivel;
	
	public ComandoOscurecer(int nivelAclarar) {
		nivel = nivelAclarar;
	}

	@Override
	public void setImagen(Imagen img) {
		imagen = img;
	}

	@Override
	public void ejecutar() {
		int[][] pixeles = imagen.getPixeles();
		for (int i = 0; i < imagen.getAncho(); i++) {
			for (int j = 0; j < imagen.getAlto(); j++) {

				int b = pixeles[i][j] & 0x000000ff;
				int g = (pixeles[i][j] >>> 8) & 0x000000ff;
				int r = (pixeles[i][j] >>> 16) & 0x000000ff;

				r -= nivel;
				g -= nivel;
				b -= nivel;

				if (r < 0)
					r = 0;
				if (g < 0)
					g = 0;
				if (b < 0)
					b = 0;

				pixeles[i][j] = (r << 16) | ((g << 8) | b);

			}
		}
	}
}
