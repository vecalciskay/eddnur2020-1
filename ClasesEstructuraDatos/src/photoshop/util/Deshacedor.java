package photoshop.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import listaversionfinal.ListaDoble;
import photoshop.Imagen;

public class Deshacedor extends ListaDoble<Imagen> 
	implements PropertyChangeListener {

	Nodo<Imagen> actual;
	
	public Deshacedor() {
		actual = null;
	}
	
	public void agregarCambio(Imagen img) {
		if (inicio == null) {
			insertar(img);
			actual = inicio;
			return;
		}
			
		if (actual.getSiguiente() != null) {
			actual.getSiguiente().setAnterior(null);
			actual.setSiguiente(null);
			ultimo = actual;
		}
		this.agregar(img);
		actual = ultimo;
	}
	
	public void deshacer() {
		if (actual != null && actual.getAnterior() != null)
			actual = actual.getAnterior();	
	}
	
	public void rehacer() {
		if (actual != null && actual.getSiguiente() != null)
			actual = actual.getSiguiente();
	}
	
	public Imagen clonarActual() {
		return actual.getContenido().clonar();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("imagen")) {
			Imagen img = ((Imagen)(evt.getSource())).clonar();
			this.agregarCambio(img);
		}
	}

}
