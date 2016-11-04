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
		En caso de que la ejecuci�n del comando sea incorrecta, el m�todo devuelve false.
		En otro caso devuelve true.
	*/
	public boolean execute(Engine engine){
		boolean ejecutado = false;
		switch (command) {
		
		case HELP:		System.out.println("Comienza la ejecuci�n de " + command);
						System.out.println("	HELP: Muestra esta ayuda");
						System.out.println("	QUIT: Cierra la aplicacion");
						System.out.println("	RUN: Ejecuta el programa");
						System.out.println("	NEWINST BYTECODE: Introduce una nueva instrucci�n al programa");
						System.out.println("	RESET: Vacia el programa actual");
						System.out.println("	REPLACE N: Reemplaza la instruccion N por la solicitada al usuario");
						ejecutado = true;
						break;
		
		case QUIT:		System.out.println("Comienza la ejecuci�n de " + command);
						ejecutado = true;
						break;
		
		case NEWINST:	System.out.print("Comienza la ejecuci�n de " + command + this.instruction);
						if(replace>-1)
							System.out.println(replace);
						ejecutado = engine.A�adirPrograma(this.instruction);
						break;
		
		case RUN:		System.out.println("Comienza la ejecuci�n de " + command);
						ejecutado = true;
						break;
		
		case RESET:		System.out.println("Comienza la ejecuci�n de " + command);
						ejecutado = true;
						break;
		
		case REPLACE:	System.out.println("Comienza la ejecuci�n de " + command + this.replace);
						ejecutado = true;
						break;
						
		default:		ejecutado = false;
						break;
		
		}
		return ejecutado;
	}
	
}
