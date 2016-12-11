package tp.pr1.comandos;

import tp.pr1.mv.Engine;


public abstract class Command {
	//private ENUM_COMMAND command;
	
	public Command(){
	}
	/**
	 * 	Es el encargado de ejecutar el comando, dando la orden correspodiente a engine.
	 * En caso de que la ejecución del comando sea incorrecta, el método devuelve false.
	 * En otro caso devuelve true.
	 * @param engine
	 * @return
	 */
	public abstract boolean execute(Engine engine);
	
	/**
	 * Recibe un array de String’s, lo parsea,
	 * y en caso de que se ajuste a la sintaxis del comando en cuestión, lo devuelve.
	 * En otro caso devuelve null.
	 * @param s
	 * @return
	 */
	public abstract Command parse(String[] s);
	
	/**
	 * Devuelve, en forma de String, la información
	 * de ayuda correspondiente al comando.
	 * @return
	 */

	public abstract String textHelp();
	
	
}
