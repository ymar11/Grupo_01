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
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumnos;
import clases.Alumno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Mantenimiento_Alumno extends JDialog implements ActionListener, MouseListener, KeyListener {
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
	private JTable tblTabla;
	
	//declaracion global
	ArregloAlumnos aa = new ArregloAlumnos (); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mantenimiento_Alumno dialog = new Mantenimiento_Alumno();
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
	public Mantenimiento_Alumno() {
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mantenimiento_Alumno.class.getResource("/imagenes/sistema.png")));
		setTitle("MANTENIMIENTO |  ALUMNOS ");
		setBounds(100, 100, 740, 631);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigo.setBounds(10, 11, 64, 14);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 38, 64, 14);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(10, 63, 64, 14);
		getContentPane().add(lblApellido);
		
		lblDni = new JLabel("DNI  N\u00B0");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDni.setBounds(10, 91, 64, 14);
		getContentPane().add(lblDni);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCelular.setBounds(10, 116, 46, 14);
		getContentPane().add(lblCelular);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(10, 144, 64, 14);
		getContentPane().add(lblEstado);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEdad.setBounds(193, 91, 46, 14);
		getContentPane().add(lblEdad);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(84, 11, 121, 20);
		getContentPane().add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(84, 38, 121, 20);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(84, 63, 121, 20);
		getContentPane().add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(84, 88, 86, 20);
		getContentPane().add(txtDni);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(84, 116, 86, 20);
		getContentPane().add(txtCelular);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(237, 88, 86, 20);
		getContentPane().add(txtEdad);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Registrado ", "Matriculado ", "Retirado"}));
		cboEstado.setBounds(84, 140, 115, 22);
		getContentPane().add(cboEstado);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 200, 697, 227);
		getContentPane().add(scrollPaneA);
		
		
		tblTabla = new JTable();
		tblTabla.addKeyListener(this);
		tblTabla.addMouseListener(this);
		tblTabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO ", "NOMBRES", "APELLIDOS ", "DNI N\u00B0", "EDAD", "CELULAR", "ESTADO"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblTabla.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblTabla.getColumnModel().getColumn(1).setPreferredWidth(105);
		tblTabla.getColumnModel().getColumn(2).setPreferredWidth(101);
		tblTabla.getColumnModel().getColumn(3).setPreferredWidth(80);
		tblTabla.getColumnModel().getColumn(5).setPreferredWidth(78);
		scrollPaneA.setViewportView(tblTabla);
		
		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 455, 697, 105);
		getContentPane().add(scrollPaneB);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(UIManager.getColor("FormattedTextField.selectionForeground"));
		btnAdicionar.setIcon(new ImageIcon(Mantenimiento_Alumno.class.getResource("/imagenes/Proceso.png")));
		btnAdicionar.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(342, 17, 149, 41);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(UIManager.getColor("FormattedTextField.selectionForeground"));
		btnModificar.setIcon(new ImageIcon(Mantenimiento_Alumno.class.getResource("/imagenes/edit.png")));
		btnModificar.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(342, 69, 149, 39);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Mantenimiento_Alumno.class.getResource("/imagenes/Salir (2).png")));
		btnEliminar.setBackground(UIManager.getColor("FormattedTextField.selectionForeground"));
		btnEliminar.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(342, 115, 149, 39);
		getContentPane().add(btnEliminar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.setBackground(UIManager.getColor("FormattedTextField.selectionForeground"));
		btnReportar.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnReportar.addActionListener(this);
		btnReportar.setBounds(342, 166, 149, 23);
		getContentPane().add(btnReportar);
		
		listar ();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		/**
		 * Adiciona un nuevo alumno validando que el código no se repita
		 */
		 int codigo = leerCodigo ();
		
		if (aa.buscar(codigo) == null) {
			
			// recuperamos valores de la caja de texto
			String nombre = leerNombre ();
			String apellidos = leerApellido();
			String dni = leerDni ();
			int edad = leerEdad ();
			int celular  = leerCelular ();
			int  estado = leerEstado ();
			
			//creamos el objeto alumno  
			Alumno nuevo = new Alumno (codigo, nombre, apellidos, dni, edad, celular,  estado);
			
			//adicionamos al arrayList 
			aa.adicionar(nuevo);
			listar ();
			limpieza ();
			
			mensaje ("Datos registrados con éxito");
			
			
		} else {
			mensaje ("El código de alumnos ya existe");
		}	 
		
		
		
		
	}
		 

	protected void actionPerformedBtnModificar(ActionEvent e) {
		 int codigo = leerCodigo(); 

		 if (aa.buscar(codigo)!=null) {

			 //Recuperamos valores de las cajas texto
				String nombre = leerNombre ();
				String apellidos = leerApellido();
				String dni = leerDni ();
				int edad = leerEdad ();
				int celular  = leerCelular ();
				int  estado = leerEstado ();
						 

			 Alumno x = aa.buscar(codigo);
			 x.setNombres (nombre);
			 x.setApellidos (apellidos);
			 x.setDni(dni);
			 x.setEdad (edad);			 
			 x.setCelular (celular);
			 x.setEstado(estado);

			 aa.actualizarArchivo();
			 listar();
			 limpieza();

			 mensaje("Datos actualizados con éxito");

		 }else {
			 mensaje("El código de alumno no existe");
		 }
		
		
	}
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		 
		int codigo = leerCodigo();  
			if (aa.buscar(codigo)==null ) {
				mensaje ("El código no existe");
			} else  {
				Alumno x = aa.buscar(codigo);
				aa.eliminar(x);
				listar ();
				mensaje (" El alumno fue eliminado con exito");
			}
			
			limpieza ();	
		
	}
	
	
	
	protected void actionPerformedBtnReportar(ActionEvent e) {
		
	}
	
	
	//  Métodos tipo void (sin parámetros)
	void limpieza() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		cboEstado.getSelectedIndex();
		txtCodigo.requestFocus();
	}

   	
   	void listar() {
   		//Obtenemos el modelo de la tabla
		DefaultTableModel modelo = (DefaultTableModel) tblTabla.getModel();

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
   	  	 
   	
   	
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
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
 	
 	
	void navegar(){

		int fila=tblTabla.getSelectedRow();

		txtCodigo.setText("" +tblTabla.getValueAt(fila, 0));

		txtNombre.setText("" +tblTabla.getValueAt(fila, 1));

		txtApellido.setText("" +tblTabla.getValueAt(fila, 2));

		txtDni.setText("" +tblTabla.getValueAt(fila, 3));

		txtEdad.setText("" +tblTabla.getValueAt(fila, 4));
		
		txtCelular.setText("" +tblTabla.getValueAt(fila, 5));
		cboEstado.getSelectedIndex();  // txtEstado.getStelec("" +tblTabla.getValueAt(fila, 4));
		

	}

	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblTabla) {
			mouseClickedTblTabla(e);
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
	protected void mouseClickedTblTabla(MouseEvent e) {
		navegar ();
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tblTabla) {
			keyPressedTblTabla(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyPressedTblTabla(KeyEvent e) {
		navegar ();
	}
}
