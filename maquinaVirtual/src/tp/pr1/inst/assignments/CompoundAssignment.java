package tp.pr1.inst.assignments;

import tp.pr1.bitecode.arithmetics.Add;
import tp.pr1.bitecode.arithmetics.Div;
import tp.pr1.bitecode.arithmetics.Mul;
import tp.pr1.bitecode.arithmetics.Sub;
import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.inst.Instruction;

public class CompoundAssignment implements Instruction{

	private String varName;
	private String operator;
	private Term term1, term2;
	
	public CompoundAssignment(){
		
	}
	
	public CompoundAssignment(String varName, String operator, Term t1, Term t2){
		this.varName = varName;
		this.operator = operator;
		this.term1 = t1;
		this.term2 = t2;
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length!=4) return null;
		
		if (words[1]!="=") return null;
		Term rhs1=TermParser.parse(words[2]);
		Term rhs2=TermParser.parse(words[4]);
		if (rhs1==null || rhs2==null) return null;
		
		return new CompoundAssignment(words[0], words[3], rhs1, rhs2);
	}

	@Override
	public void compile(tp.pr1.elements.Compiler compiler) throws ArrayException {
		compiler.addByteCode(term1.compile(compiler));
		compiler.addByteCode(term2.compile(compiler));
		if(this.operator.equals("+"))
			compiler.addByteCode(new Add());
		else if(this.operator.equals("-"))
			compiler.addByteCode(new Sub());
		else if(this.operator.equals("*"))
			compiler.addByteCode(new Mul());
		else
			compiler.addByteCode(new Div());
	}
	
	public String toString(){
		return null;
	}

	

}
