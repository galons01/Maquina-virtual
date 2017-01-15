package tp.pr1.inst.conditionals;

import tp.pr1.bitecode.jumps.ConditionalJumps;
import tp.pr1.bitecode.jumps.Goto;
import tp.pr1.elements.Compiler;
import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.exceptions.LexicalAnalysisException;
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
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws ArrayException {
		if(words[0].equals("while")){
			Condition cond = ConditionParser.parse(words[1],words[2],words[3], lexParser);
			
			/*if (words.length!=3) return null;
			
			if (words[1]!="=") return null;
			Term rhs=TermParser.parse(words[2]);
			if (rhs==null) return null;*/
			
			ParsedProgram wb = new ParsedProgram();
			try {
				lexParser.lexicalParser(wb,"ENDWHILE");
				return new While(cond, wb);
			} catch (LexicalAnalysisException e) {
				System.out.println("Excepcion: programa fuente incorrecto");
			}
//			lexParser.increaseProgramCounter();
			//return new While(cond, wb);
		}
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		try{
			int origen = compiler.getSizeBcProgram();
			this.condition.compile(compiler);
			compiler.compile(this.body);
			ConditionalJumps cj = this.condition.cj;
			int n = compiler.getSizeBcProgram();
			cj.setN(n+1);
	//		ByteCodeProgram bcProgram = new ByteCodeProgram();//revisar
			compiler.addByteCode(new Goto(origen));
		}catch(ArrayException e){
			throw new ArrayException();
		}
		
	}

}
