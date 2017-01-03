package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public class AddByteCodeProgram implements Command {

	public AddByteCodeProgram() {
		super();
	}

	@Override
	public void execute(Engine engine) {
		engine.readByteCodeProgram();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length==1 && s[0].equalsIgnoreCase("BYTECODE"))
			return new AddByteCodeProgram();
		else 
			return null;
	}

	@Override
	public String textHelp() {
		return "BYTECODE: Introduce nuevas instrucci�nes al programa, una por linea.";
	}
	
	public String toString(){
		return "Comienza la ejecuci�n de BYTECODE."+ System.lineSeparator();
	}
}
