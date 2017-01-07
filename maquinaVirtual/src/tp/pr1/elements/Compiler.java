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
		this.numVariables = 0;
		this.varTable = new String[30];
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
		catch(ArrayException e) { //esta excepcion seguramente no sea, mirar javadoc
			
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
		int i = 0;
		while(i < this.numVariables){
			if(varName.equals(this.varTable[i])) return i;
		}
		return addVariable(varName);
	}

	
	public int addVariable(java.lang.String varName){
		
		this.varTable[this.numVariables] = varName;
		int indice = this.numVariables;
		this.numVariables++;
		return indice;
	}
	
	
	public void addByteCode(ByteCode bc) throws ArrayException{
		this.bcProgram.addInstruccion(bc);
	}
	
	public int getSizeBcProgram(){
		return this.bcProgram.getContador();
	}
	
	@Override
	public java.lang.String toString(){
		return "";
	}
}
