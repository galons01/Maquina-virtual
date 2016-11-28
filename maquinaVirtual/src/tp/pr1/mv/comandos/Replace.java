package tp.pr1.mv.comandos;

import tp.pr1.mv.ENUM_COMMAND;
import tp.pr1.mv.Engine;

public class Replace extends Command {
	private int replace;

	public Replace(int replace){
		super(ENUM_COMMAND.REPLACE);
		this.replace = replace;
	}
	
	public Replace(){
		super(ENUM_COMMAND.REPLACE);
		this.replace = -1;
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.executeReplace(replace);
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

}
