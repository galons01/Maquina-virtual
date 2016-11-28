package tp.pr1.mv.comandos;

import tp.pr1.mv.ENUM_COMMAND;
import tp.pr1.mv.Engine;

public class Help extends Command{

	public Help() {
		super(ENUM_COMMAND.HELP);
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeHelp();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length==1 && s[0].equalsIgnoreCase("HELP") )
			return new Help();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "HELP: Muestra esta ayuda.";
	}

}
