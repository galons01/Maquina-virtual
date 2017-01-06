package tp.pr1.inst.conditionals;

import tp.pr1.elements.LexicalParser;
import tp.pr1.inst.assignments.Term;

public class Equal extends Condition{
	private Term term1, term2;
	
	public Equal(){
	}
	
	public Equal(Term t1, Term t2){
		this.term1 = t1;
		this.term2 = t2;
	}
	@Override
	protected Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser) {
		if(op.equals("=")){
			return new Equal(t1, t2);
		}
		//¿para que necesito lexicalParse?
		return null;
	}
}
