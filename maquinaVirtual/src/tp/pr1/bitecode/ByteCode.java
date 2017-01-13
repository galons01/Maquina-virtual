package tp.pr1.bitecode;

import tp.pr1.elements.CPU;
import tp.pr1.exceptions.DivByZeroException;
import tp.pr1.exceptions.StackException;

public abstract class ByteCode {
	//private int param;
	//private ENUM_BYTECODE name;
	
	public ByteCode(){
	}
	/**
	 * Ejecuta la parte com�n de la ejecuci�n de los bytecodes de salto, 
	 * es decir, extrae la cima y la subcima de la pila de operandos. 
	 * La operaci�n concreta la lleva a cabo el m�todo abstracto compares()
	 * 
	 * @param cpu
	 * @return
	 * @throws StackException 
	 * @throws DivByZeroException 
	 */
	public abstract boolean execute(CPU cpu) throws DivByZeroException, StackException;
	
	/**
	 * 
	 * @param s
	 * @return
	 */
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
