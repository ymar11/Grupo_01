package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import libreria.Libr;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Matricula_Pendiente extends JDialog {
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Matricula_Pendiente dialog = new Matricula_Pendiente();
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
	public Matricula_Pendiente() {
		setTitle("REPORTE  |   ALUMNOS  CON MATR\u00CDCULAS  PENDIENTES");
		setBounds(100, 100, 618, 424);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 561, 345);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		listar ();
	}
	
	
	
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	
	
	void listar() {
		ArregloAlumnos aa = new ArregloAlumnos();
		Alumno a;
		
		
		txtS.setText("");
		for (int i = 0; i < aa.tamanio(); i++) {
			a = aa.obtener(i);
			if (a.getEstado() == 0) {
				a = aa.buscar(a.getCodAlumno());
				imprimir("Código de Alumno     \t :  " + a.getCodAlumno());				
				imprimir("Nombres                \t :  " + a.getNombres());
				imprimir("Apellidos              \t :  " + a.getApellidos());
				imprimir("DNI N°                 \t :  " + a.getDni());
				imprimir("Edad                      \t :  " + a.getEdad());
                imprimir("Estado de matrícula \t :  " + Libr.categoriaEstado [a.getEstado()]);
				// imprimir("Estado de matrícula \t :  " +  a.getEstado());


				
				imprimir("==============================================================================");
				
				imprimir();
			}
		}
	}
 
	
//  Métodos tipo void (con parámetros)
	void imprimir (String s) {
		txtS.append (s + "\n");
	}
	
}
