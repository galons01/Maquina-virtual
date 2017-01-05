package tp.pr1.exceptions;

public class ArrayException extends Exception {

	/**
	 * Se lanza cuando se intenta acceder a posiciones incorrectas de
	 * un array; por ejemplo, al añadir algo a un array que está lleno,
	 * o al acceder a una componente que no existe de un array
	 */
	private static final long serialVersionUID = 1L;

	public ArrayException(){
		super("Excepción ArrayException: posicion inexistente o array completo");
	}
	
	public ArrayException(String mensaje){
		super(mensaje);
	}
}
