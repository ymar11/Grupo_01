package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Curso;

public class ArregloCurso {
	
//  Atributo privado
	private ArrayList <Curso> cur;

	//  Constructor	
	public ArregloCurso() {
		
		cur = new ArrayList <Curso> ();
		cargarArchivo ();	
	}
	
				
		public void cargarArchivo() {
			
				//leer el archivo de texto
					try {
						
						BufferedReader br;
						String linea;
						String[] s;
						
						// para guardar los valores recuperados
						int codCurso, ciclo, creditos, horas;
						String asignatura;
						
						//cargar el archivo en memoria
						br= new BufferedReader (new FileReader("curso.txt"));
						
						while((linea=br.readLine())!=null) {
						// la variable s es el array
						
							//dividimos la cadena y lo pasamos a un arreglo
							s= linea.split(";");
							
							//recuperar los valores
							codCurso = Integer.parseInt(s[0].trim());
							ciclo    = Integer.parseInt(s[1].trim());
							creditos = Integer.parseInt(s[2].trim());
							horas    = Integer.parseInt(s[3].trim());														
							asignatura= s[4].trim();
							
							//adicionarlos al Arraylist
							adicionar (new Curso (codCurso, ciclo, creditos, horas, asignatura));
					}
						br.close();
					}
					
					catch (Exception e) {
						// TODO: handle exception
						 System.out.println("Error: cargarCursos-->: " + e.getMessage() );
					}				
						
			}
		
		public void adicionar (Curso x) {
			cur.add(x);
			grabarCursos();
		}
				
		
		void grabarCursos() {
			//leer de memoria y guardarla en un archivo txt
			
		try {
			PrintWriter pw;
			String linea;
			Curso x; //es el objeto de tipo curso	x		
			
			//instanciamos // creando el archivo
			pw= new PrintWriter( new FileWriter("curso.txt") );
		
			for (int i = 0; i < tamanio(); i++) {
				 //obtenemos la dirección memoria del objeto
				x=obtener(i);
				//pasamos los datos a una cadena
				linea=	x.getCodCurso() 	+";"+
						x.getCiclo()        +";"+
						x.getCreditos()     +";"+
						x.getHoras()		+";"+
						x.getAsignatura()   ;
				//incorporamos la línea a pw
				pw.println(linea);
				
			}
			//cerramos el pw
			pw.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
              System.out.println("Error: grabarCursos-->: " + e.getMessage() );
		}
			
	}		
		
		
		//  Operaciones públicas básicas		
		public int tamanio () {
			return cur.size();
			}

			public Curso obtener(int i) {
				return cur.get(i);
			}
		
		public Curso buscar(int codigo) {
			for (int i = 0; i < tamanio(); i++) {
				if (obtener(i).getCodCurso()==codigo) 
				return obtener(i);
				}
				return null;
				}
				
		public void eliminar(Curso x) {
			cur.remove(x); // se elimina en memoria
			actualizarArchivo();// vuelve a pasar el contenido del arraylist al archivo
					
			}

	public int codigoCorrelativo() {
		if (cur.size() == 0)
		return 101;
		else
		return obtener((tamanio()-1)).getCodCurso() + 1;
		}
	
	public void actualizarArchivo () {
		grabarCursos(); 		
	}	 
	

		}