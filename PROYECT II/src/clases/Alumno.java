package clases;

public class Alumno {
	// atributos 
	private int codAlumno;
	private String nombres;
	private String apellidos;
	private int dni;
	private int edad ;
	private int celular;	
	private  int  estado;
	
	
	// constructor
	public Alumno(int codAlumno, String nombres, String apellidos, int dni, int edad, int celular, int estado) {
	//	super();
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}


	public int getCodAlumno() {
		return codAlumno;
	}


	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getCelular() {
		return celular;
	}


	public void setCelular(int celular) {
		this.celular = celular;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}

		
}
