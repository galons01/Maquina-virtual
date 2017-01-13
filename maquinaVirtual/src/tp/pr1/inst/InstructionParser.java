package tp.pr1.inst;

import tp.pr1.elements.LexicalParser;
import tp.pr1.inst.assignments.CompoundAssignment;
import tp.pr1.inst.assignments.SimpleAssignment;
import tp.pr1.inst.conditionals.IfThen;
import tp.pr1.inst.conditionals.While;

public class InstructionParser{
	private final static Instruction[] instructions={
			 new SimpleAssignment(), 
			 new CompoundAssignment(),
			 new Write(), 
			 new Return(), 
			 new While(), 
			 new IfThen()};

	public static Instruction parse(String line, LexicalParser lexicalParser) {
		String[] words = line.split(" ");
		for(int i=0; i<instructions.length; i++){
			Instruction isntruccion = instructions[i].lexParse(words, lexicalParser);
			if(isntruccion!=null){
				return isntruccion;
			}
		}
		return null;
	}		
}
