package tp.pr1.mv.comandos;

import tp.pr1.mv.ENUM_COMMAND;
import tp.pr1.mv.Engine;

public class AddByteCodeProgram extends Command {

	public AddByteCodeProgram() {
		super(ENUM_COMMAND.BYTECODE);
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
}
