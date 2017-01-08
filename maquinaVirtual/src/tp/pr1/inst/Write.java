package tp.pr1.inst;

import tp.pr1.bitecode.Out;
import tp.pr1.elements.Compiler;
import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.inst.assignments.Term;
import tp.pr1.inst.assignments.Variable;

public class Write implements Instruction{
	private String varName;
	private Term var;
	
	public Write(){
		
	}
	
	public Write(String varName){
		this.varName = varName;
		this.var = new Variable(this.varName);
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words.length == 2 && words[0].equals("write")){
			return new Write(words[1]);
		}
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(var.compile(compiler));
		compiler.addByteCode(new Out());
		
	}

}
