package arreglos;

import java.util.ArrayList;

import clases.Matricula;

public class ArregloMatricula {
	private ArrayList<Matricula> mat;
	public ArregloMatricula() {
	mat = new ArrayList<Matricula>();
	}
	
	public void adicionar(Matricula x) {
		mat.add(x);
	}
	public int tamaño() {
		return mat.size();
	}
	public Matricula obtener(int i) {
		return mat.get(i);
		
	}
	
	public void eliminar(Matricula x) {
		   mat.remove(x);
	   }
	  public Matricula buscar(int codigo) {
		   for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodAlumno()==codigo) {
				return obtener(i);
			}
			 
		}
		   return null;
	   }
	   
	

}
