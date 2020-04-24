package photoshop.cmd;

import photoshop.IComando;
import photoshop.Imagen;

public class ComandoConvertirGris implements IComando {
	private Imagen imagen;
	
	public ComandoConvertirGris() {
	
	}
	@Override
	public void setImagen(Imagen img) {
		this.imagen = img;
	}

	@Override
	public void ejecutar() {
		int[][] pixeles = imagen.getPixeles();
		for (int i = 0; i < imagen.getAncho(); i++) {
			for (int j = 0; j < imagen.getAlto(); j++) {
				int b = pixeles[i][j] & 0x000000ff;
				int g = (pixeles[i][j] >>> 8) & 0x000000ff;
				int r = (pixeles[i][j] >>> 16) & 0x000000ff;

				//negro:  000 000 000
				//blanco: 255 255 255
				// gris:  127 127 127
				// color cualquiera: 58 201 139  |  067 068 240 
				// color en gris:   139 139 139  |  068 068 068
				// con promedio:    133 133 133  |  125 125 125
				int gris = (r + g + b) / 3;

				pixeles[i][j] = (gris << 16) | ((gris << 8) | gris);
			}
		}	
	}

}
