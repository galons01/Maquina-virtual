package tp.pr1.mv.comandos;

import tp.pr1.mv.Engine;

public class Reset extends Command {

	public Reset() {
		super(ENUM_COMMAND.RESET);
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReset();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length==1 && s[0].equalsIgnoreCase("RESET"))
			return new Reset();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "RESET: Vacia el programa actual.";
	}

}
