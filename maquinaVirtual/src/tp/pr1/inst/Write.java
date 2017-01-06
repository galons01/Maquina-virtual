package tp.pr1.inst;

import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;

public class Write implements Instruction{
	String var;
	
	
	public Write(){
		
	}
	
	public Write(String var){
		this.var = var;
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words.length == 2 && words[0].equals("write")){
			return new Write(words[1]);
		}
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
