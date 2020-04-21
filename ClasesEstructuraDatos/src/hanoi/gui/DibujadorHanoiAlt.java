package hanoi.gui;

import java.awt.Color;
import java.awt.Graphics;

import hanoi.Anillo;
import hanoi.HanoiPOO;

public class DibujadorHanoiAlt implements IDibujador {
private HanoiPOO hanoi;
	
	public DibujadorHanoiAlt() {
		hanoi = null;
	}
	
	public void setHanoi(HanoiPOO o) {
		hanoi = o;
	}
	
	@Override
	public void dibujar(Graphics g, int x, int y, int w, int h) {
		g.setColor(Color.black);
		g.fillRect(x, y, w, 5);
		
		dibujarTorre(g, 0, w/3 + x, y, h);
		dibujarTorre(g, 1, 2*w/3 + x, y, h);
		dibujarTorre(g, 2, w + x, y, h);
	}
	private void dibujarTorre(Graphics g, int numTorre, int x, int y, int h) {
		g.setColor(Color.green);
		g.fillRect(x, y - h, 10, h);
		
		int hAnillo = 25;
		for(Object obj : hanoi.getTorres()[numTorre].getAnillos()) {
			Anillo anillo = (Anillo)obj;
			int wAnillo = anillo.getTamano() * 20;
			g.setColor(Color.yellow);
			g.fillRect(x - wAnillo/2 + 5, y - hAnillo, wAnillo, 15);
			hAnillo += 25;
		}
	}
}
