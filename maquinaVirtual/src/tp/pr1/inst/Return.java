package tp.pr1.inst;

import tp.pr1.bitecode.Halt;
import tp.pr1.elements.Compiler;
import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;

public class Return implements Instruction{
	
	
	public Return(){
		
	}
	
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words.length == 1 && words[0].equals("return")){
			return new Return();
		}
		return null;
	}

	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
		
	}

}
