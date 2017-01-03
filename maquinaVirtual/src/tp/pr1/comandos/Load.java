package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public class Load implements Command {

	private String fich;

	public Load(String fich){
		super();
		this.fich = fich;
	}
	
	@Override
	public void execute(Engine engine) {
		// TODO Auto-generated method stub
	}

	@Override
	public Command parse(String[] s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String textHelp() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		return "Comienza la ejecución de LOAD " + fich + System.lineSeparator();
	}
}
