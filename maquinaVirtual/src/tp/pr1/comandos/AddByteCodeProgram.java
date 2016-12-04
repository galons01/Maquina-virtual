package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public class AddByteCodeProgram extends Command {

	public AddByteCodeProgram() {
		super();
	}

	@Override
	public boolean execute(Engine engine) {
		return engine.readByteCodeProgram();
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
		return "BYTECODE: Introduce nuevas instrucciónes al programa, una por linea.";
	}
	
	public String toString(){
		return "Comienza la ejecución de BYTECODE."+ System.lineSeparator();
	}
}
