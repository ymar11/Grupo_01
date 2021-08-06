package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Matricula;

public class ArregloMatricula {
	private ArrayList<Matricula> mat;
	public ArregloMatricula() {
	mat = new ArrayList<Matricula>();
	cargarMatricula();
	}
	
	void cargarMatricula() {
		try {
			BufferedReader br;
			String linea;
			String [] s;
			int codA,codC,NumMat,Estado;
			String fecha, hora;
			
			br = new BufferedReader(new FileReader("matricula.txt"));
			
			while ((linea=br.readLine())!=null){
			
			s = linea.split(";");
			NumMat = Integer.parseInt(s[0].trim());
			codA = Integer.parseInt(s[1].trim());
			codC = Integer.parseInt(s[2].trim());
			fecha = s[3].trim();
			hora = s[4].trim();
			Estado = Integer.parseInt(s[5].trim());
			
			adicionar(new Matricula(NumMat,codA,codC,fecha,hora,Estado));
			}
			br.close();
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: cargarMatricula-->: "+e.getMessage());
		}
		
	}
	
	public void adicionar(Matricula x) {
		mat.add(x);
		grabarMatricula();
	}
	
	void grabarMatricula() {
		try {
			PrintWriter pw;
			String linea;
			Matricula x;
			pw = new PrintWriter(new FileWriter("matricula.txt"));
			
			for (int i = 0; i < tamaño(); i++) {
				x=obtener(i);
				linea = x.getNumMatricula() +";"+
				        x.getCodAlumno() +";"+
						x.getCodCurso() +";"+
				        x.getFecha() +";"+
						x.getHora() +";"+
				        x.getEstado();
				
				pw.println(linea);
						
				
			}
			pw.close();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: grabarMatricula-->: "+ e.getMessage());
		}
	}
	
	public int tamaño() {
		return mat.size();
	}
	public Matricula obtener(int i) {
		return mat.get(i);
		
	}
	
	public void eliminar(Matricula x) {
		   mat.remove(x);
		   actualizarMatricula();
	   }
	  public Matricula buscar(int codigo) {
		   for (int i = 0; i < tamaño(); i++) {
			if (obtener(i).getCodAlumno()==codigo) {
				return obtener(i);
			}
			 
		}
		   return null;
	   }
	  
	  public int codigoCorrelativo() {
		  if (tamaño() == 0) {
		  return 10001;
	  }else
		  return obtener(tamaño()-1).getNumMatricula() + 1;
		  }
	  
	  public void actualizarMatricula() {
		  grabarMatricula();
	  }
	  
}