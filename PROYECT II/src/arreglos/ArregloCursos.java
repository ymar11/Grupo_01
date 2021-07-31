
package arreglos;

import java.util.ArrayList;
import clases.Curso;

public class ArregloCursos {
	
	//  Atributo privado
	private ArrayList <Curso> curso;
	//  Constructor
	public ArregloCursos() {
		
		curso = new ArrayList <Curso> ();
			
		adicionar(new Curso(5001, 1, 2, 20, "Ingles"));
		adicionar(new Curso(5002, 1, 2, 30, "Matematica II"));
		adicionar(new Curso(5003, 1, 2, 20, "Arquitectura de Datos"));
		adicionar(new Curso(5004, 1, 2, 20, "Desarrollo de habilidades profesionales I"));
		adicionar(new Curso(5005, 1, 2, 20, "Base de Datos"));
	}
	//  Operaciones p�blicas b�sicas
	public void adicionar (Curso x) {
		curso.add(x);
		
	}

	public void eliminar(Curso x) {
		curso.remove(x);
	}
	
	public int tama�o() {
		return curso.size();
	}
	public Curso obtener(int i) {
		return curso.get(i);
	}
	
	public Curso buscar(int codigo) {
		Curso x;
		for (int i = 0; i < tama�o(); i++) {
			x = obtener(i);
			if (obtener(i).getCodCurso() == codigo)
				return obtener(i);
		}
		return null;
	}
	
	//Operaciones p�blicas complementarias
	
	public int codigoCorrelativo() {
		if (tama�o() == 0)
			return 10001;
		
		else
			
		return curso.get(tama�o()-1).getCodCurso() + 1;
	}


	}  
