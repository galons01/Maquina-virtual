package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public class Replace implements Command {
	private int replace;

	public Replace(int replace){
		super();
		this.replace = replace;
	}
	
	public Replace(){
		super();
		this.replace = -1;
	}

	@Override
	public void execute(Engine engine) {
		engine.executeReplace(replace);
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("REPLACE"))
			return new Replace(Integer.parseInt(s[1]));
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "REPLACE N: Reemplaza la instruccion N por la solicitada al usuario.";
	}
	public String toString(){
		return "Comienza la ejecución de replace " + System.lineSeparator();
	}

}
