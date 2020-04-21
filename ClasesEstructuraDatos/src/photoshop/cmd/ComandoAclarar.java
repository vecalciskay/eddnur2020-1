package photoshop.cmd;

import photoshop.IComando;
import photoshop.Imagen;

public class ComandoAclarar implements IComando {

	private Imagen imagen;
	private int nivel;
	
	public ComandoAclarar(int nivelAclarar) {
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

				//int b = pixeles[i][j] % 256;
				//int g = ((pixeles[i][j] - b) / 256) % 256;
				//int r = ((((pixeles[i][j] - b) / 256) - g) / 256) % 256;
				
				// 0x00rrggbb
				
				// 0x000000bb
				// AND
				// 0x 0000 0000 rrrr rrrr gggg gggg bbbb bbbb
				// 0x 0000 0000 0000 0000 0000 0000 1111 1111
				//-------------------------------------------
				// 0x 0000 0000 0000 0000 0000 0000 bbbb bbbb
				int b = pixeles[i][j] & 0x000000ff;
				
				// 0x000000gg
				int g = (pixeles[i][j] >>> 8) & 0x000000ff;
				
				// 0x000000rr
				int r = (pixeles[i][j] >>> 16) & 0x000000ff;

				r += nivel;
				g += nivel;
				b += nivel;

				if (r > 255)
					r = 255;
				if (g > 255)
					g = 255;
				if (b > 255)
					b = 255;

				//pixeles[i][j] = r * 256 * 256 + g * 256 + b;
				pixeles[i][j] = (r << 16) | ((g << 8) | b);

			}
		}
	}

}
