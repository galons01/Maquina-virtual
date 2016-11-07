package tp.pr1.mv;



public class CPU {
	private Memory memoria;
	private Integer variable;
	private OperandStack pila;
	private int aux, aux2;
	private static boolean end;
	private static String resp;
	
	public CPU(){
		pila = new OperandStack();
		memoria = new Memory();
	}
	
	public boolean execute(ByteCode instr){
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
					return false;
			}
			
			else if (instruccion == ENUM_BYTECODE.STORE){
				memoria.write(n, pila.Load());
			}
			
			else if (instruccion == ENUM_BYTECODE.ADD){
				aux = pila.Load() + pila.Load();
				pila.Store(aux);
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
		return end;	
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
}
