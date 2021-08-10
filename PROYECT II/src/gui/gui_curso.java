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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCurso;
import clases.Curso;
import libreria.Libr;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class gui_curso extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField txtCodigo;
	private JLabel lblNewLabel_1;
	private JTextField txtHoras;
	private JLabel lblNewLabel_2;
	private JTextField txtCreditos;
	private JLabel lblNewLabel_3;
	private JTextField txtAsignatura;
	private JLabel lblNewLabel_4;
	private JComboBox  comboBox;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTable table;
	

	//declaración global
	
	ArregloCurso ac = new ArregloCurso();
	private JTextArea txtS;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			gui_curso dialog = new gui_curso();
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
	public gui_curso() {
		setTitle("CURSOS  ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(gui_curso.class.getResource("/imagenes/Asignatura.png")));
		setBounds(100, 100, 865, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(21, 10, 46, 30);
		contentPanel.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(91, 15, 96, 19);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Horas");
		lblNewLabel_1.setBounds(223, 21, 46, 19);
		contentPanel.add(lblNewLabel_1);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(262, 21, 58, 19);
		contentPanel.add(txtHoras);
		
		lblNewLabel_2 = new JLabel("Creditos");
		lblNewLabel_2.setBounds(362, 21, 70, 19);
		contentPanel.add(lblNewLabel_2);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(418, 21, 96, 19);
		contentPanel.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Asignatura");
		lblNewLabel_3.setBounds(21, 64, 96, 19);
		contentPanel.add(lblNewLabel_3);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(91, 64, 96, 19);
		contentPanel.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Ciclo");
		lblNewLabel_4.setBounds(223, 65, 46, 16);
		contentPanel.add(lblNewLabel_4);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
		comboBox.setBounds(262, 63, 113, 20);
		contentPanel.add(comboBox);
		
		
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(gui_curso.class.getResource("/imagenes/add.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(543, 15, 145, 30);
		contentPanel.add(btnAdicionar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(gui_curso.class.getResource("/imagenes/delete.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(715, 15, 129, 30);
		contentPanel.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(gui_curso.class.getResource("/imagenes/editor.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(543, 63, 145, 30);
		contentPanel.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(gui_curso.class.getResource("/imagenes/buscar.png")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(715, 63, 129, 30);
		contentPanel.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(21, 139, 807, 181);
		contentPanel.add(scrollPane);
		
		
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.addKeyListener(this);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Horas", "Creditos", "Asignatura", "Ciclo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(2).setPreferredWidth(69);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		
		
		
		scrollPane.setViewportView(table);
		
		txtS = new JTextArea();
		txtS.setBounds(41, 361, 13, 10);
		contentPanel.add(txtS);
	
		listar();

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
	
	
	//lcek
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		/**
		 * Adiciona un nuevo curso validando que el código no se repita
		 */	
		int codCurso = leerCodigo();
		if (ac.buscar(codCurso)==null) {
			
			//Recuperamos valores de las cajas de texto
			int horas= leerHoras();
			int creditos= leerCreditos();
			String asignatura= leerAsignatura();
			int ciclo=leerCiclo();
			
			// crear el objeto curso
			
			Curso nuevo = new Curso(codCurso, ciclo, creditos, horas, asignatura);
			// adicionarlo al ArrayList y al archivo de texto
			
			ac.adicionar(nuevo);
			listar();
			limpieza();
			
			mensaje ("Datos registrados con exito");
			
		}else {
			mensaje("El código de curso ya existe");
		}
		}


		
		//Metodo de retorna valor (sin parametros)

		int leerCodigo() {
			return Integer.parseInt(txtCodigo.getText().trim());
		}

		int leerCiclo () {
			return comboBox.getSelectedIndex();
		}
		int leerCreditos() {
			return Integer.parseInt(txtCreditos.getText().trim());
		}

		int leerHoras() {
			return Integer.parseInt(txtHoras.getText().trim());
		}

		String leerAsignatura() {
			return txtAsignatura.getText().trim();
		}	
	
		
		void navegar(){

			int fila=table.getSelectedRow();

			txtCodigo.setText("" +table.getValueAt(fila, 0));

			txtHoras.setText("" +table.getValueAt(fila, 1));

			txtCreditos.setText("" +table.getValueAt(fila, 2));

			txtAsignatura.setText("" +table.getValueAt(fila, 3));

			comboBox.setActionCommand("" +table.getValueAt(fila, 4));

		}
		
		//  Métodos tipo void (sin parámetros)
			
		void limpieza() {
			txtCodigo.setText("");
			txtHoras.setText("");
			txtCreditos.setText("");
			txtHoras.setText("");
			txtAsignatura.setText("");
			txtCodigo.requestFocus();
		}
				
			void listar() {
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setRowCount(0);
				for (int i = 0; i < ac.tamanio(); i++) {
					Object[] fila= {
									ac.obtener(i).getCodCurso(),
									ac.obtener(i).getHoras(),
									ac.obtener(i).getCreditos(),
									ac.obtener(i).getAsignatura(),
									//ac.obtener(i).getCiclo()
					                Libr.estadosCiclo[ac.obtener(i).getCiclo()]				 

									
					};
					
					modelo.addRow(fila);
							
					}		
	}
			
 	 // Métodos tipo void (con parámetros)
		   	void imprimir(String s) {
		   	txtS.append(s + "\n");
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
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		
		/**
		 * Busca un código y si existe edita los datos del producto
		 */
		int codigo = leerCodigo();
		Curso x = ac.buscar(codigo);
		if (x != null) {
			txtHoras.setText("" + x.getHoras());
			txtCreditos.setText("" + x.getCreditos());
			txtAsignatura.setText("" + x.getAsignatura());
			comboBox.setActionCommand("" + x.getCiclo());
			txtCodigo.requestFocus();
		}
		else {
			mensaje("No existe el código");
			limpieza();
		}
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
		int codigo = leerCodigo();
		if (ac.buscar(codigo)!=null) {
			
			//Recuperamos valores de las cajas de texto
			
			String asignatura= leerAsignatura();
			int horas= leerHoras();
			int creditos= leerCreditos();
			int ciclo= leerCiclo();
			
			Curso x = ac.buscar(codigo);
			x.setAsignatura(asignatura);
			x.setHoras(horas);
			x.setCreditos(creditos);
			x.setCiclo(ciclo);
						
			ac.cargarArchivo();	
			listar();
			limpieza();
			
			mensaje ("Datos actualizados con exito");
			
		}else {
			mensaje("El código de producto no existe");
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		/**
		 * Busca un código y si existe retira al curso del arreglo
		 */	
		 
		
		int codigo = leerCodigo();
		if (ac.buscar(codigo)== null) {
			mensaje("El codigo no existe");
		}else {
			Curso x = ac.buscar(codigo);
			ac.eliminar(x);
			listar();
			mensaje ("El curso fue eliminado con exito");
		}
		
		limpieza();
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			mouseClickedTable(arg0);
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
	protected void mouseClickedTable(MouseEvent arg0) {
		
		navegar();
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == table) {
			keyReleasedTable(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTable(KeyEvent arg0) {
		navegar();
	}

 	//  Métodos tipo void (sin parámetros)
		
		void imprimir() {
			imprimir("");
			} 
	}
	
	


