package clases;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Fondo() {  
		  this.setSize(400, 280);	}
	
	@Override
	 public void paintComponent(Graphics g) {
	  Dimension playa = getSize();
	  ImageIcon imagenF = new ImageIcon(getClass().getResource("/imagenes/cibertec1.jpg"));
	  g.drawImage(imagenF.getImage(), 0, 0, playa.width, playa.height, null);
	  setOpaque(false);
	  super.paintComponent(g);
	 }

}
