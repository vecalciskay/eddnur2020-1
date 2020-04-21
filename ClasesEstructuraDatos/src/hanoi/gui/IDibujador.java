package hanoi.gui;

import java.awt.Graphics;

import hanoi.HanoiPOO;

public interface IDibujador {

	public void dibujar(Graphics g, int x, int y, int w, int h);
	
	public void setHanoi(HanoiPOO hanoi);
}
