package tp.pr1.inst.conditionals;

import tp.pr1.elements.Compiler;
import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.exceptions.LexicalAnalysisException;
import tp.pr1.inst.Instruction;
import tp.pr1.mv.ParsedProgram;

public class IfThen implements Instruction{
	private Condition condition;
	private ParsedProgram body;
	
	public IfThen(){
		
	}
	
	public IfThen(Condition cd, ParsedProgram pP){
		this.condition = cd;
		this.body = pP;
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words[0].equals("if")){
			Condition cond = ConditionParser.parse(words[1],words[2],words[3], lexParser);
			
			ParsedProgram wb = new ParsedProgram();
			try{
			lexParser.lexicalParser(wb,"endif");
			}catch(LexicalAnalysisException e){
				e.printStackTrace();
			};
			lexParser.increaseProgramCounter();
			return new IfThen(cond, wb);
		}
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
