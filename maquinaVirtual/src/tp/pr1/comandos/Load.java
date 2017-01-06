package tp.pr1.comandos;

import java.io.FileNotFoundException;

import tp.pr1.mv.Engine;

public class Load implements Command {

	private String fich;

	public Load(){
		
	}
	
	public Load(String fich){
		super();
		this.fich = fich;
	}
	
	@Override
	public void execute(Engine engine) {
		try{
			engine.load(fich);
		}catch (FileNotFoundException e){
			
		}
	}

	@Override
	public Command parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
			return new Load(s[1]);
		else
			return null;
	}

	@Override
	public String textHelp() {
		return "LOAD: load nombreDeFichero.txt";
	}
	
	public String toString(){
		return "Comienza la ejecución de LOAD " + fich + System.lineSeparator();
	}
}
