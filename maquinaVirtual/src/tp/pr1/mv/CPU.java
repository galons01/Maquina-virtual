package tp.pr1.mv;

import tp.pr1.mv.bitecode.ByteCode;
import tp.pr1.mv.bitecode.ByteCodeProgram;
import tp.pr1.mv.bitecode.ENUM_BYTECODE;



public class CPU {
	private Memory memoria;
	private Integer variable;
	private OperandStack pila;
	private int aux;
	private static boolean end;
	private String resp;
	private int programCounter;
	private ByteCodeProgram bcProgram;
	
	public CPU(ByteCodeProgram program){
		pila = new OperandStack();
		memoria = new Memory();
		bcProgram = program;
		programCounter = 0;
	}
	
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
	
	public boolean execute(ByteCode instr){
		boolean ejecucionCorrecta = true;
		ENUM_BYTECODE instruccion=instr.getName();
		int n = instr.getParam();
		if(!end){
			
			// intrucciones que no necesitan al menos una variable en pila
			
			if(instruccion == ENUM_BYTECODE.PUSH){
				if(!pila.Store(n)){						//si no entra en la pila, da error.
					ejecucionCorrecta = false;
				}
			}
			
			else if (instruccion == ENUM_BYTECODE.OUT){ //No se como sacarlo por pantalla al hacer el run
				if(!pila.vacia()){
					System.out.println("caracter de la cima: " + pila.intChar(pila.cima()));
					System.out.println();
				}
				else
					ejecucionCorrecta = false;
			}
			
			else if (instruccion == ENUM_BYTECODE.HALT){
				end = true;
			}
			
			else if (instruccion == ENUM_BYTECODE.LOAD){
				variable = memoria.read(n);
				if(variable != null)
					pila.Store(variable.intValue());
				else
					ejecucionCorrecta = false;
			}
			
			else if(!pila.vacia()){						// intrucciones que necesitan al menos una variable en pila
				
				if (instruccion == ENUM_BYTECODE.STORE){
						if(n>=0){
							aux = pila.Load();
							if(!memoria.write(n, aux)){				//si no entra en la memoria
								redimensionaMemoria(n);
								memoria.write(n, aux);
							}
						}
				}
				
				else if(!pila.vacia()){					/*pila.getContador()>1*/// intrucciones que necesitan al menos dos variables en pila
					
					if (instruccion == ENUM_BYTECODE.ADD){
						aux = pila.Load();
						if(!pila.vacia()){
							aux = aux + pila.Load();
							pila.Store(aux);
						}
						else{
							pila.Store(aux);
							ejecucionCorrecta = false;
						}
					}
					
					else if (instruccion == ENUM_BYTECODE.SUB){
						aux = - pila.Load();
						if(!pila.vacia()){
							aux = aux + pila.Load();
							pila.Store(aux);
						}
						else{
							pila.Store( - aux);
							ejecucionCorrecta = false;
						}
					}
					
					else if (instruccion == ENUM_BYTECODE.MUL){
						aux = pila.Load();
						if(!pila.vacia()){
							aux = aux * pila.Load();
							pila.Store(aux);
						}
						else{
							pila.Store(aux);
							ejecucionCorrecta = false;
						}
					}
					
					else if (instruccion == ENUM_BYTECODE.DIV){
						aux = pila.Load();
						if(!pila.vacia()){
							aux = pila.Load() / aux;
							pila.Store(aux);
						}
						else{
							pila.Store(aux);
							ejecucionCorrecta = false;
						}
					}
				}
				else
					ejecucionCorrecta = false;
			}
			else
				ejecucionCorrecta = false;
		}
		return ejecucionCorrecta;	
	}
	
	public String toString() {
		resp = "Estado de la CPU: " + System.lineSeparator();
		resp+=memoria.toString();
		resp+=pila.toString();
		return resp;
	}
	
	public void on(){
		CPU.end = false;
	}
	
	//vacia memoria y pila
	public void finPrograma(){
		this.pila.vaciarPila();
		this.memoria.vaciarMemoria();
	}
	
	public boolean run(){
		boolean error = false;
		int contador = this.bcProgram.getContador();
		for(programCounter = 0; programCounter < contador && !error; programCounter++){
			if(execute(bcProgram.devolverInstruccion(programCounter)) && !error){
				System.out.println("El estado de la maquina tras ejecutar el bytecode " + bcProgram.devolverInstruccion(programCounter) + " es:");
				System.out.println(" ");
				System.out.println(toString());
				System.out.println();
			}
			else
				error = true;
		}
		finPrograma();
		return error;
	}
}
