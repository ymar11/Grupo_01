package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCursos;
import clases.Curso;

public class jframeCurso extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblAsignatura;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JComboBox comboBox;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblTable;
	private JScrollPane scrollPane_1;
	
// tipo de operación a procesar: adicionar, consultar
	// Modificar o Eliminar
	
	private int tipoOperacion;
	
	//Constantes para los tipos de Operaciones
	
	public final static int ADICIONAR =0;
	public final static int CONSULTAR =1;
	public final static int MODIFICAR =2;
	public final static int ELIMINAR =3;
	
	
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnReportar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jframeCurso frame = new jframeCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jframeCurso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(33, 32, 116, 24);
		contentPane.add(lblCodigo);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(33, 77, 116, 24);
		contentPane.add(lblAsignatura);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setBounds(33, 113, 116, 24);
		contentPane.add(lblCiclo);
		
		lblCreditos = new JLabel("Creditos");
		lblCreditos.setBounds(358, 32, 116, 24);
		contentPane.add(lblCreditos);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(214, 32, 116, 24);
		contentPane.add(lblHoras);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(115, 32, 76, 24);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(115, 80, 176, 24);
		txtAsignatura.setColumns(10);
		contentPane.add(txtAsignatura);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(420, 33, 56, 24);
		txtCreditos.setColumns(10);
		contentPane.add(txtCreditos);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(264, 33, 56, 24);
		txtHoras.setColumns(10);
		contentPane.add(txtHoras);
		
		comboBox = new JComboBox();
		comboBox.setBounds(115, 111, 170, 29);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto"}));
		contentPane.add(comboBox);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(545, 10, 170, 29);
		btnAdicionar.addActionListener(this);
		contentPane.add(btnAdicionar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(545, 49, 170, 29);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 244, 854, 132);
		contentPane.add(scrollPane);
		
		tblTable = new JTable();
		tblTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo de Curso", "Asignatura", "Ciclo", "Creditos", "Horas"
			}
		));
		scrollPane.setViewportView(tblTable);
		
		listar();
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 386, 854, 245);
		contentPane.add(scrollPane_1);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane_1.setViewportView(txtS);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(545, 138, 170, 29);
		contentPane.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(545, 99, 170, 29);
		contentPane.add(btnConsultar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.setBounds(545, 192, 168, 25);
		btnReportar.addActionListener(this);
		contentPane.add(btnReportar);
	}
	
	
	
	//Declaración Global
	ArregloCursos ac = new ArregloCursos();
	private JTextArea txtS;
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnReportar) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	
	
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		
		//adicionar nuevo curso
		
		int codCurso = leerCodigo();
		if (ac.buscar(codCurso) == null) {
		int ciclo = leerCiclo();
		int creditos = leerCreditos();
		int horas = leerHoras();
		String asignatura = leerAsignatura();
		
		//creando objeto nuevo
		//pasamos valores al constructor del objeto
		Curso nuevo = new Curso(codCurso, ciclo, creditos, horas, asignatura);
		
		
		// añade el objeto al arraylist
		ac.adicionar(nuevo);
		
		//listamos para mostrar el jtable
		listar();
		limpieza();
		}
		else
			mensaje("el CÓDIGO ya existe");
		}
		
		//listar los elementos del arraylist
	
	
	
	void limpieza() {
		txtCodigo.setText("");
		txtCreditos.setText("");
		txtHoras.setText("");
		txtAsignatura.setText("");
		txtCodigo.requestFocus();
	}
	

	
	void listar() {
		//Obtenemos el modelo de la tabla
		DefaultTableModel modelo = (DefaultTableModel) tblTable.getModel();
		
	//Se establece la primera fila al modelo
		modelo.setRowCount(0);
		
		for (int i = 0; i< ac.tamaño(); i++) {
			//creando una fila por cada objeto
			Object fila[] = {
					
								ac.obtener(i).getCodCurso(),
								ac.obtener(i).getAsignatura(),
								ac.obtener(i).getCiclo(),
								ac.obtener(i).getCreditos(),
								ac.obtener(i).getHoras()};
			
			modelo.addRow(fila);
			}
		}



void navegar(){
	int fila=tblTable.getSelectedRow();

	txtCodigo.setText("" +tblTable.getValueAt(fila, 0));
	txtCreditos.setText("" +tblTable.getValueAt(fila, 1));
	txtHoras.setText("" +tblTable.getValueAt(fila, 2));
	txtAsignatura.setText("" +tblTable.getValueAt(fila, 3));
	comboBox.setActionCommand(""+tblTable.getValueAt(fila,4));

}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		/**
		 * Busca un código y si existe retira al alumno del arreglo
		 */
		int codigo = leerCodigo();
		Curso x = ac.buscar(codigo);
		if (x != null) {
			ac.eliminar(x);
			listar();
		}
		else
			mensaje("No existe código");
		limpieza();
	}
		
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		Curso s=ac.buscar(leerCodigoCurso());
		txtS.setText("");
		
		
        imprimir("Código de curso: "+ s.getCodCurso());
        imprimir("La Asigantura es "+ s.getAsignatura());
        imprimir("El Ciclo es: "+ s.getCiclo());
        imprimir("La Cantidad de Créditos es: "+ s.getCreditos());
        imprimir("La cantidad de Horas: "+ s.getHoras());
        
		
	}
	    	
	int leerCodigoCurso() {
        return Integer.parseInt(txtCodigo.getText().trim());

    }
    	
	
		//  Métodos tipo void (con parámetros)
	
		
		void mensaje(String s) {
			JOptionPane.showMessageDialog(this, s);
		}
		
		private void imprimir(String string) {
	        // TODO Auto-generated method stub
	        txtS.append(string + "\n");
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
	protected void actionPerformedBtnConsultar(ActionEvent e) {
	
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		/**
		 * Busca un código y si existe modifica los datos del alumnno
		 */
		int codCurso = leerCodigo();
		Curso x = ac.buscar(codCurso);
		if (x != null) {
			
			
			int credito = leerCreditos();
			int ciclo = leerCiclo();
			String asignatura = leerAsignatura();
			int horas = leerHoras();
			x.setCodCurso(codCurso);
			x.setCreditos(credito);
			
			listar();
			
		
		}
		else
			mensaje("el CÓDIGO no existe");
		limpieza();
	}
}

