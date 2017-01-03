package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public class Reset implements Command {

	public Reset() {
		super();
	}

	@Override
	public void execute(Engine engine) {
		engine.executeReset();
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
	public String toString(){
		return "Comienza la ejecución de reset" + System.lineSeparator();
	}

}
