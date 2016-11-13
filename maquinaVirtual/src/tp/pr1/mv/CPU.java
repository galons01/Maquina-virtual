package tp.pr1.mv;



public class CPU {
	private Memory memoria;
	private Integer variable;
	private OperandStack pila;
	private int aux, aux2;
	private static boolean end;
	private String resp;
	
	public CPU(){
		pila = new OperandStack();
		memoria = new Memory();
	}
	
/*	private void redimensionaPila(){
		OperandStack pilaAux;
		pilaAux = new OperandStack(pila.getContador()*2);
		pilaAux = pila;
	}*/
	
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
					pila.intChar(pila.cima());
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
			
			else if(pila.getContador()>0){						// intrucciones que necesitan al menos una variable en pila
				
				if (instruccion == ENUM_BYTECODE.STORE){
						if(n>=0){
							aux = pila.Load();
							if(!memoria.write(n, aux)){				//si no entra en la memoria
								redimensionaMemoria(n);
								memoria.write(n, aux);
							}
						}
				}
				
				else if(pila.getContador()>1){					// intrucciones que necesitan al menos dos variables en pila
					
					if (instruccion == ENUM_BYTECODE.ADD){
						aux = pila.Load() + pila.Load();
						pila.Store(aux);
					}
					
					else if (instruccion == ENUM_BYTECODE.SUB){
						aux = -pila.Load() + pila.Load();	
						pila.Store(aux);
					}
					
					else if (instruccion == ENUM_BYTECODE.MUL){
						aux = pila.Load() * pila.Load();
						pila.Store(aux);
					}
					
					else if (instruccion == ENUM_BYTECODE.DIV){
						aux = pila.Load();
						aux2 = pila.Load();
						if(aux != 0)
							pila.Store(aux2/aux);
						else
							ejecucionCorrecta = false;
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
}
