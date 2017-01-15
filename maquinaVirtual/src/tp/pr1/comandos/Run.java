package tp.pr1.comandos;

import tp.pr1.exceptions.ArrayException;
import tp.pr1.exceptions.ExecutionErrorException;
import tp.pr1.mv.Engine;

public class Run implements Command {

	public Run() {
		super();

	}

	@Override
	public void execute(Engine engine) throws ExecutionErrorException, ArrayException {
		engine.executeRun();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length==1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else 
			return null;

	}

	@Override
	public String textHelp() {
		return "RUN: Ejecuta el programa.";
	}
	
	public String toString(){
		return "Comienza la ejecución de run. " + System.lineSeparator();
	}

}
