package tp.pr1.mv;



public class CPU {
	Memory memoria;
	Integer variable;
	OperandStack pila;
	ENUM_BYTECODE enumerado;
	int paramIntr, aux, aux2;
	boolean end;
	
	public boolean execute(ByteCode instr){
		if(end){
			if(instr.getName() == ENUM_BYTECODE.PUSH){
				this.paramIntr = instr.getParam();
				this.pila.Store(paramIntr);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.LOAD){
				this.paramIntr = instr.getParam();
				this.variable = this.memoria.read(paramIntr);
				this.pila.Store(this.variable.intValue()); 			//revisar
			}
			
			else if (instr.getName() == ENUM_BYTECODE.STORE){
				this.paramIntr = instr.getParam();
				this.memoria.write(this.paramIntr, this.pila.Load());
			}
			
			else if (instr.getName() == ENUM_BYTECODE.ADD){
				this.aux = this.pila.Load() + this.pila.Load();
				this.pila.Store(this.aux);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.SUB){
				this.aux = -this.pila.Load() + this.pila.Load();	//revisar
				this.pila.Store(this.aux);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.MUL){
				this.aux = this.pila.Load() * this.pila.Load();
				this.pila.Store(this.aux);	
			}
			
			else if (instr.getName() == ENUM_BYTECODE.DIV){
				this.aux = this.pila.Load();
				this.aux2 = this.pila.Load();
				this.pila.Store(this.aux2/this.aux);
			}
			
			else if (instr.getName() == ENUM_BYTECODE.OUT){
				
			}
			
			else if (instr.getName() == ENUM_BYTECODE.HALT){
				this.end = true;
			}
		}
		return end;	
	}
	
	public void on(){
		this.end = false;
	}
}
