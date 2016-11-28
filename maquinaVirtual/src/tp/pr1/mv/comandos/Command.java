package tp.pr1.mv.comandos;

import tp.pr1.mv.ENUM_COMMAND;
import tp.pr1.mv.Engine;

public abstract class Command {
	private ENUM_COMMAND command;
	
	public Command(ENUM_COMMAND command){
		this.command = command;
	}
	
	// Contructor para el comando replace
/*	public Command(ENUM_COMMAND command,  int replace){
		this.command = command;
		this.replace = replace;
	}*/
	
	/* 	Es el encargado de ejecutar el comando, dando la orden correspodiente a engine.
	En caso de que la ejecución del comando sea incorrecta, el método devuelve false.
	En otro caso devuelve true.
	*/
	public abstract boolean execute(Engine engine);
	
	/*Recibe un array de String’s, lo parsea,
	y en caso de que se ajuste a la sintaxis del comando en cuestión, lo devuelve.
	En otro caso devuelve null.
	 */
	public abstract Command parse(String[] s);
	
	/*Devuelve, en forma de String, la información
	de ayuda correspondiente al comando.*/
	public abstract String textHelp();
	
	public ENUM_COMMAND getType(){
		return this.command;
	}
	
/*		switch (command) {
		
		case HELP:		return engine.executeHelp();
		
		case QUIT:		return engine.executeQuit();
		
		case BYTECODE:	return engine.readByteCodeProgram();
		
		case RUN:		return engine.executeRun();
		
		case RESET:		return engine.executeReset();
		
		case REPLACE:	return engine.executeReplace(replace);
						
		default:		return false;
		
		}*/
	
	public String toString(){
		return "Comienza la ejecucion de " + this.command + System.lineSeparator();
	}
	
}
