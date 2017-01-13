package tp.pr1.inst.conditionals;

import tp.pr1.bitecode.jumps.ConditionalJumps;
import tp.pr1.bitecode.jumps.IfLe;
import tp.pr1.elements.LexicalParser;
import tp.pr1.inst.assignments.Term;

public class Less extends Condition{
	
	public Less(){
	}
	
	public Less(Term t1, Term t2){
		super(t1, t2);
	}
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if(op.equals("<")){
			lexParser.increaseProgramCounter();
			return new Less(t1, t2);
		}
		return null;
	}

	@Override
	protected ConditionalJumps compileOp() {
		return new IfLe(0);
	}

}
