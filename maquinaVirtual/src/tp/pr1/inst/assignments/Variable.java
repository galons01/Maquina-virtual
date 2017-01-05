package tp.pr1.inst.assignments;

import tp.pr1.bitecode.ByteCode;

public class Variable implements Term{
	
	private String varName;
	
	public Variable(String varName) {
		this.varName = varName;
	}

	@Override
	public Term parse(String term) {
		if (term.length()!=1) 
			return null;
		else {
			char name = term.charAt(0);
			if ('a'<=name && name<='z')
				return new Variable(term);
			else return null;
		 }
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		// TODO Auto-generated method stub
		return null;
	}

}
