package tp.pr1.cpu;

import tp.pr1.bitecode.ByteCode;



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
	
	
	/*public boolean execute(ByteCode instr){
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
			
				/*	if (instruccion == ENUM_BYTECODE.ADD){
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
	}*/
	/*public boolean añadirInstruccion(ByteCode bc, int pos){
		
	}*/
	public void halt(){
		end = true;
	}
	
	public boolean emptyStack(){
		if(!pila.vacia())
			return false;
		else
			return true;
	}
	
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
	
	public int pop(){
		return pila.Load();
	}
	
	public boolean push(int i){
		if(!pila.Store(i))					//si no entra en la pila, da error.
			return false;
		else 
			return true;
	}
	public void meterPila(int i){
		pila.Store(i);
	}
	
	public boolean read(int param){
		variable = memoria.read(param);
		if(variable != null){
			pila.Store(variable.intValue());
			return true;
		}
		else
			return false;
		
	}
	
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
	public boolean añadeInstruccion(ByteCode bc, int pos){
		return false;
		
	}
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
	
	
	public boolean run(){
		boolean error = false;
		boolean parar = false;
		//boolean salto = false;
		int contador = this.bcProgram.getContador();
		for(programCounter = 0; programCounter < contador && !error && !parar; programCounter++){
			ByteCode bc = bcProgram.getByteCode(this.programCounter);
			if(bc.execute(this) && !error && !end){
				if(salto == true){
					ByteCode bcs = bcProgram.getByteCode(this.programCounter);
					if(bcs.execute(this)){
						System.out.println("El estado de la maquina tras ejecutar el bytecode " + bcProgram.devolverInstruccion(programCounter) + " es:");
						System.out.println(" ");
						System.out.println(toString());
						System.out.println();
						salto = false;
					}
					else
						error = true;
				}
				else{
					System.out.println("El estado de la maquina tras ejecutar el bytecode " + bcProgram.devolverInstruccion(programCounter) + " es:");
					System.out.println(" ");
					System.out.println(toString());
					System.out.println();
				}
			}
			else if(end){
				System.out.println("Maquina parada. ");
				parar = true;
			}
			else
				error = true;
		}
		finPrograma();
		return error;
	}
}