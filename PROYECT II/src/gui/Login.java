package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblUsuarios;
	private JTextField txtUsuario;
	private JLabel lblPassword;
	private JPasswordField Jpassword;
	private JButton btnIngresar;
	private JButton btnNewButton;
	private JLabel lblIngresoAlSistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
					// CENTRAR VENTANA EN LA PANTALLA
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(new Color(75, 0, 130));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 251);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuarios = new JLabel("Usuarios : ");
		lblUsuarios.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblUsuarios.setBounds(62, 81, 74, 14);
		contentPane.add(lblUsuarios);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(157, 78, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblPassword.setBounds(62, 106, 85, 14);
		contentPane.add(lblPassword);
		
		Jpassword = new JPasswordField();
		Jpassword.setBounds(157, 106, 86, 20);
		contentPane.add(Jpassword);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.setBackground(new Color(245, 245, 245));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(62, 158, 89, 23);
		contentPane.add(btnIngresar);
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setBounds(189, 158, 89, 23);
		contentPane.add(btnNewButton);
		
		lblIngresoAlSistema = new JLabel("LOGIN ");
		lblIngresoAlSistema.setIcon(new ImageIcon(Login.class.getResource("/imagenes/key.png")));
		lblIngresoAlSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngresoAlSistema.setForeground(SystemColor.textHighlight);
		lblIngresoAlSistema.setBounds(84, 11, 159, 59);
		contentPane.add(lblIngresoAlSistema);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		
		// DECLARACION VARIABLES
		String user, pass; 
			
		//  ENTRADA DATOS		
		user = txtUsuario.getText();
		pass = String.valueOf(Jpassword.getPassword());
				
		// PROGRMACION
		if (user.equals("grupo01")&& pass.equals("123")) {
		this.dispose(); /// CERRAR VENTANA ACTUAL (LOGIN) 

		mensaje ("Bienvenidos a nuestro sistema ");

		Menu_Principal prin = new Menu_Principal (); // VENTANA PRINCIPAL REPRESENTADA POR VARIABLE PRIN

		prin.setLocationRelativeTo(this); // THIS ES UBICACIÓN

		prin.setVisible(true); // PARA QUE LA VENTANA SEA VISIBLE 	
		prin.setExtendedState(MAXIMIZED_BOTH); 

		
		}

		
		else {			
		mensaje ( "Usurario o contraseña incorrecto"); 
		txtUsuario.setText("");
		Jpassword.setText("");
		txtUsuario.requestFocus();
		}
	}
	
	  void mensaje(String cadenaMensaje) {
			JOptionPane.showMessageDialog(null, cadenaMensaje);
		    }
		
	  
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		System.exit (0);
	}
	} 
