package tp.pr1.mv;

public class Main {
	public static void main(String args[]) {
		Engine engine = new Engine();
		engine.start();
		System.out.println("Fin de la ejecucion....");
		}
}

/* Errores:
 * cambios en la funcionalidad de la pila (se muestran en orden contrario)
 * error en el comando newinst push
 * error en la ejecucion de add con un unico parametro no controlado
 * igual con replace
 * falta de control en la instruccion div, ej: 2/0
 * */
 