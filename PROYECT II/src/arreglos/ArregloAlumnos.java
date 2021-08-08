package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Alumno;


	
	public class ArregloAlumnos {
		 //commit
			//atributo privado, array de tipo alumno
			private ArrayList<Alumno>alu;
			
			//creando constructor
			public ArregloAlumnos() {	
			// creamos el array e instanciarlo  
			alu = new ArrayList <Alumno> ();
			
			//cargar los  alumnos del archivo Txt al Jtable
			cargarAlumnos ();
			}
			
			void cargarAlumnos () {
				//leer el archivos de texto  , pasar de archivos a la memoria		
				try {
					BufferedReader br;
					String linea;
					String [] s; // arreglo llamado S
					
					// para guardar los valores recuperados 
					int codAlumno, edad, celular, estado;
					String nombres,apellidos  ;
					int dni;
					
					
					// cargar el archivo en memoria modo lectura 
					br = new BufferedReader(new FileReader("alumnos.txt"));			
					
		            while ( (linea=br.readLine()) != null) {
						//dividimos la cadena y lo pasamos a un arreglo
						s = linea.split(";") ;
						
					 //recuperamos los valores
						codAlumno = Integer.parseInt(s[0].trim () ) ;
						nombres = s [1].trim();
						apellidos = s [2].trim();
						dni     =  Integer.parseInt (s [3].trim());
						edad    = Integer.parseInt(s [4].trim ());
						celular = Integer.parseInt(s [5].trim ());
						estado  = Integer.parseInt(s[6].trim()); 	
						
						// adicionarlos al arrayList
						adicionar (new Alumno (codAlumno, nombres, apellidos,dni, edad, celular, estado) );
					}			
		            br.close();
				}
				
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error: cargarAlumnos-->: "+ e.getMessage() );
				}		
			}
			
			public void adicionar (Alumno x) {
				alu.add (x); // incorporando en memoria 
				grabarAlumnos(); // lleva de memoria al archivo de texto 
				
			}
				
				//metodo void
			void grabarAlumnos () {
			 // leer de memoria y guardarlo en un archivo Txt
			 	    try {
						 PrintWriter pw; //
						 String linea;   //
						 Alumno x;       //
						 //creando el archivo
						 pw= new PrintWriter(new FileWriter("alumnos.txt"));
						 
						 for (int i = 0; i < tamanio (); i++) {
							 x = obtener (i); // obtenemos dir Memoria objeto
							 // pasamos los datos a una cadena
							 linea = x.getCodAlumno()   + ";" +
									 x.getNombres()  	+ ";" +
									 x.getApellidos()   + ";" +
									 x.getDni()         + ";" +
									 x.getEdad()        + ";" +
									 x.getCelular()     + ";" +
									 x.getEstado()  ;  

							 //incorporamos la linea a pw y hace un salto de linea
							 pw.println(linea);
						}
						 //cerramos el pw
						 pw.close();	
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println("Error: grabarAlumnos-->: "+ e.getMessage() );
					}			 
				 }
				 
			public int tamanio () {
				return alu.size ();
			}	 
				 
			// obtiene del tipo alumno, recibe una Pos y retorna un objeto
			public Alumno obtener (int i) {
				return alu.get (i); 
			}
			
			//recorro cada casillero y obtengo el objeto, pregunto por el cod y evaluo
			public Alumno buscar (int codigo) {
				for (int i = 0; i < tamanio (); i++) {
					if (obtener(i).getCodAlumno()==codigo)
						return obtener (i);	 // retorna el objeto		
				}
				return null;
			}
				 
				
			public void eliminar (Alumno x) {
				alu.remove(x); // se elimna de memoria 
				actualizarArchivo(); //vuelve a pasar el contenido del array alarchivo Txt 		
			}
			
			 public int codigoCorrelativo() {
				  if (tamanio() == 0) {
				  return 202010001 ;
			  }else
				  return obtener(tamanio()-1).getCodAlumno() + 1;
				  }
			
			public void actualizarArchivo () {
				grabarAlumnos(); 		
			}	 
			
			
				  
}
