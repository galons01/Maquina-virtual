package tp.pr1.mv;

import java.io.FileNotFoundException;

import tp.pr1.exceptions.BadFormatByteCodeException;
import tp.pr1.exceptions.ExecutionErrorException;

public class Main {
	public static void main(String args[]) throws FileNotFoundException, BadFormatByteCodeException, ExecutionErrorException {
		Engine engine = new Engine();
		engine.start();
		System.out.println("Fin de la ejecucion....");
		}
}
 