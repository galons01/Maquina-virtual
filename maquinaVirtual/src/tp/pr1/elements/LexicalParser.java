package tp.pr1.elements;

import tp.pr1.exceptions.LexicalAnalysisException;
import tp.pr1.inst.Instruction;
import tp.pr1.inst.InstructionParser;
import tp.pr1.mv.ParsedProgram;
import tp.pr1.mv.SourceProgram;

public class LexicalParser {
	private SourceProgram sProgram;
	private int programCounter;
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws LexicalAnalysisException{
		boolean stop = false;
		
		while (programCounter < sProgram.getSize() && !stop) {
				
			String line = sProgram.getInstr(programCounter);
			
			if (line.equalsIgnoreCase(stopKey)) stop = true;
			else {
				Instruction instruction = InstructionParser.parse(line,this);
				//Si instruction no es null
				
				pProgram.addInstr(instruction);
				//Aumentar programCounter
			}
		}
	}
	
	public void initialize(SourceProgram sProgram){
		this.sProgram = sProgram;
	}

	public void increaseProgramCounter() {
		this.programCounter++;
	}
}
