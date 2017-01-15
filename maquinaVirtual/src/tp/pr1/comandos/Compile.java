package tp.pr1.comandos;

import tp.pr1.exceptions.ArrayException;
import tp.pr1.exceptions.LexicalAnalysisException;
import tp.pr1.mv.Engine;

public class Compile implements Command{

	public Compile(){
		
	}
	
	@Override
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException {
			engine.executeCompile();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "COMPILE: Compila el programa.";
	}

	public String toString(){
		return "Comienza la ejecución de COMPILE " + System.lineSeparator();
	}
}
