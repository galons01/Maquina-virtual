package tp.pr1.inst.assignments;

import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.inst.Instruction;

public class SimpleAssignment implements Instruction{
	private String varName;
	private Term rhs;

	public SimpleAssignment(String varName, Term rhs){
		this.varName = varName;
		this.rhs = rhs;
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length!=3) return null;
		
		if (words[1]!="=") return null;
		Term rhs=TermParser.parse(words[2]);
		if (rhs==null) return null;
		
		return new SimpleAssignment(varName, rhs);
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
