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
import java.awt.Font;

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
			// CENTRAR VENTANA EN LA PANTALLA
	  		dialog.setLocationRelativeTo(null);
	  		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Matricula_por_Curso() {
		setTitle("REPORTE  |  Alumnos y cursos ");
		setBounds(100, 100, 610, 446);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 561, 345);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Calibri", Font.PLAIN, 14));
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
				imprimir(" Código de Alumno \t :  " + a.getCodAlumno());				
				imprimir(" Nombre de alumno \t :  " + a.getNombres());				
			    imprimir(" Apellidos             \t :  " + a.getApellidos());
				//imprimir(" Edad                   \t :  " + a.getEdad());
				imprimir(" Código de Curso  \t :  " + c.getCodCurso());
				imprimir(" Asignatura          \t :  " + c.getAsignatura());				
                imprimir(" Ciclo N°                \t :  " + Libr.estadosCiclo [c.getCiclo()]);
                imprimir(" Horas academicas \t :  " + c.getHoras());
                imprimir(" N° de creditos   \t :  " + c.getCreditos());

                
				
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
