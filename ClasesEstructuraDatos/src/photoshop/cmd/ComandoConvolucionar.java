package photoshop.cmd;

import photoshop.IComando;
import photoshop.Imagen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase donde alberga la parte lógica de todo el proceso de convolución
 *
 * @author Joel S.
 */
public class ComandoConvolucionar implements IComando {

    public static Logger log = LogManager.getLogger();

    private Imagen imagen;
    private int[][] kernel;

    public ComandoConvolucionar(int[][] mat) {
        kernel = mat;
    }

    @Override
    public void setImagen(Imagen img) {
        imagen = img;
       
    }

    @Override
    public void ejecutar() {
        calculoConvolucion(imagen, kernel);
         log.info("Convolución aplicado con éxito a la imagen");
    }

    /**
     * En este método lo que hace es establecer la imagen que seleccionemos e ir
     * recorriendo la imagen pixel por pixel llamando al método "convolucionar"
     * para que realice las ecuaciones correspondientes.
     *
     * @param imagen
     * @param kernel
     * @return
     */
    public Imagen calculoConvolucion(Imagen imagen, int[][] kernel) {
        this.imagen = imagen;
        int[][] pixeles = imagen.getPixeles();

        int tope = kernel.length / 2;

        for (int i = tope; i < pixeles.length - tope; i++) {
            for (int j = tope; j < pixeles[0].length - tope; j++) {

                pixeles[i][j] = convolucionar(imagen.getPixeles(), kernel, i, j);
            }
        }

        this.imagen.setPixeles(pixeles);
        return this.imagen;

    }

    /**
     * Este método lo que hace es tomar la imagen convertida en valores de una
     * matriz y va haciendo las ecuaciones entre los píxeles de la imagen
     * original y el kernel para ir aplicando los filtros a la imagen, este
     * proceso se repite hasta haber abarcado todos los píxeles de la imagen
     *
     * @param imagen
     * @param kernel
     * @param fila
     * @param columna
     * @return
     */
    public int convolucionar(int[][] imagen, int[][] kernel, int fila, int columna) {
        int tope = kernel.length / 2; //variable que sirve de control para evitar que se desborde la mascara de la matriz
//        short pixel = 0;
        int b = 0;
        int g = 0;
        int r = 0;

        int factor = 0;

        for (int i = 0; i < kernel.length; i++) {

            for (int j = 0; j < kernel[0].length; j++) {
                factor += kernel[i][j];
                r += red(imagen[fila - tope + i][columna - tope + j]) * kernel[i][j];
                g += green(imagen[fila - tope + i][columna - tope + j]) * kernel[i][j];
                b += blue(imagen[fila - tope + i][columna - tope + j]) * kernel[i][j];

            }

        }

        /**
         * Estas condiciones son para que la imagen no se deforme o desborde al
         * punto de presentar anomalías y que la imagen sea inentendible
         */
        if (factor > 0) {
            b /= factor;
            g /= factor;
            r /= factor;
        }
        if (r < 0) {
            r = 0;
        }
        if (g < 0) {
            g = 0;
        }
        if (b < 0) {
            b = 0;
        }

        if (r > 255) {
            r = 255;
        }
        if (g > 255) {
            g = 255;
        }
        if (b > 255) {
            b = 255;
        }
       
        
        return (r << 16) | ((g << 8) | b);

    }

    public int blue(int b) {
        int blue = b & 0x000000ff;
        return blue;
    }

    public int green(int g) {
        int green = (g >>> 8) & 0x000000ff;
        return green;
    }

    public int red(int r) {
        int red = (r >>> 16) & 0x000000ff;
        return red;
    }

    
}
