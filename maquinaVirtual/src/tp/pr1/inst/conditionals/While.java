package tp.pr1.inst.conditionals;

import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.inst.Instruction;
import tp.pr1.mv.ParsedProgram;

public class While implements Instruction{
	private Condition condition;
	private ParsedProgram body;
	
	public While(){
	}
	
	public While(Condition cd, ParsedProgram pP){
		this.condition = cd;
		this.body = pP;
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		ParsedProgram wb = new ParsedProgram();
		lexParser.lexicalParser(wb,"ENDWHILE");
		lexParser.increaseProgramCounter();
		return new While(cond, wb);
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		
	}

}
