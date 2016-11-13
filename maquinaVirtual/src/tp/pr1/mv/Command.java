package tp.pr1.mv;

public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	public Command(ENUM_COMMAND command){
		this.command = command;
		this.instruction = null;
		this.replace = -1;
	}
	
	// El comando newinst puede tener bytecodes que no tengan parametro int.
	public Command(ENUM_COMMAND command, ByteCode instruction){
		this.command = command;
		this.instruction = instruction;
		this.replace = -1;
	}
	
	// Contructor para el comando replace
	public Command(ENUM_COMMAND command,  int replace){
		this.command = command;
		this.instruction = null;
		this.replace = replace;
	}
	
	public Command(ENUM_COMMAND command, ByteCode instruction, int replace){
		this.command = command;
		this.instruction = instruction;
		this.replace = replace;
	}
	
	public ENUM_COMMAND getType(){
		return this.command;
	}
	
	/* 	Es el encargado de ejecutar el comando, dando la orden correspodiente a engine.
		En caso de que la ejecución del comando sea incorrecta, el método devuelve false.
		En otro caso devuelve true.
	*/
	public boolean execute(Engine engine){
		switch (command) {
		
		case HELP:		return engine.executeHelp();
		
		case QUIT:		return engine.executeQuit();
		
		case NEWINST:	return engine.executeNewInst(instruction);
		
		case RUN:		return engine.executeRun();
		
		case RESET:		return engine.executeReset();
		
		case REPLACE:	return engine.executeReplace(replace);
						
		default:		return false;
		
		}
	}
	public String toString(){
		return "Comienza la ejecucion de " + this.command + System.lineSeparator();
	}
	
}
