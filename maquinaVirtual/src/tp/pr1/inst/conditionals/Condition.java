package tp.pr1.inst.conditionals;

import tp.pr1.bitecode.jumps.ConditionalJumps;
import tp.pr1.elements.Compiler;
import tp.pr1.elements.LexicalParser;
import tp.pr1.inst.assignments.Term;
import tp.pr1.inst.assignments.TermParser;

public abstract class Condition {
	private Term term1, term2;
	protected ConditionalJumps cj; //para la compilación
	
	public Condition(){
		
	}
	
	public Condition(Term t1, Term t2){
		this.term1 = t1;
		this.term2 = t2;
	}
	
	public Condition parse(String t1, String op, String t2, LexicalParser parser) {
		this.term1=TermParser.parse(t1);
		this.term2=TermParser.parse(t2);
		 
		if(term1==null || term2==null) return null;
		 
		return parseOp(term1, op, term2, parser);
	}
	
	protected abstract Condition parseOp(Term t1, String op, Term t2, LexicalParser lexParser);
	
	
	protected abstract ConditionalJumps compileOp();

	public void compile(Compiler compiler) {
		this.cj = compileOp();
	}

}
