package tp.pr1.inst;

import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;

public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexParser);
	void compile(tp.pr1.elements.Compiler compiler) throws ArrayException;
}
