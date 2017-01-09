package tp.pr1.inst.conditionals;

import tp.pr1.bitecode.jumps.ConditionalJumps;
import tp.pr1.elements.LexicalParser;
import tp.pr1.inst.assignments.Term;

public class LessEq extends Condition{
	private Term term1, term2;
	
	public LessEq(){
	}
	
	public LessEq(Term t1, Term t2){
		this.term1 = t1;
		this.term2 = t2;
	}
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if(op.equals("<=")){
			lexParser.increaseProgramCounter();
			return new LessEq(t1, t2);
		}
		return null;
	}

	@Override
	protected ConditionalJumps compileOp() {
		// TODO Auto-generated method stub
		return null;
	}
}
