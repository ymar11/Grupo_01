package gui;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import arreglos.ArregloMatricula;
import clases.Matricula;

import arreglos.ArregloAlumnos;
import clases.Alumno;


import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class DlgMatricula extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAdicionar;
	private JTextField txtAlumno;
	private JTextField txtCurso;
	private DefaultTableModel modelo;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JTextField txtNum;
	private JTextField txtEstado;
	private JTextField txtHora;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtFecha;
	private JLabel lblNewLabel_5;
	private JComboBox cboAlumno;
	private JButton btnMatricular;
	private JButton btnLimpiar;
	private JComboBox cboCurso;
	private JLabel lblNewLabel_6;
	
	
	ArregloMatricula am = new ArregloMatricula(); 
	ArregloAlumnos aa= new ArregloAlumnos ();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMatricula dialog = new DlgMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMatricula() {
		setTitle("Matricula");
		setBounds(100, 100, 725, 522);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 151, 548, 303);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(this);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"N.Matricula", "Cod.Alumno", "Cod.Curso", "Fecha", "Hora", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(DlgMatricula.class.getResource("/imagenes/adicionar.png")));
		btnAdicionar.setEnabled(false);
		btnAdicionar.setBounds(236, 30, 141, 28);
		btnAdicionar.addActionListener(this);
		contentPanel.add(btnAdicionar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Num. Matricula");
		modelo.addColumn("Cod. Alumno");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		modelo.addColumn("Estado");
		table.setModel(modelo);
		
		txtAlumno = new JTextField();
		txtAlumno.setEditable(false);
		txtAlumno.setBounds(121, 63, 96, 19);
		contentPanel.add(txtAlumno);
		txtAlumno.setColumns(10);
		
		txtCurso = new JTextField();
		txtCurso.setEditable(false);
		txtCurso.setBounds(121, 92, 96, 19);
		contentPanel.add(txtCurso);
		txtCurso.setColumns(10);
		
		lblNewLabel = new JLabel("Codigo Alumno:");
		lblNewLabel.setBounds(26, 66, 102, 13);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo Curso:");
		lblNewLabel_1.setBounds(26, 95, 85, 13);
		contentPanel.add(lblNewLabel_1);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(DlgMatricula.class.getResource("/imagenes/eliminar.png")));
		btnEliminar.setBounds(560, 290, 141, 35);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(DlgMatricula.class.getResource("/imagenes/consultar.png")));
		btnConsultar.setBounds(560, 172, 141, 35);
		btnConsultar.addActionListener(this);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(DlgMatricula.class.getResource("/imagenes/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(560, 232, 141, 35);
		contentPanel.add(btnModificar);
		
		txtNum = new JTextField();
		txtNum.setEditable(false);
		txtNum.setBounds(121, 38, 96, 19);
		contentPanel.add(txtNum);
		txtNum.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(121, 122, 96, 19);
		contentPanel.add(txtEstado);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(278, 122, 96, 19);
		contentPanel.add(txtHora);
		
		lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(395, 125, 45, 13);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setBounds(233, 125, 45, 13);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Estado:");
		lblNewLabel_4.setBounds(26, 120, 85, 21);
		contentPanel.add(lblNewLabel_4);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(450, 122, 96, 19);
		contentPanel.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Num. Matricula:");
		lblNewLabel_5.setBounds(26, 38, 102, 13);
		contentPanel.add(lblNewLabel_5);
		
		cboAlumno = new JComboBox();
		cboAlumno.addActionListener(this);
		cboAlumno.setBounds(236, 62, 119, 21);
		contentPanel.add(cboAlumno);
		CodigosAlumnos();
		btnMatricular = new JButton("Matricular");
		btnMatricular.addActionListener(this);
		btnMatricular.setBounds(472, 10, 110, 28);
		contentPanel.add(btnMatricular);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(DlgMatricula.class.getResource("/imagenes/limpiar.png")));
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(560, 351, 141, 35);
		contentPanel.add(btnLimpiar);
		
		cboCurso = 	new JComboBox();
		cboCurso.addActionListener(this);
		cboCurso.setBounds(236, 91, 119, 21);
		contentPanel.add(cboCurso);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(DlgMatricula.class.getResource("/imagenes/matricula.png")));
		lblNewLabel_6.setBounds(592, 10, 130, 115);
		contentPanel.add(lblNewLabel_6);
		CodigosCursos();
        
		
		listar();
	}
	
	
	int leerCodigoAlumno() {
		return Integer.parseInt(txtAlumno.getText().trim());
		
	}
	
	int leerCodigoCurso() {
		return Integer.parseInt(txtCurso.getText().trim());
		
	}
	int leerNumMatricula() {
		
		return am.codigoCorrelativo();
	}
	int leerEstado() {
		return 1;
	}
	int estado() {
		return Integer.parseInt(txtEstado.getText().trim());
	}
	
	String Hour() {
		return txtHora.getText().trim();
	}
	String Date() {
		return txtFecha.getText().trim();
	}
	int NumMat() {
		return Integer.parseInt(txtNum.getText().trim());
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCurso) {
			actionPerformedCboCurso(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == cboAlumno) {
			actionPerformedCboAlumno(e);
		}
		if (e.getSource() == btnMatricular) {
			actionPerformedBtnMatricular(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	
	//boton adicionar 
		protected void actionPerformedBtnNewButton(ActionEvent e) {
			 Alumno a = aa.buscar(leerCodigoAlumno());

			 
			if (a!=null ) {
				 
			a.setEstado(1); 
			
			int codAlumno = leerCodigoAlumno();
			
			
			int codCurso = leerCodigoCurso();
			int numMatricula = leerNumMatricula();
			String fecha = fecha();
			String hora = hora();	
			Matricula nuevo = new Matricula(numMatricula,codAlumno,codCurso,fecha,hora,1);
		    am.adicionar(nuevo);            
		    listar();
		    limpieza();
		    mensaje("DATOS REGISTRADOS");
		} else {
			mensaje("EL CODIGO DE ALUMNO NO EXISTE");
		    limpieza();
		}
		}


	
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < am.tamaño(); i++) {
	
		Object[] fila = {
				am.obtener(i).getNumMatricula(),
				am.obtener(i).getCodAlumno(),
				am.obtener(i).getCodCurso(),
				am.obtener(i).getFecha(),
				am.obtener(i).getHora(),
				am.obtener(i).getEstado()
				
		};
		modelo.addRow(fila);
		
	}
	
	}	
	
	public String fecha() {
		Calendar date = new GregorianCalendar();
		String dia = Integer.toString(date.get(Calendar.DATE));
		String mes = Integer.toString(date.get(Calendar.MONTH)+1);
		String año = Integer.toString(date.get(Calendar.YEAR));
		
		return dia+"/"+mes+"/"+año;
				
	}
	
	public String hora() {
		Calendar hour = new GregorianCalendar();
		
		String hora = Integer.toString(hour.get(Calendar.HOUR_OF_DAY));
		String minuto = Integer.toString(hour.get(Calendar.MINUTE));
		
		return hora+":"+minuto;
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		Matricula m = am.buscar(leerCodigoAlumno());
		if(m!=null) {
			am.eliminar(m);
			listar();
			limpieza();
			mensaje("Datos eliminados");
			cboAlumno.removeItem(cboAlumno.getSelectedItem());
		}else {
			mensaje("Codigo "+ leerCodigoAlumno()+" no existe");
		}
					
		
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		Matricula m = am.buscar(leerCodigoAlumno());
		if (m!= null) {
			txtAlumno.setText(""+m.getCodAlumno());
			txtCurso.setText(""+m.getCodCurso());
			txtNum.setText(""+m.getNumMatricula());
			txtHora.setText(""+m.getHora());
			txtFecha.setText(""+m.getFecha());
			txtEstado.setText(""+m.getEstado());	
			txtEstado.setEditable(true);
			txtFecha.setEditable(true);
			txtHora.setEditable(true);
			txtAlumno.setEditable(true);
			txtCurso.setEditable(true);
			btnAdicionar.setEnabled(false);
			
		}else {
			mensaje("Codigo "+ leerCodigoAlumno() +" no encontrado");	
			limpieza();
		}
	}

	//private void imprimir(String string) {
		// TODO Auto-generated method stub
		//txtS.append(string + "\n");
	//}

	private void mensaje(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
		
	}
	void limpieza() {	 
		txtAlumno.setText("");
		txtCurso.setText("");
		txtNum.setText("");
		txtEstado.setText("");
		txtFecha.setText("");
		txtHora.setText("");
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		 Matricula m = am.buscar(leerCodigoAlumno());
	        if (m!=null) {
	        	int codAlum = leerCodigoAlumno();
	        	int codCurs = leerCodigoCurso();
	        	int numMatricula = NumMat();
	        	String fecha = Date();
	        	String hora = Hour();
	        	int estado = estado();
	        	       	
	        	
	        	//asignando valores
	        	
	        	m.setCodAlumno(codAlum);
	        	m.setCodCurso(codCurs);
	        	m.setEstado(estado);
	        	m.setFecha(fecha);
	        	m.setHora(hora);
	        	m.setNumMatricula(numMatricula);
	        	
	        	txtEstado.setEditable(false);
	        	txtHora.setEditable(false);
	        	txtFecha.setEditable(false);
	        	listar();
	        	mensaje("Datos modificados");
	        	btnMatricular.setEnabled(true);
	        	} else {
	        		mensaje("Codigo"+ leerCodigoAlumno() +"no encontrado");
	        	
	        	}
			limpieza();
	}
	
	void navegar(){

        int fila=table.getSelectedRow();

        txtNum.setText("" +table.getValueAt(fila, 0));

        txtAlumno.setText("" +table.getValueAt(fila, 1));

        txtCurso.setText("" +table.getValueAt(fila, 2));

        txtFecha.setText("" +table.getValueAt(fila, 3));
        
        txtHora.setText(""+table.getValueAt(fila, 4));
        
        txtEstado.setText(""+table.getValueAt(fila, 5));
        }
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
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
	protected void mouseClickedTable(MouseEvent e) {
		navegar();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == table) {
			keyReleasedTable(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTable(KeyEvent e) {
		navegar();
	}
	
	void CodigosAlumnos() {
		ArregloMatricula am = new ArregloMatricula();
		Matricula m;
		for(int i=0; i<am.tamaño();i++) {
			m= am.obtener(i);
			if(am.CodigoAlumno(m.getCodAlumno()))
				cboAlumno.addItem(""+m.getCodAlumno());
		}
	}
	
	void CodigosCursos() {
		ArregloMatricula am = new ArregloMatricula();
		Matricula m;
		for(int i=0; i<am.tamaño();i++) {
			m= am.obtener(i);
			if(am.CodigoCurso(m.getCodCurso()))
				cboCurso.addItem(""+m.getCodCurso());
		}
	}
	protected void actionPerformedBtnMatricular(ActionEvent e) {
	
			btnAdicionar.setEnabled(true);
			btnMatricular.setEnabled(false);
			txtAlumno.setEditable(true);
			txtCurso.setEditable(true);
			txtAlumno.setText(""+ cboAlumno.getSelectedItem());
			txtCurso.setText(""+cboCurso.getSelectedItem());
			limpieza();
		}
	
	
	
	protected void actionPerformedCboAlumno(ActionEvent e) {
			txtAlumno.setText("" + cboAlumno.getSelectedItem());		
	}
	
	protected void actionPerformedCboCurso(ActionEvent e) {
		txtCurso.setText(""+cboCurso.getSelectedItem());
	}
	
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpieza();
		

		}
	}
   

