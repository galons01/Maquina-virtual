package tp.pr1.inst;

import tp.pr1.elements.LexicalParser;

public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexParser);
	void compile(Compiler compiler) throws ArrayException;
}
