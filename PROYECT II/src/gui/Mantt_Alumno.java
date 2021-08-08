package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumnos;
import clases.Alumno;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;

public class Mantt_Alumno extends JDialog implements ActionListener, MouseListener, KeyListener {
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblCelular;
	private JLabel lblEstado;
	private JLabel lblEdad;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtCelular;
	private JTextField txtEdad;
	private JComboBox cboEstado;
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnReportar;
	private JTable tbltabla;
	private JTextArea txtS;
	
	//DECLARACION VARIABLES//  
		ArregloAlumnos aa = new ArregloAlumnos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mantt_Alumno dialog = new Mantt_Alumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mantt_Alumno() {
		setTitle("      MANTENIMIENTO  |  ALUMNO");
		setBounds(100, 100, 740, 610);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 38, 46, 14);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 63, 46, 14);
		getContentPane().add(lblApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 91, 46, 14);
		getContentPane().add(lblDni);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 116, 46, 14);
		getContentPane().add(lblCelular);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 144, 46, 14);
		getContentPane().add(lblEstado);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(175, 91, 46, 14);
		getContentPane().add(lblEdad);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 11, 121, 20);
		txtCodigo.setColumns(10);
		getContentPane().add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 38, 121, 20);
		txtNombre.setColumns(10);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(66, 63, 121, 20);
		txtApellido.setColumns(10);
		getContentPane().add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setBounds(66, 88, 86, 20);
		txtDni.setColumns(10);
		getContentPane().add(txtDni);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(66, 116, 86, 20);
		txtCelular.setColumns(10);
		getContentPane().add(txtCelular);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(219, 88, 86, 20);
		txtEdad.setColumns(10);
		getContentPane().add(txtEdad);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(66, 140, 115, 22);
		cboEstado.setModel(new DefaultComboBoxModel (new String[] {"Registrado ", "Matriculado ", "Retirado "}));
		getContentPane().add(cboEstado);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 200, 697, 227);
		getContentPane().add(scrollPaneA);
		
		tbltabla = new JTable();
		tbltabla.addKeyListener(this);
		tbltabla.addMouseListener(this);
		tbltabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRES", "APELLIDOS", "DNI N\u00B0", "EDAD", "CELULAR", "ESTADO"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbltabla.getColumnModel().getColumn(0).setPreferredWidth(82);
		tbltabla.getColumnModel().getColumn(1).setPreferredWidth(100);
		tbltabla.getColumnModel().getColumn(2).setPreferredWidth(102);
		tbltabla.getColumnModel().getColumn(3).setPreferredWidth(80);
		tbltabla.getColumnModel().getColumn(5).setPreferredWidth(80);
		tbltabla.getColumnModel().getColumn(6).setPreferredWidth(78);
		scrollPaneA.setViewportView(tbltabla);
		//debemos imprimir tabla 		
		listar();
		
		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 455, 697, 105);
		getContentPane().add(scrollPaneB);
		
		txtS = new JTextArea();
		scrollPaneB.setViewportView(txtS);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(315, 22, 89, 23);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(315, 59, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(315, 87, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(315, 121, 89, 23);
		getContentPane().add(btnReportar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {		
		/**    *  agregar nuevo alumno     */
		
		 //  declarar variables locales 
		int codigo = leerCodigo();
		String nombre = leerNombre();
		String apellido = leerApellido();
		String dni = leerDni();
		int edad = leerEdad ();
		int celular = leerCelular();
		int estado = leerEstado();
		
		//  //Creando un nuevo objeto del tipo alumno 
		Alumno nuevo = new Alumno (codigo, nombre, apellido, dni, edad,celular, estado);
				
		
		//Añadir el nuevo objeto al ArrayList
				aa.adicionar(nuevo);
				listar();
				limpieza(); 		
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		 Alumno a = aa.buscar (leerCodigo ()) ;
		 if (a!=null ) {
			 int codigo = leerCodigo();
			 String nombre = leerNombre();
			 String apellido = leerApellido ();
			 String dni = leerDni();
			 int edad = leerEdad();
			 int celular = leerCelular();
			 int estado = leerEstado();
			 
			 a.setCodAlumno(codigo);
			 a.setNombres(nombre);
			 a.setApellidos(apellido);
			 a.setDni(dni);
			 a.setEdad(edad);
			 a.setCelular(celular);
			 a.setEstado(estado);		
			 
			 listar ();
			 
			 mensaje ("Datos modificados correctamente");			 
		 }
		 else { mensaje ("Código : " + leerCodigo() + " No encontrado" );} 		
		
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		DefaultTableModel model = (DefaultTableModel) tbltabla.getModel();
         int borrar = tbltabla.getSelectedRow(); 
         if (borrar<0){
          mensaje( "Seleccionar una fila de la tabla" ); 

        }else {
        	 int confirmar=JOptionPane.showConfirmDialog(null, 
        	  "Esta seguro que desea Eliminar el registro? "); 

         if(JOptionPane.OK_OPTION==confirmar) {
        	 model.removeRow(borrar);
          mensaje ("Registro Eliminado" );
           } 
       } 
	}	
	
	
	protected void actionPerformedBtnReportar(ActionEvent e) {		 
		reportar ();  
        
	}
	
//  Métodos tipo void (con parámetros)
		void imprimir(String s) {
			txtS.append(s + "\n");
		}
		
	//  Métodos tipo void (sin parámetros)
		void imprimir() {
			imprimir("");    
		}
		
		void limpieza() {
			txtCodigo.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtDni.setText("");
			txtEdad.setText("");
			txtCelular.setText("");
			txtCodigo.requestFocus();			
		}	
	
	void listar () {
		//Obtenemos el modelo de la tabla
		DefaultTableModel modelo = (DefaultTableModel) tbltabla.getModel();

		//Se establece la primera fila al modelo 
		modelo.setRowCount(0);
		for (int i = 0; i <aa.tamanio() ; i++) {
			
		//Creando una fila por cada objeto
		Object fila[] = {		
		
		aa.obtener(i).getCodAlumno(),
		aa.obtener(i).getNombres(),
		aa.obtener(i).getApellidos (),
		aa.obtener(i).getDni(),
		aa.obtener(i).getEdad(),
		aa.obtener(i).getCelular(),
		aa.obtener(i).getEstado(),		
		};
		
		//Añadir la fila creado al modelo
		modelo.addRow(fila);
		}
		
		//Actualizamos el modelo
		modelo.fireTableDataChanged(); 
		}
	
	 void reportar () { 
	 Alumno a = aa.buscar (leerCodigo ()) ;
	
	 txtS.setText("");
	imprimir("cantidad de Alumnos en el arreglo: " + aa.tamanio());
	
	
    imprimir("Código del Alumno \t:  "+ a.getCodAlumno());
    imprimir("Nombres  \t: "+ a.getNombres());
    imprimir("Apellido \t: "+ a.getApellidos());
    imprimir("DNI N°  \t: "+ a.getDni());
    imprimir("Edad:  \t: "+ a.getEdad());
    imprimir("Celular \t: "+ a.getCelular());
    imprimir("Estado \t: "+ a.getEstado());
    }
    
	
	// posicionandose sobre la tabla 
	 void navegar(){
			int fila=tbltabla.getSelectedRow();

			txtCodigo.setText("" +tbltabla.getValueAt(fila, 0));
			txtNombre.setText("" +tbltabla.getValueAt(fila, 1));
			txtApellido.setText("" +tbltabla.getValueAt(fila, 2));
			txtDni.setText("" +tbltabla.getValueAt(fila, 3));
			txtEdad.setText("" +tbltabla.getValueAt(fila, 4));
			txtCelular.setText("" +tbltabla.getValueAt(fila, 5));  
			cboEstado.getSelectedIndex();  // revisar
			 	}
	 
	
	// devolvera un caja mensaje  
	void mensaje(String s) {
 		JOptionPane.showMessageDialog(this, s);
 	} 
	
/* 	// devolvera un caja mensaje  
	int confirmacion (i s) {
		JOptionPane.showConfirmDialog (this, s); 
 	} */ 
 	
 	//  Métodos que retornan un valor (sin parámetros)
 	int leerCodigo () {
 		return Integer.parseInt(txtCodigo.getText().trim());
 	}
 	String leerNombre() {
 		return txtNombre.getText().trim();
 	}
 	String leerApellido() {
 		return txtApellido.getText().trim();
 	}
 	String leerDni () {
 		return txtDni.getText().trim();
 	}
 	int leerEdad () {
 		return Integer.parseInt(txtEdad.getText().trim());
 	}
 	
 	int leerCelular () {
 		return Integer.parseInt(txtCelular.getText().trim());
 	}
 	 
 	int leerEstado () {
 		return cboEstado.getSelectedIndex();
 	}

 	
 	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbltabla) {
			mouseClickedTbltabla(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTbltabla(MouseEvent e) {
		navegar ();
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tbltabla) {
			keyPressedTbltabla(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyPressedTbltabla(KeyEvent e) {
		navegar ();
	}
}
