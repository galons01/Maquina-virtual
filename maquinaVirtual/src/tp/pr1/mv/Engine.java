package tp.pr1.mv;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.bitecode.ByteCodeParser;
import tp.pr1.comandos.Command;
import tp.pr1.comandos.CommandParser;
import tp.pr1.elements.CPU;
import tp.pr1.elements.LexicalParser;
import tp.pr1.exceptions.ArrayException;
import tp.pr1.exceptions.LexicalAnalysisException;
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
	
	
	private static Scanner capt = new Scanner(System.in);
	
	public Engine (){
		this.sProgram = new SourceProgram();
		this.parsedProgram = new ParsedProgram();
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
	
	/**
	 * Carga un programa de un fichero.
	 * 
	 * @param fichName
	 * @throws java.io.FileNotFoundException
	 */
	public void load(String fichName) throws java.io.FileNotFoundException{
		System.out.print(command.toString());
		Scanner sc = new Scanner(new File(fichName));
		
		while(sc.hasNextLine()){
			this.sProgram.addInstr(sc.nextLine());
		}
		sc.close();
		this.mostrarProgramaSource();
	}
	
	/**
	 * Parsea y compila el programa
	 * 
	 * @throws LexicalAnalysisException
	 * @throws ArrayException
	 */
	public void executeCompile() throws LexicalAnalysisException, ArrayException{
		System.out.print(command.toString());
		
		try{
			lexicalAnalysis();
			generateByteCode();
		}
		catch (LexicalAnalysisException e){
			new LexicalAnalysisException();
		}
		
		this.mostrarProgramaSource();
		mostrarPrograma();
	}
	
	/**
	 * 	Inicializa el parseador y lo ejecuta.
	 * 
	 * @throws LexicalAnalysisException 
	 */
	private void lexicalAnalysis() throws LexicalAnalysisException{
		
		LexicalParser parseador = new LexicalParser();
		parseador.initialize(sProgram);
		parseador.lexicalParser(parsedProgram, "end");
	}
	/**
	 * Inicializa el compilador y lo ejecuta.
	 * 
	 * @throws ArrayException
	 */
	private void generateByteCode() throws ArrayException{
		
		tp.pr1.elements.Compiler compilador = new tp.pr1.elements.Compiler();
		compilador.initialize(program);
		compilador.compile(parsedProgram);
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
	 * Muestra el programa leido del txt por consola.
	 */
	public void mostrarProgramaSource(){
		System.out.println("Programa fuente almacenado:");
		sProgram.mostrarPrograma();
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

