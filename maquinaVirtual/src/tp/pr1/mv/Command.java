package tp.pr1.mv;

public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	public Command(ENUM_COMMAND command){
		
	}
	
	
	/* 	Es el encargado de ejecutar el comando, dando la orden correspodiente a engine.
		En caso de que la ejecuci�n del comando sea incorrecta, el m�todo devuelve false.
		En otro caso devuelve true.
	*/
	public boolean execute(Engine engine){
		return false;
	}
	
}
