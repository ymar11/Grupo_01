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
import javax.swing.JTextArea;

public class Matricula_por_Curso extends JDialog {
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Matricula_por_Curso dialog = new Matricula_por_Curso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Matricula_por_Curso() {
		setBounds(100, 100, 610, 446);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 561, 345);
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
		ArregloCurso ac = new ArregloCurso ();
		Alumno a;
		Curso c;
		
		for (int j=0; j<ac.tamanio(); j++) {
			a = aa.obtener(j);
			c = ac.obtener(j);
			if (a.getEstado() == 0) {
				a = aa.buscar(a.getCodAlumno());
				c = ac.buscar(c.getCodCurso());
				
				
//				c = ac.buscar(a.getCodAlumno());
				imprimir("Código de Alumno :  " + a.getCodAlumno());
				imprimir("Código de Curso  :  " + c.getCodCurso());				
				imprimir("Ciclo N°         :  " + c.getCiclo());
				imprimir("Nombre de alumno :  " + a.getNombres());
				//imprimir("Nombres            :  " + p.getNombres());
				// imprimir("Apellidos          :  " + p.getApellidos());
				// imprimir("Fecha de atención  :  " + a.getFechaAtencion()
				   //                               + " - " + a.getHoraAtencion());
				imprimir();
			}
		}
	}
	

	
//  Métodos tipo void (con parámetros)
	void imprimir (String s) {
		txtS.append (s + "\n");
	}
			
}
