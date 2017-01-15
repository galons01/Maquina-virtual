package tp.pr1.exceptions;

public class BadFormatByteCodeException extends Exception{

	/**
	 * Se lanza cuando se encuentra un bytecode incorrecto
	 */
	private static final long serialVersionUID = 1L;

	public BadFormatByteCodeException(){
		super("Excepcion BadFormatByteCodeException: bytecode incorrecto");
	}
	
	public BadFormatByteCodeException(String mensaje){
		super(mensaje);
	}
	
	public String toString(){
		return "Execepcion: Bytecode incorrecto";
	}
}
