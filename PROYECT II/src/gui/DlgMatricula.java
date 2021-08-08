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
	
	ArregloMatricula am = new ArregloMatricula(); 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMatricula dialog = new DlgMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			// CENTRAR VENTANA EN LA PANTALLA
			dialog.setLocationRelativeTo(null);
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
		setBounds(100, 100, 725, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 559, 207);
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
		btnAdicionar.setBounds(594, 116, 96, 21);
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
		txtAlumno.setBounds(161, 43, 96, 19);
		contentPanel.add(txtAlumno);
		txtAlumno.setColumns(10);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(426, 43, 96, 19);
		contentPanel.add(txtCurso);
		txtCurso.setColumns(10);
		
		lblNewLabel = new JLabel("Codigo Alumno:");
		lblNewLabel.setBounds(67, 46, 102, 13);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo Curso:");
		lblNewLabel_1.setBounds(331, 46, 85, 13);
		contentPanel.add(lblNewLabel_1);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(594, 239, 96, 21);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(594, 157, 96, 21);
		btnConsultar.addActionListener(this);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(594, 198, 96, 21);
		contentPanel.add(btnModificar);
		
		txtNum = new JTextField();
		txtNum.setBounds(108, 354, 122, 19);
		contentPanel.add(txtNum);
		txtNum.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(386, 411, 122, 19);
		contentPanel.add(txtEstado);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(108, 411, 122, 19);
		contentPanel.add(txtHora);
		
		lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(331, 357, 45, 13);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setBounds(10, 414, 45, 13);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Estado:");
		lblNewLabel_4.setBounds(331, 414, 45, 13);
		contentPanel.add(lblNewLabel_4);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(386, 354, 122, 19);
		contentPanel.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Num. Matricula:");
		lblNewLabel_5.setBounds(10, 357, 102, 13);
		contentPanel.add(lblNewLabel_5);
		
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
	
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		int codAlumno = leerCodigoAlumno();
		
		if (am.buscar(codAlumno)==null) {
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
		mensaje("EL CODIGO DE ALUMNO YA EXISTE");
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
	        	
	        	
	        	listar();
	        	mensaje("Datos modificados");
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
}