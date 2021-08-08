package arreglos;

import clases.Retiro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloRetiro {
	
	private ArrayList<Retiro> ret;
	
	public ArregloRetiro() {
		ret= new ArrayList<Retiro>();
		cargarRetiros();
	}
	
	void cargarRetiros() {
		try {
			BufferedReader br;
			String linea;
			String [] s;
			
			int numRetiro, numMatricula;
			String fecha, hora;
			
			br = new BufferedReader(new FileReader("retiros.txt"));
			
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				
				numRetiro = Integer.parseInt(s[0].trim());
				numMatricula = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();			
						
				adicionar(new Retiro(numRetiro, numMatricula, fecha, hora));
				
			}
			br.close();
		}
		catch (Exception e) {
			// TODO: handle exceptionpro
			System.out.println("Error: grabarRetiros -->: " + e.getMessage());
		}
	}
	
	
	
	
	public void adicionar(Retiro x) {
		ret.add(x);
		grabarRetiros();
	} 	
	
	void grabarRetiros() {
		try {
			PrintWriter pw;
			String linea;
			Retiro x;
			//Creando el archivo
			pw = new PrintWriter(new FileWriter("retiros.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getNumRetiro() + ";" +
						x.getNumMatricula() + ";" +
						x.getFecha() + ";" +
						x.getHora();
				
				pw.println(linea);						
			}
			pw.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: grabarRetiros -->: " + e.getMessage());
		}
	}
	
	public void actualizarRetiros() {
		grabarRetiros();
	}
	
	public int tamanio() {
		return ret.size();
	}
	
	public Retiro obtener(int i) {
		return ret.get(i);
	}
	
	public void eliminar(Retiro x) {
		ret.remove(x);
		grabarRetiros();
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

