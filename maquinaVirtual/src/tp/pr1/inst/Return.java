package tp.pr1.inst;

import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;

public class Return implements Instruction{
	
	private String varName;
	
	public Return(){
		
	}
	
	public Return(String var){
		this.varName = var;
	}
	
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words.length == 2 && words[0].equals("return")){
			return new Return(words[1]);
		}
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		
	}

}
