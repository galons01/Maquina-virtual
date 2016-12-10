package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public class Quit extends Command {

	public Quit() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeQuit();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length==1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "QUIT: Cierra la aplicacion.";
	}
	public String toString(){
		return "Comienza la ejecuci�n de quit " + System.lineSeparator();
	}
	

}