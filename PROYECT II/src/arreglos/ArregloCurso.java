package arreglos;

import java.util.ArrayList;

import clases.Curso;

public class ArregloCurso {
	
//  Atributo privado
	private ArrayList <Curso> curso;
//  Constructor
	
	public ArregloCurso() {
		
		curso = new ArrayList <Curso> ();
		
		adicionar(new Curso(5001, 1, 2, 20, "Ingles"));
		adicionar(new Curso(5002, 1, 2, 30, "Matematica II"));
		adicionar(new Curso(5003, 1, 2, 20, "Arquitectura de Datos"));
		adicionar(new Curso(5004, 1, 2, 20, "Desarrollo de habilidades profesionales I"));
		adicionar(new Curso(5005, 1, 2, 20, "Base de Datos"));
	}
	
	//  Operaciones públicas básicas
	public void adicionar (Curso x) {
		curso.add(x);
		grabarCursos();
	}

	void grabarCursos() {
		//leer de memoria y guardarla en un archivo txt
}
	
	public int tamanio () {
		return curso.size();
		}

		public Curso obtener(int i) {
			return curso.get(i);
		}
	
	public Curso buscar(int codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getCodCurso()==codigo) 
			return obtener(i);
			}
			return null;
			}
			
	public void eliminar(Curso x) {
		curso.remove(x); // se elimina en memoria
		actualizarArchivo();// vuelve a pasar el contenido del arraylist al archivo
				
		}
				
		public void actualizarArchivo() {
		grabarCursos();
		}
			
	
	


		}
		
	

	
	
	
	
	
	
	
	

