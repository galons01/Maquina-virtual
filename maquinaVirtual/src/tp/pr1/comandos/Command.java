package tp.pr1.comandos;

import java.io.FileNotFoundException;

import tp.pr1.exceptions.ArrayException;
import tp.pr1.exceptions.BadFormatByteCodeException;
import tp.pr1.exceptions.ExecutionErrorException;
import tp.pr1.exceptions.LexicalAnalysisException;
import tp.pr1.mv.Engine;


public interface Command {
	//private ENUM_COMMAND command;
	
	/**
	 * 	Es el encargado de ejecutar el comando, dando la orden correspodiente a engine.
	 * En caso de que la ejecución del comando sea incorrecta, el método devuelve false.
	 * En otro caso devuelve true.
	 * @param engine
	 * @return
	 * @throws FileNotFoundException 
	 * @throws BadFormatByteCodeException 
	 * @throws ExecutionErrorException 
	 * @throws ArrayException 
	 */
	public abstract void execute(Engine engine) throws BadFormatByteCodeException, ExecutionErrorException, ArrayException, FileNotFoundException, LexicalAnalysisException;
	
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
