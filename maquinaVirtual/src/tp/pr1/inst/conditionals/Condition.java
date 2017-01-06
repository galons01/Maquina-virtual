package tp.pr1.inst.conditionals;

import tp.pr1.bitecode.jumps.ConditionalJumps;
import tp.pr1.elements.LexicalParser;
import tp.pr1.inst.assignments.Term;
import tp.pr1.inst.assignments.TermParser;

public abstract class Condition {
	private Term term1, term2;
	protected ConditionalJumps cj; //para la compilación
	
	
	public Condition parse(String t1, String op, String t2, LexicalParser parser) {
	 this.term1=TermParser.parse(t1);
	 this.term2=TermParser.parse(t2);
	 
	 return parseOp(term1, op, term2, parser);
	}
	
	protected abstract Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser);
}
