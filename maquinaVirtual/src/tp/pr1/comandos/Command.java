package tp.pr1.comandos;

import tp.pr1.mv.Engine;

public abstract class Command {
	//private ENUM_COMMAND command;
	
	public Command(){
	}

	/* 	Es el encargado de ejecutar el comando, dando la orden correspodiente a engine.
	En caso de que la ejecuci�n del comando sea incorrecta, el m�todo devuelve false.
	En otro caso devuelve true.
	*/
	public abstract boolean execute(Engine engine);
	
	/*Recibe un array de String�s, lo parsea,
	y en caso de que se ajuste a la sintaxis del comando en cuesti�n, lo devuelve.
	En otro caso devuelve null.
	 */
	public abstract Command parse(String[] s);
	
	/*Devuelve, en forma de String, la informaci�n
	de ayuda correspondiente al comando.*/
	public abstract String textHelp();
	
	/*public ENUM_COMMAND getType(){
		return this.command;
	}*/
	
	
	/*public String toString(){
		return "Comienza la ejecucion de " + this.command + System.lineSeparator();
	}*/
	
}
