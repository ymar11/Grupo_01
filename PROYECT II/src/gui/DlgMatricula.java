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

public class DlgMatricula extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAdicionar;
	private JTextField txtAlumno;
	private JTextField txtCurso;
	private DefaultTableModel modelo;
	
	ArregloMatricula am = new ArregloMatricula(); 
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JScrollPane scrollPane_1;
	private JTextArea txtS;
	private JButton btnModificar;
	
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
		setBounds(100, 100, 731, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 559, 207);
		contentPanel.add(scrollPane);
		
		table = new JTable();
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
		txtAlumno.setBounds(162, 60, 96, 19);
		contentPanel.add(txtAlumno);
		txtAlumno.setColumns(10);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(412, 60, 96, 19);
		contentPanel.add(txtCurso);
		txtCurso.setColumns(10);
		
		lblNewLabel = new JLabel("Codigo Alumno:");
		lblNewLabel.setBounds(64, 63, 102, 13);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo Curso:");
		lblNewLabel_1.setBounds(331, 63, 85, 13);
		contentPanel.add(lblNewLabel_1);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(594, 239, 96, 21);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(594, 157, 96, 21);
		btnConsultar.addActionListener(this);
		contentPanel.add(btnConsultar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 343, 559, 164);
		contentPanel.add(scrollPane_1);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane_1.setViewportView(txtS);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(594, 198, 96, 21);
		btnModificar.addActionListener(this);
		contentPanel.add(btnModificar);
	}
	
	
	int leerCodigoAlumno() {
		return Integer.parseInt(txtAlumno.getText().trim());
		
	}
	
	int leerCodigoCurso() {
		return Integer.parseInt(txtCurso.getText().trim());
		
	}
	int leerNumMatricula() {
		return 100001;
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
		int codCurso = leerCodigoCurso();
		int numMatricula = leerNumMatricula();
		String fecha = fecha();
		String hora = hora();	
		Matricula nuevo = new Matricula(numMatricula,codAlumno,codCurso,fecha,hora,1);
	    am.adicionar(nuevo);            
	    listar();
	    limpieza();
		
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
		if(table.getSelectedRow()==-1)
			return;
		
		modelo.removeRow(table.getSelectedRow());
					
		
		
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		Matricula m = am.buscar(leerCodigoAlumno());
		if (m!= null) {
			txtAlumno.setText(""+m.getCodAlumno());
			txtCurso.setText(""+m.getCodCurso());
			
			txtS.setText("");
			imprimir("Numero Matricula: "+ m.getNumMatricula());
			imprimir("Codigo Alumno: "+ m.getCodAlumno());
			imprimir("Codigo Curso: "+ m.getCodCurso());
			imprimir("Fecha: "+ m.getFecha());
			imprimir("Hora: "+ m.getHora());
			imprimir("Estado: "+ m.getEstado());
			
			
		}else {
			mensaje("Codigo "+ leerCodigoAlumno() +" no encontrado");	
			limpieza();
		}
	}

	private void imprimir(String string) {
		// TODO Auto-generated method stub
		txtS.append(string + "\n");
	}

	private void mensaje(String string) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, string);
		
	}
	void limpieza() {	 
		txtAlumno.setText("");
		txtCurso.setText("");
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		 Matricula m = am.buscar(leerCodigoAlumno());
	        if (m!=null) {
	        	int codAlum = leerCodigoAlumno();
	        	int codCurs = leerCodigoCurso();
	        	       	
	        	
	        	//asignando valores
	        	
	        	m.setCodAlumno(codAlum);
	        	m.setCodCurso(codCurs);
	        	
	        	
	        	listar();
	        	mensaje("Datos modificados");
	        	} else {
	        		mensaje("Codigo"+ leerCodigoAlumno() +"no encontrado");
	        	
	        	}
			limpieza();
	}
}






