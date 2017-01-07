package tp.pr1.elements;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.inst.Instruction;
import tp.pr1.mv.ByteCodeProgram;
import tp.pr1.mv.ParsedProgram;

public class Compiler {
	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVariables;
	
	public Compiler(){
		
	}
	
	public void compile(ParsedProgram pProgram) throws ArrayException{
		int i=0;
		try {
			while (i<pProgram.getSize())
			{
				Instruction inst=pProgram.getInstr(i);
				inst.compile(this);
				i++;
			}
		}
		catch(ArrayException e) { //esta excepcion puede q no sea
			
		}
	}
	
	public void initialize(ByteCodeProgram bcProgram){
		this.bcProgram=bcProgram;
	}
	
	/**
	 * Este método devuelve el índice de la variable varName en la tabla de variables, con el efecto colateral de que si no está, añade la variable a la tabla.
	 * 
	 * @param varName
	 * @return
	 */
	public int indexOf(java.lang.String varName){
		return null;
	}
	
	public void addByteCode(ByteCode bc) throws ArrayException{
		
	}
	
	public int addVariable(java.lang.String varName){
		
	}
	
	@Override
	public java.lang.String toString(){
		return "";
	}
	
	public int getSizeBcProgram(){
		
	}
}
