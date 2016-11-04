package tp.pr1.mv;



public class CPU {
	static Memory memoria;
	static Integer variable;
	static OperandStack pila;
	static int paramIntr, aux, aux2;
	static boolean end;
	
	public CPU(){
		pila = new OperandStack();
		memoria = new Memory();
	}
	
	public static boolean execute(ByteCode instr){
		if(end){
			if(instr.getName() == ENUM_BYTECODE.PUSH){
				paramIntr = instr.getParam();
				pila.Store(paramIntr);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.LOAD){
				paramIntr = instr.getParam();
				variable = memoria.read(paramIntr);
				pila.Store(variable.intValue()); 			//revisar
			}
			
			else if (instr.getName() == ENUM_BYTECODE.STORE){
				paramIntr = instr.getParam();
				memoria.write(paramIntr, pila.Load());
			}
			
			else if (instr.getName() == ENUM_BYTECODE.ADD){
				aux = pila.Load() + pila.Load();
				pila.Store(aux);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.SUB){
				aux = -pila.Load() + pila.Load();	//revisar
				pila.Store(aux);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.MUL){
				aux = pila.Load() * pila.Load();
				pila.Store(aux);	
			}
			
			else if (instr.getName() == ENUM_BYTECODE.DIV){
				aux = pila.Load();
				aux2 = pila.Load();
				pila.Store(aux2/aux);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.OUT){
				
			}
			
			else if (instr.getName() == ENUM_BYTECODE.HALT){
				end = true;
			}
		}
		return end;	
	}
	
	public void on(){
		CPU.end = false;
	}
}
