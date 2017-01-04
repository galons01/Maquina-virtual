package tp.pr1.mv;

import java.util.Scanner;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.bitecode.ByteCodeParser;
import tp.pr1.comandos.Command;
import tp.pr1.comandos.CommandParser;
import tp.pr1.cpu.ByteCodeProgram;
import tp.pr1.cpu.CPU;
/**
 * Representa el bucle de control de la aplicación, contiene la cpu.
 */
public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	private CPU cpu;
	private boolean ejecutado;
	private SourceProgram sProgram;
	private ParsedProgram parsedProgram;
	private ByteCodeProgram bytecodeProgram;
	
	
	private static Scanner capt = new Scanner(System.in);
	
	public Engine (){
		this.program = new ByteCodeProgram();				//el tamaño del programa se puede ajustar aqui.
		this.end = true;
	}
	
	/**
	 * Comienza el programa, se encarga de captar los comandos y ejecutarlos.
	 */
	public void start(){
		end = false;
		do{
			System.out.print("> ");			String linea = capt.nextLine();
			linea = linea.toUpperCase();
			command = CommandParser.parse(linea);
			ejecutado = false;
			if(command == null)
				System.out.println("Error: Comando desconocido");
			else {this.command.execute(this);}				//aqui va la captura de excepcion
//				System.out.println("Error: Ejecucion incorrecta del comando");

			
		}while(command == null || !end);
	}
	
	/**Añade un programa(Bytecode)
	 * 
	 * @param programa
	 * @return
	 */
	public boolean añadirPrograma(ByteCode programa){
		return program.addInstruccion(programa);
	}
	
	/**
	 * Muestra un programa por consola.
	 */
	public void mostrarPrograma(){
		System.out.println("Programa almacenado: ");
		program.mostrarPrograma();
	}
	
	/**Cambia la intruccion en la ubicacion "pos" por otra.
	 * 
	 * @param pos
	 * @return
	 */
	public boolean remplazarInstruccion(int pos){
		if(pos < program.getContador()){
			System.out.print("Nueva instruccion: ");
			String linea = capt.nextLine();
			linea = linea.toUpperCase();
			return program.addInstruccion(linea, pos);
		}
		else 
			System.out.print("Error: Ejecucion incorrecta del comando " + System.lineSeparator());
			return true;
	}
	
	/**
	 * Reset
	 */
	public void resetProgram() {
		program.resetProgram();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean executeHelp() {
		CommandParser.showHelp();
		ejecutado = true;
		return ejecutado;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean executeQuit() {
		System.out.print(command.toString());
		mostrarPrograma();
		ejecutado = true;
		end = true;
		return ejecutado;
	}
	
	/**Capta un BytecodeProgram por teclado y lo muestra.
	 * 
	 * @return
	 */
	public boolean readByteCodeProgram(){
		
		System.out.print(command.toString());
		System.out.println("Introduce el bytecode. Una instruccion por línea:");
		System.out.println("");
		
		ByteCode byteCode;
		String lineaByte = capt.nextLine();
		lineaByte = lineaByte.toUpperCase();
		resetProgram();
		while (!lineaByte.equals("END")){
			
			byteCode = ByteCodeParser.parse(lineaByte);
		
			if(byteCode != null){
				ejecutado = añadirPrograma(byteCode);
			}
			else
				System.out.println("Bytecode erroneo, intentelo de nuevo:");
			lineaByte = capt.nextLine();
			lineaByte = lineaByte.toUpperCase();
		}
		mostrarPrograma();
		return ejecutado;
	}
	
	/**Remplaza una instruccion.
	 * 
	 * @param pos
	 * @return
	 */
	public boolean executeReplace(int pos) {
		System.out.print(command.toString());
		if(remplazarInstruccion(pos))
			ejecutado = true;
		mostrarPrograma();
		return ejecutado;
	}
	
	/**reset
	 * 
	 * @return
	 */
	public boolean executeReset() {
		System.out.print(command.toString());
		resetProgram();
		ejecutado = true;
		return ejecutado;
	}
	
	/**Ejecuta el programa.
	 * 
	 * @return
	 */
	public boolean executeRun() {
		cpu = new CPU(program);
		System.out.print(command.toString());
		if(cpu.run())
			System.out.println("Error: Ejecucion incorrecta del comando");
		ejecutado = true;
		mostrarPrograma();
		return ejecutado;
	}
}

