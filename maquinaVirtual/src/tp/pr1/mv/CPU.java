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
	
	public boolean execute(ByteCode instr){
		boolean ejecucionCorrecta = true;
		ENUM_BYTECODE instruccion=instr.getName();
		int n = instr.getParam();
		if(!end){
			if(instruccion == ENUM_BYTECODE.PUSH){
				pila.Store(n);
			}
			
			else if (instruccion == ENUM_BYTECODE.LOAD){
				variable = memoria.read(n);
				if(variable != null)
					pila.Store(variable.intValue());
				else
					ejecucionCorrecta = false;
			}
			
			else if (instruccion == ENUM_BYTECODE.STORE){
				memoria.write(n, pila.Load());
			}
			
			else if (instruccion == ENUM_BYTECODE.ADD){
				if(pila.getContador()>1){
					aux = pila.Load() + pila.Load();
					pila.Store(aux);
				}
				else
					ejecucionCorrecta = false;
			}
			
			else if (instruccion == ENUM_BYTECODE.SUB){
				aux = -pila.Load() + pila.Load();	//revisar
				pila.Store(aux);
			}
			
			else if (instruccion == ENUM_BYTECODE.MUL){
				aux = pila.Load() * pila.Load();
				pila.Store(aux);	
			}
			
			else if (instruccion == ENUM_BYTECODE.DIV){
				aux = pila.Load();
				aux2 = pila.Load();
				pila.Store(aux2/aux);
			}
			
			else if (instruccion == ENUM_BYTECODE.OUT){
				
			}
			
			else if (instruccion == ENUM_BYTECODE.HALT){
				end = true;
			}
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
