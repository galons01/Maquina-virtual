package tp.pr1.elements;

import tp.pr1.inst.Instruction;
import tp.pr1.mv.ByteCodeProgram;
import tp.pr1.mv.ParsedProgram;

public class Compiler {
	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVariables;
	
	public void compile(ParsedProgram pProgram) throws {
	int i=0;
	while (i<pProgram.getSize())
	{
		Instruction inst=pProgram.getInstr(i);
		inst.compile(this);
		i++;
	}
	}
}
