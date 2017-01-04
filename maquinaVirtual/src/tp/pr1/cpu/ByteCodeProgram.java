package tp.pr1.cpu;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.bitecode.ByteCodeParser;

/**
 *  Representa el programa actual. Al menos contiene métodos públicos para añadir un bytecode 
 *  al programa, inicializar el programa, colocar una instrucción bytecode en una 
 *  posición dada del programa o devolver la instrucción i-ésima del programa, 
 *  etc..
 * 
 *
 */
public class ByteCodeProgram {
	private ByteCode[] program;
	private int contador;
	private int tamaño;
	
	public ByteCodeProgram (){
		program = new ByteCode[60];				//por defecto el tamaño es 60
		contador = 0;
		this.tamaño = 60;
	}
	
	public ByteCodeProgram (int tamaño){
		this.tamaño = tamaño;
		program = new ByteCode[this.tamaño];	//el tamaño del programa puede ser personalizado
		contador = 0;
	}
	
	/** Añade una instruccion.
	 * 
	 * @param instruccion
	 * @return
	 */
	public boolean addInstruccion(ByteCode instruccion){
		boolean entraEnElPrograma = contador < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma){
			program[contador] = instruccion;
			contador ++;
		}
		return entraEnElPrograma;
	}
	
	/** Añade una instruccion y parseandola.
	 * 
	 * @param linea
	 * @return
	 */
	public boolean addInstruccion(String linea){
		boolean entraEnElPrograma = contador < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma){
			ByteCode instruccion = ByteCodeParser.parse(linea);
			program[contador] = instruccion;
			contador ++;
		}
		return entraEnElPrograma;
	}
	
	/** Añade una instruccion, parseandola y poniendola en una posicion determinada.
	 * 
	 * @param linea
	 * @param pos
	 * @return
	 */
	public boolean addInstruccion(String linea, int pos){
		boolean entraEnElPrograma = pos < this.contador;		//comprueba si existe
		if(entraEnElPrograma){
			ByteCode instruccion = ByteCodeParser.parse(linea);
			if(instruccion != null)
				program[pos] = instruccion;
			else
				entraEnElPrograma = false;
		}
		return entraEnElPrograma;
	}
	/**
	 * devuelve una bitecode solicitado.
	 * 
	 * @param pos
	 * @return
	 */
	public ByteCode devolverInstruccion(int pos){
		ByteCode instruccion = null;
		boolean entraEnElPrograma = pos < this.tamaño;		//comprueba si entra en el array
		if(entraEnElPrograma)
			instruccion = program[pos];
		return instruccion;
	}
	
	/*	for(int i = 0; i < contador; i++){
	execute(program[i]);
	System.out.println("El estado de la maquina tras ejecutar el bytecode " + program[i] + " es:");
	System.out.println(" ");
	CPU.toString();
	System.out.println();
}*/
	
	/** Borra todas las instrucciones del programa.
	 * 
	 */
	public void resetProgram(){
		for (int i=0; i<contador; i++){
			program[i] = null;
		}
		contador = 0;
	}
	
	public void mostrarPrograma(){
		for (int i=0; i<contador; i++){
			System.out.println(i + ": " + program[i].toString());
		}
	}
	
	public int getContador(){
		return this.contador;
	}

	public ByteCode getByteCode(int num){
		return program[num];
	}
}
