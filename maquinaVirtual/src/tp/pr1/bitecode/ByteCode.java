package tp.pr1.bitecode;

import cpu.CPU;

public abstract class ByteCode {
	//private int param;
	//private ENUM_BYTECODE name;
	
	public ByteCode(){
	}
	
	public abstract boolean execute(CPU cpu);
	
	public abstract ByteCode parse(String[]s);
	
	/*public ByteCode(ENUM_BYTECODE name){
		this.name=name;
		this.param = -1;
	}*/
	
	/*public ENUM_BYTECODE getName(){
		return this.name;
	}*/
	/*
	public int getParam(){
		return this.param;
	}
	public String toString(){
		String resultado;
		if(this.param != -1)
			resultado = name + " " + param;
		else 
			resultado = name + " ";
		return resultado;
	}
	*/
}
