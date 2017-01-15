package tp.pr1.elements;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.exceptions.DivByZeroException;
//import tp.pr1.exceptions.DivByZeroException;
import tp.pr1.exceptions.ExecutionErrorException;
import tp.pr1.exceptions.StackException;
//import tp.pr1.exceptions.StackException;
import tp.pr1.mv.ByteCodeProgram;

/**
 * 
 * se encarga de realizar la ejecucion de cada bytecode y para ello
 * tiene varios metodos
 *
 */



public class CPU {
	private Memory memoria;
	private Integer variable;
	private OperandStack pila;
	//private int aux;
	private static boolean end;
	private boolean salto;
	private String resp;
	private int programCounter;
	private ByteCodeProgram bcProgram;
	
	
	public CPU(ByteCodeProgram program){
		this.pila = new OperandStack();
		this.memoria = new Memory();
		this.bcProgram = program;
		this.programCounter = 0;
		CPU.end = false;
		this.salto = false;
	}
	/**
	 * redimensiona la memoria si la n no esta en el rango 
	 * @param n
	 */
	private void redimensionaMemoria(int n){
		Memory memoriaAux;
		int tamaño = memoria.getN();
		if(n<tamaño)									
			memoriaAux = new Memory(tamaño ,memoria);
		else
			memoriaAux = new Memory(n ,memoria);			//si el tamaño es superior se amplia a dicho tamaño.
		memoria.vaciarMemoria();
		this.memoria = memoriaAux;
	}
	
	
	public void halt(){
		end = true;
	}
	/**
	 * Si la pila esta vacia devuelve true
	 * @return
	 */
	
	public boolean emptyStack(){
		if(!pila.vacia())
			return false;
		else
			return true;
	}
	/**
	 * Comprueba si el programCounter es mayor que el contador
	 * de bytecodeprogram
	 * @return
	 */
	
	public boolean Termina(){
		if(bcProgram.getContador() > programCounter+1)
			return false;
		else
			return true;
	}
	
	public String toString() {
		resp = "Estado de la CPU: " + System.lineSeparator();
		resp+=memoria.toString();
		resp+=pila.toString();
		return resp;
	}
	
	public int out(){
		return pila.intChar(pila.cima());
	}
	/**
	 *
	 * @return
	 */
	
	public int pop(){
		return pila.Load();
	}
	/**
	 * devuelve true si entra el valor i en la pila
	 * @param i
	 * @return
	 */
	
	public boolean push(int i){
		if(!pila.Store(i))					//si no entra en la pila, da error.
			return false;
		else 
			return true;
	}
	public void meterPila(int i){
		pila.Store(i);
	}
	/**
	 * Lee de la memoria el valor que esta en la posicion 
	 * param y si no es null lo instroduce en la pila
	 * @param param
	 * @return
	 */
	public boolean read(int param){
		variable = memoria.read(param);
		if(variable != null){
			pila.Store(variable.intValue());
			return true;
		}
		else
			return false;
		
	}
	/**
	 * escribe el valor value en la posicion de memoria
	 *  dado por param
	 * @param param
	 * @param value
	 */
	
	public void write(int param, int value){
		if(param>=0){
			//aux = pila.Load();
			if(!memoria.write(param, value)){				//si no entra en la memoria
				redimensionaMemoria(param);
				memoria.write(param, value);
			}
		}

	}
	public void setSalto(){
		salto = true;
	}
	
	public void next(){
		programCounter++;
		
	}
	/**
	 * cambia el programCounter cuando se ejecuta una 
	 * instruccion de salto
	 * 
	 * @param jump
	 */
	public void setProgramCounter(int jump){  //jump
		programCounter = jump;
		
	}
	public int getProgramCounter(){
		return programCounter;
	}
	public void on(){
		end = false;
	}
	
	//vacia memoria y pila
	public void finPrograma(){
		this.pila.vaciarPila();
		this.memoria.vaciarMemoria();
		//end = true;
	}
	public int getContador(){
		return this.bcProgram.getContador();
	}
	/**
	 * ejecuta instruccion por instruccion 
	 * @return
	 */
	
	public boolean run() throws ExecutionErrorException, ArrayException{
		boolean error = false;
		boolean parar = false;
		boolean ejecutar = false;
		int contador = this.bcProgram.getContador();
		for(programCounter = 0; programCounter < contador && !error && !parar; programCounter++){
			ByteCode bc = bcProgram.getByteCode(this.programCounter);
			try{
				ejecutar=bc.execute(this);}
			catch(DivByZeroException e) {
				System.out.println("El error esta en el bytecode: " + programCounter); 
				throw new ExecutionErrorException("Error: division por cero");
			}catch(StackException e){
				System.out.println("El error esta en el bytecode: " + programCounter); 
				throw new ExecutionErrorException("Excepción StackException: anomalia en el tratamiento de la pila");
			}
			if(ejecutar && !error && !end){
				if(salto == true){
					ByteCode bcs = bcProgram.getByteCode(this.programCounter);
					try {
						if(bcs.execute(this)){
							salto = false;
						}
						else{
							salto = true;
							programCounter--;
						}
					} catch (ExecutionErrorException w) {
						System.out.println("El error esta en el bytecode: " + programCounter); 
						throw new ExecutionErrorException();
					}
				}
			}
			else if(end){
				System.out.println("Maquina parada. ");
				parar = true;
			}
			else if(salto == true && ejecutar){
				parar = true;
			}
			
			else
				error = true;
		}
		System.out.println("El estado de la maquina tras ejecutar el programa es:");
		System.out.println(" ");
		System.out.println(toString());
		finPrograma();
		return error;

	}
}