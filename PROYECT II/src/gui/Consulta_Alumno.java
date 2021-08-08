package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCurso;
import clases.Alumno;
import clases.Curso;
import libreria.Libr;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class Consulta_Alumno extends JDialog implements ActionListener {
	private JLabel lblAlumno;
	private JTextField txtAlumno;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JLabel lblCurso;
	private JTextField txtCurso;
	private JButton btnConsultar1;
	private JPanel panel;
	private JScrollPane scrollPane_2;
	private JTextArea txtS;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JTextArea txtS1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consulta_Alumno dialog = new Consulta_Alumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			// CENTRAR VENTANA EN LA PANTALLA
	  		dialog.setLocationRelativeTo(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	ArregloAlumnos aa= new ArregloAlumnos ();
	ArregloCurso ac = new ArregloCurso ();

	/**
	 * Create the dialog.
	 */
	public Consulta_Alumno() {
		setTitle("CONSULTA |  ALUMNOS - CURSO ");
		setBounds(100, 100, 566, 588);
		getContentPane().setLayout(null);
		
		lblAlumno = new JLabel("C\u00F3digo Alumno ");
		lblAlumno.setBounds(39, 31, 87, 14);
		getContentPane().add(lblAlumno);
		
		txtAlumno = new JTextField();
		txtAlumno.setBounds(130, 28, 86, 20);
		getContentPane().add(txtAlumno);
		txtAlumno.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(305, 27, 89, 23);
		getContentPane().add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 161, 473, -76);
		getContentPane().add(scrollPane);
		
		lblCurso = new JLabel("C\u00F3digo curso");
		lblCurso.setBounds(24, 321, 87, 14);
		getContentPane().add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(115, 318, 86, 20);
		getContentPane().add(txtCurso);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		panel.setBounds(10, 264, 514, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 106, 494, 110);
		panel.add(scrollPane_2);
		
		txtS = new JTextArea();
		scrollPane_2.setViewportView(txtS);
		
		btnConsultar1 = new JButton("Consultar");
		btnConsultar1.addActionListener(this);
		btnConsultar1.setBounds(296, 52, 89, 23);
		panel.add(btnConsultar1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 11, 514, 242);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 72, 465, 148);
		panel_1.add(scrollPane_1);
		
		txtS1 = new JTextArea();
		scrollPane_1.setViewportView(txtS1);
		
		
	}
	 
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar1) {
			actionPerformedBtnConsultar1(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
		Alumno a = aa.buscar(leerAlumno());
		if(a != null) {
			txtAlumno.setText("" + a.getCodAlumno());
						
			txtAlumno.requestFocus();

			txtS1.setText("Código de Alumno     \t :  " + a.getCodAlumno() + "\n") ; 				
			txtS1.setText("Nombres                \t :  " + a.getNombres() + "\n");
			txtS1.setText("Apellidos              \t :  " + a.getApellidos());
			txtS1.setText("DNI N°                 \t :  " + a.getDni());
			txtS1.setText("Edad                      \t :  " + a.getEdad());
			txtS1.setText("Estado de matrícula \t :  " + Libr.categoriaEstado [a.getEstado()]);
			// imprimir("Estado de matrícula \t :  " +  a.getEstado());
            
            
		}
		else {
			mensaje("El número de matrícula " + leerAlumno() + " no existe");
			
			txtAlumno.requestFocus();
		}
				
	}
	
	
	protected void actionPerformedBtnConsultar1(ActionEvent e) {
		
	}
	

/*	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir ("");
	}   */ 
	
	
	void listarA() {
		ArregloAlumnos aa = new ArregloAlumnos();
		Alumno a;
		
		ArregloCurso ac = new ArregloCurso();
		Curso c;
		
		txtS1.setText("");
		for (int i = 0; i < aa.tamanio(); i++) {
			a = aa.obtener(i);
			if (a.getEstado() == 0) {
				a = aa.buscar(a.getCodAlumno());
				imprimirA("Código de Alumno     \t :  " + a.getCodAlumno());				
				imprimirA("Nombres                \t :  " + a.getNombres());
				imprimirA("Apellidos              \t :  " + a.getApellidos());
				imprimirA("DNI N°                 \t :  " + a.getDni());
				imprimirA("Edad                      \t :  " + a.getEdad());
                imprimirA("Estado de matrícula \t :  " + Libr.categoriaEstado [a.getEstado()]);
				// imprimir("Estado de matrícula \t :  " +  a.getEstado());
                
                 
				
				imprimirA("==============================================================================");
				
				imprimirA("");
			}
		}
	}
 

	

	void listarB() {
		ArregloAlumnos aa = new ArregloAlumnos();
		Alumno a;
		
		ArregloCurso ac = new ArregloCurso();
		Curso c;
		
		txtS.setText("");
		for (int i = 0; i < aa.tamanio(); i++) {
			a = aa.obtener(i);
			if (a.getEstado() == 0) {
				a = aa.buscar(a.getCodAlumno());
				imprimirB("Código de Alumno     \t :  " + a.getCodAlumno());				
				imprimirB("Nombres                \t :  " + a.getNombres());
				imprimirB("Apellidos              \t :  " + a.getApellidos());
				imprimirB("DNI N°                 \t :  " + a.getDni());
				imprimirB("Edad                      \t :  " + a.getEdad());
                imprimirB("Estado de matrícula \t :  " + Libr.categoriaEstado [a.getEstado()]);
				// imprimir("Estado de matrícula \t :  " +  a.getEstado());
                
                 
				
				imprimirB("==============================================================================");
				
				imprimirB("");
			}
		}
	}
 
	
	
//  Métodos tipo void (con parámetros)
	void imprimirA (String s) {
		txtS1.append (s + "\n");
		
	}
	
	void imprimirB (String s) {
		txtS.append (s + "\n");
	}
	
	void mensaje (String s)  {
		JOptionPane.showMessageDialog(this, s); 
	}
	
	
	public int  leerAlumno ()  {
		return Integer.parseInt(txtAlumno.getText());
		
	}
	
			
		
	
	
}
