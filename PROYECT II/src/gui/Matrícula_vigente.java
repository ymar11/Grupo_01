package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloAlumnos;
import clases.Alumno;
import libreria.Libr;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Matr�cula_vigente extends JDialog {
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Matr�cula_vigente dialog = new Matr�cula_vigente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			// CENTRAR VENTANA EN LA PANTALLA
			dialog.setLocationRelativeTo(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Matr�cula_vigente() {
		setTitle("REPORTE  |  ALUMNOS CON  MATR\u00CDCULA  VIGENTE");
		setBounds(100, 100, 607, 414);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 561, 345);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		listar ();
	}
	
//  M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	
	
	void listar() {
		ArregloAlumnos aa = new ArregloAlumnos();
		Alumno a;
		
		
		txtS.setText("");
		for (int i = 0; i < aa.tamanio(); i++) {
			a = aa.obtener(i);
			if (a.getEstado() == 1) {
				a = aa.buscar(a.getCodAlumno());
				imprimir("C�digo de Alumno     \t :  " + a.getCodAlumno());				
				imprimir("Nombres                \t :  " + a.getNombres());
				imprimir("Apellidos              \t :  " + a.getApellidos());
				imprimir("DNI N�                 \t :  " + a.getDni());
				imprimir("Edad                      \t :  " + a.getEdad());
			// imprimir("Estado de matr�cula \t :  " + Libr.categoriaEstado [a.getEstado()]);
				imprimir("Estado de matr�cula \t :  " +   a.getEstado());
				
				
				
				imprimir("==============================================================================");
				
				imprimir();
			}
		}
	}
 
	
//  M�todos tipo void (con par�metros)
	void imprimir (String s) {
		txtS.append (s + "\n");
	}
	
	
}
