package tp.pr1.mv.comandos;

import tp.pr1.mv.ENUM_COMMAND;
import tp.pr1.mv.Engine;

public class Run extends Command {

	public Run() {
		super(ENUM_COMMAND.RUN);

	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeRun();
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

}
