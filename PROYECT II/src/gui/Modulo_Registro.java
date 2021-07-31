package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloRetiro;
import clases.Retiro;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Modulo_Registro extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblApellidos;
	private JLabel lblCodAlumno;
	private JLabel lblNMatrcula;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtNumMatricula;
	private JLabel lblNMatrcula_1;
	private JTextField txtNumRetiro;
	private JLabel lblCodAlumno_1;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel modelo;

	ArregloRetiro ar = new ArregloRetiro();
	private JTextArea txtS;
	private JLabel lblNMatrcula_2;
	private JLabel lblNMatrcula_3;
	private JTextField txtFecha;
	private JTextField txtHora;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modulo_Registro dialog = new Modulo_Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modulo_Registro() {
		setBounds(100, 100, 638, 517);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 566, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(147, 51, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setBounds(33, 54, 46, 14);
		contentPanel.add(lblNewLabel);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(33, 92, 46, 14);
		contentPanel.add(lblApellidos);
		
		lblCodAlumno = new JLabel("Cod. Alumno:");
		lblCodAlumno.setBounds(33, 131, 73, 14);
		contentPanel.add(lblCodAlumno);
		
		lblNMatrcula = new JLabel("N. Matr\u00EDcula:");
		lblNMatrcula.setBounds(33, 170, 73, 14);
		contentPanel.add(lblNMatrcula);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 89, 86, 20);
		textField_1.setColumns(10);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 128, 86, 20);
		textField_2.setColumns(10);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(147, 167, 86, 20);
		textField_3.setColumns(10);
		contentPanel.add(textField_3);
		
		txtNumMatricula = new JTextField();
		txtNumMatricula.setBounds(98, 26, 73, 20);
		txtNumMatricula.setColumns(10);
		getContentPane().add(txtNumMatricula);
		
		lblNMatrcula_1 = new JLabel("# Matr\u00EDcula");
		lblNMatrcula_1.setBounds(30, 29, 110, 14);
		getContentPane().add(lblNMatrcula_1);
		
		txtNumRetiro = new JTextField();
		txtNumRetiro.setBounds(98, 57, 73, 20);
		txtNumRetiro.setColumns(10);
		getContentPane().add(txtNumRetiro);
		
		lblCodAlumno_1 = new JLabel("# Retiro");
		lblCodAlumno_1.setBounds(30, 60, 73, 14);
		getContentPane().add(lblCodAlumno_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 89, 467, 219);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addKeyListener(this);
		tblTabla.addMouseListener(this);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("# Retiro");
		modelo.addColumn("# Matricula");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		tblTabla.setModel(modelo);
		listar();
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(500, 89, 114, 23);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(500, 123, 114, 23);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(500, 157, 114, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(500, 191, 114, 23);
		getContentPane().add(btnEliminar);
		
		txtS = new JTextArea();
		txtS.setBounds(23, 319, 467, 146);
		getContentPane().add(txtS);
		
		lblNMatrcula_2 = new JLabel("Fecha:");
		lblNMatrcula_2.setBounds(194, 29, 57, 14);
		getContentPane().add(lblNMatrcula_2);
		
		lblNMatrcula_3 = new JLabel("Hora:");
		lblNMatrcula_3.setBounds(194, 60, 57, 14);
		getContentPane().add(lblNMatrcula_3);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(243, 26, 73, 20);
		getContentPane().add(txtFecha);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(243, 57, 73, 20);
		getContentPane().add(txtHora);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		int nMatricula = leerNumMatricula();
		int nRetiro = ar.codigoCorrelativoNumRetiro();
		String fecha = fechaActual();
		String hora = horaActual();
		
		
		Retiro nuevo = new Retiro(nRetiro, nMatricula, fecha, hora);
		ar.adicionar(nuevo);
		listar();
		limpieza();
	}
	
	
	void listar() {
		modelo.setRowCount(0);
		
		for(int i = 0 ; i<ar.tamanio() ; i++) {
			Object[] fila = {
					
					ar.obtener(i).getNumRetiro(),
					ar.obtener(i).getNumMatricula(),
					ar.obtener(i).getFecha(),
					ar.obtener(i).getHora(),
				};			
			modelo.addRow(fila);
		}			
	}
	
	public int leerNumMatricula() {
		return Integer.parseInt(txtNumMatricula.getText());
	}
	
	public int leerNumRetiro() {
		return Integer.parseInt(txtNumRetiro.getText());
	}
	
	public String leerFecha() {
		return txtFecha.getText();
	}
	
	public String leerHora() {
		return txtHora.getText();
	}
	
	
	String fechaActual() {
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		return ajustar(dd) + "/" + ajustar(mm) + "/" + aa;
	}
	String horaActual() {
		int hh, mm, ss;
		Calendar c = new GregorianCalendar();
		hh = c.get(Calendar.HOUR_OF_DAY);
		mm = c.get(Calendar.MINUTE);
		ss = c.get(Calendar.SECOND);
		return ajustar(hh) + ":" + ajustar(mm) + ":" + ajustar(ss);
	}
	
	String ajustar(int numero) {
		return String.format("%02d", numero);
	}
	
	void limpieza() {
		txtNumMatricula.setText("");
		txtNumMatricula.requestFocus();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		Retiro r = ar.buscar(leerNumMatricula());
		if(r != null) {
			txtNumMatricula.setText("" + r.getNumMatricula());
			txtNumRetiro.setText("" + r.getNumRetiro());
			txtFecha.setText(r.getFecha());
			txtHora.setText(r.getHora());
			txtNumMatricula.requestFocus();
		}
		else {
			mensaje("El número de matrícula " + leerNumMatricula() + " no existe");
			txtNumMatricula.setText("");
			txtNumRetiro.setText("");
			txtFecha.setText("");
			txtHora.setText("");
			txtNumMatricula.requestFocus();
		}
	}
	
	void imprimir() {
		imprimir("");
	}
	
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		Retiro r = ar.buscar(leerNumMatricula());
		if(r != null) {
			int nRetiro = leerNumRetiro();
			String fecha = leerFecha();
			String hora = leerHora();
			
			r.setNumRetiro(nRetiro);
			r.setFecha(fecha);
			r.setHora(hora);
			
			listar();
			txtNumMatricula.requestFocus();
			
			mensaje("Los datos fueron modificados con éxito");
		}
		else {
			mensaje("El número de matrícula no existe");
		}
	}
	
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		Retiro r = ar.buscar(leerNumMatricula());
		if(r != null) {
			ar.eliminar(r);
			listar();
			limpieza();
			mensaje("Los datos fueron eliminados con éxito");
		}else {
			mensaje("El número de matrícula no existe");
		}
	}
	
	void navegar(){
		int fila=tblTabla.getSelectedRow(); 
		txtNumRetiro.setText("" +tblTabla.getValueAt(fila, 0));
		txtNumMatricula.setText("" +tblTabla.getValueAt(fila, 1));
		txtFecha.setText("" +tblTabla.getValueAt(fila, 2));
		txtHora.setText("" +tblTabla.getValueAt(fila, 3));
	}
	
	
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblTabla) {
			mouseClickedTblTabla(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblTabla(MouseEvent arg0) {
		navegar();
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tblTabla) {
			keyReleasedTblTabla(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTblTabla(KeyEvent arg0) {
		navegar();
	}
}
