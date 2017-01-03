package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public class Help implements Command{

	public Help() {
		super();
	}

	@Override
	public void execute(Engine engine) {
		engine.executeHelp();
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
