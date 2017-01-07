package tp.pr1.inst.assignments;

import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.inst.Instruction;

public class SimpleAssignment implements Instruction{
	private String varName;
	private Term rhs;
	private Term var;

	public SimpleAssignment(){
	}
	
	public SimpleAssignment(String varName, Term rhs){
		this.varName = varName;
		this.rhs = rhs;
		this.var = new Variable(this.varName);
	}
	
	/**
	 * Parsea una instruccion simple.
	 * 
	 * @param words
	 * @param lexParser
	 * @return
	 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length!=3) return null;
		
		if (words[1]!="=") return null;
		
		rhs=TermParser.parse(words[2]);
		if (rhs==null) return null;
		
		var=TermParser.parse(words[0]);
		if (var==null) return null;
		
		return new SimpleAssignment(words[0], rhs);
	}

	/**
	 * Compila una instruccion simple. (primero PUSH y luego STORE)
	 * 
	 * @param compiler
	 * @throws ArrayException
	 */
	@Override
	public void compile(tp.pr1.elements.Compiler compiler) throws ArrayException {
		compiler.addByteCode(rhs.compile(compiler));
		compiler.addByteCode(var.compile(compiler));
	}

}
