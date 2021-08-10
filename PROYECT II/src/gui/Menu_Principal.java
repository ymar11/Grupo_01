package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Fondo;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Principal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JDesktopPane desktopPane;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem menuItem;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem menuItem_1;
	private JMenuItem mntmNewMenuItem_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					// SE MAXIMIZA A TODA PANTALLA 
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
					
					// CENTRAR VENTANA EN LA PANTALLA
			  		//frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu_Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_Principal.class.getResource("/imagenes/home.png")));
		setTitle("REGISTROS ACADEMICOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 400);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("M\u00F3dulo de Mantenimiento");
		mnNewMenu.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/mantenimiento.png")));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Alumno");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/clientes.png")));
		mntmNewMenuItem_1.addActionListener(this);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Curso");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/edit.png")));
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mnNewMenu_1 = new JMenu("M\u00F3dulo de Registro");
		mnNewMenu_1.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/edit.png")));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Matr\u00EDcula");
		mntmNewMenuItem.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/modificar.png")));
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem);
		
		mntmNewMenuItem_6 = new JMenuItem("Retiro ");
		mntmNewMenuItem_6.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/delete.png")));
		mntmNewMenuItem_6.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		mnNewMenu_2 = new JMenu("M\u00F3dulo de Consulta");
		mnNewMenu_2.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/buscar.png")));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_7 = new JMenuItem("Alumnos - Cursos");
		mntmNewMenuItem_7.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/counter.png")));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("Matr\u00EDculas - Retiros");
		mntmNewMenuItem_8.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/reporte.png")));
		mntmNewMenuItem_8.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		mnNewMenu_3 = new JMenu("M\u00F3dulo de Reporte");
		mnNewMenu_3.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/ventas.png")));
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_3 = new JMenuItem("Alumnos con matr\u00EDcula pendiente");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/Factura.png")));
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Alumnos con Matr\u00EDcula vigente");
		mntmNewMenuItem_4.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/integrantes.png")));
		mntmNewMenuItem_4.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Alumnos matr\u00EDculados por curso");
		mntmNewMenuItem_5.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/sistema.png")));
		mntmNewMenuItem_5.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		mnNewMenu_4 = new JMenu("Integrantes");
		mnNewMenu_4.setIcon(new ImageIcon(Menu_Principal.class.getResource("/imagenes/clientes.png")));
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu_4);
		
		//Modificamos el desktopPane para incorporar imagen de fondo
        try {
              desktopPane = new JDesktopPane(){
               Image img = javax.imageio.ImageIO.read(

        new java.net.URL(getClass().getResource("/imagenes/cibertec.png"), "cibertec.png"));
               public void paintComponent(Graphics g){

                    super.paintComponent(g);
                    if(img != null) g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
                    else g.drawString("Image not found", 100,100);
                    }
               };

        } catch (IOException e) { e.printStackTrace();
          }	
		
		
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		menuItem = new JMenuItem("New menu item");
		menuItem.setBounds(577, 45, 75, 9);
		desktopPane.add(menuItem);
		
		menuItem_1 = new JMenuItem("New menu item");
		menuItem_1.setBounds(394, 11, 75, 9);
		desktopPane.add(menuItem_1);
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
 /*		//ADJUNTAR IMAGEN DE FONDO
		 setBounds(100, 100, 900, 400);
		 Fondo p = new Fondo();
		  p.setBorder(new EmptyBorder(5, 5, 5, 5));
		  p.setLayout(new BorderLayout(0, 0));
		 setContentPane(p);    */ 

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_5) {
			actionPerformedMntmNewMenuItem_5(e);
		}
		if (e.getSource() == mntmNewMenuItem_4) {
			actionPerformedMntmNewMenuItem_4(e);
		}
		if (e.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_3(e);
		}
		if (e.getSource() == mntmNewMenuItem_8) {
			actionPerformedMntmNewMenuItem_8(e);
		}
		if (e.getSource() == mntmNewMenuItem_6) {
			actionPerformedMntmNewMenuItem_6(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(e);
		}
	}
	
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		
		Mantenimiento_Alumno dc = new Mantenimiento_Alumno ();
		dc.setVisible (true);
	}
	
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		gui_curso dc = new gui_curso ();
		dc.setVisible (true);
	}
	
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		DlgMatricula dc = new DlgMatricula ();
		dc.setVisible (true);
		
	}
	
	protected void actionPerformedMntmNewMenuItem_6(ActionEvent e) {
		Matricula_Pendiente dc = new Matricula_Pendiente ();
		dc.setVisible (true);
	
	}
	
	protected void actionPerformedMntmNewMenuItem_8(ActionEvent e) {
		
	}
	
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		Modulo_Retiro dc = new Modulo_Retiro ();
		dc.setVisible (true);
		
	}
	
	protected void actionPerformedMntmNewMenuItem_4(ActionEvent e) {
		Matr�cula_vigente dc = new Matr�cula_vigente  ();
		dc.setVisible (true);
	}
	
	protected void actionPerformedMntmNewMenuItem_5(ActionEvent e) {
		Matricula_por_Curso dc = new Matricula_por_Curso  ();
		dc.setVisible (true);
	}
}
