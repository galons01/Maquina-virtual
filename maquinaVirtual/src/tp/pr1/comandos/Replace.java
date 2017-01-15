package tp.pr1.comandos;

import tp.pr1.exceptions.BadFormatByteCodeException;
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
	public void execute(Engine engine)throws BadFormatByteCodeException{
		engine.executeReplace(replace);
	}

	@Override
	public Command parse(String[] s) throws NumberFormatException{
		if(s.length == 2 && s[0].equalsIgnoreCase("REPLACEBC"))
			try{
			return new Replace(Integer.parseInt(s[1]));
			}
		catch(NumberFormatException e){
			System.out.print("Error: no es un numero");
			return null;
		}
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "REPLACEBC N: Reemplaza la instruccion N por la solicitada al usuario.";
	}
	public String toString(){
		return "Comienza la ejecución de replacebc " + System.lineSeparator();
	}

}
