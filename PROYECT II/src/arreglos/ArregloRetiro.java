package arreglos;

import clases.Retiro;
import java.util.ArrayList;

public class ArregloRetiro {
	
	private ArrayList<Retiro> ret;
	
	public ArregloRetiro() {
		ret= new ArrayList<Retiro>();
	}
	
	public void adicionar(Retiro x) {
		ret.add(x);		
	} 	
	
	public int tamanio() {
		return ret.size();
	}
	
	public Retiro obtener(int i) {
		return ret.get(i);
	}
	
	public void eliminar(Retiro x) {
		ret.remove(x);
	}
	
	public Retiro buscar (int codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getNumMatricula() == codigo)
				return obtener(i);
		}
		return null;
	}
	
	public int codigoCorrelativoNumRetiro() {
		if (tamanio() == 0)
			return 200001;
		else
			return obtener(tamanio()-1).getNumRetiro() + 1;
	}
}

