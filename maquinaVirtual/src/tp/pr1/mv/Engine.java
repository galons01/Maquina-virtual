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
import tp.pr1.exceptions.BadFormatByteCodeException;
import tp.pr1.exceptions.ExecutionErrorException;
import tp.pr1.exceptions.LexicalAnalysisException;
/**
 * Representa el bucle de control de la aplicaci�n, contiene la cpu.
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
		this.program = new ByteCodeProgram();				//el tama�o del programa se puede ajustar aqui.
		this.end = true;
	}
	
	/**
	 * Comienza el programa, se encarga de captar los comandos y ejecutarlos.
	 * @throws FileNotFoundException 
	 * @throws BadFormatByteCodeException 
	 * @throws ExecutionErrorException 
	 * @throws ArrayException 
	 * @throws LexicalAnalysisException 
	 */
	public void start() throws FileNotFoundException, BadFormatByteCodeException, ExecutionErrorException, ArrayException, LexicalAnalysisException{
		end = false;
		boolean exc = false;
		do{
			System.out.print("> ");			String linea = capt.nextLine();
			linea = linea.toUpperCase();
			command = CommandParser.parse(linea);
			ejecutado = false;
			exc = false;
			if(command == null)
				System.out.println("Error: Comando desconocido");
			else 
				try{
					this.command.execute(this);	
					/*if(this.sProgram.getSize() != 0) 
						this.mostrarProgramaSource();
					if(this.program.getContador() != 0)
						this.mostrarPrograma();*/
				}catch(FileNotFoundException e){
					System.out.println("Excepcion: archivo no encontrado");
					exc = true;
				}
				catch(BadFormatByteCodeException w){
					System.out.println(w.toString());
					exc = true;
				}
				catch(LexicalAnalysisException e){
					System.out.println(e.toString());
					exc = true;
				}
				catch(ExecutionErrorException e){
					System.out.print(e.toString());
					exc = true;
				}
				catch(ArrayException e){
					System.out.print(e.toString());
					exc = true;
				}
			if(!exc){
				if(this.sProgram.getSize() != 0) 
				this.mostrarProgramaSource();
				if(this.program.getContador() != 0)
				this.mostrarPrograma();
			}
//				System.out.println("Error: Ejecucion incorrecta del comando");
		}while(command == null || !end);
	
	}
	
	/**
	 * Carga un programa de un fichero.
	 * 
	 * @param fichName
	 * @throws FileNotFoundException
	 * @throws ArrayException 
	 */
	public void load(String fichName) throws FileNotFoundException, ArrayException{
		System.out.print(command.toString());
		try{
		Scanner sc = new Scanner(new File(fichName));
		
		this.sProgram.reset();
		this.parsedProgram.reset();
		this.program.resetProgram();
		while(sc.hasNextLine()){
			this.sProgram.addInstr(sc.nextLine());
		}
		sc.close();
		}catch(FileNotFoundException e){
			throw new FileNotFoundException();
		}
		catch(ArrayException e){
			throw new ArrayException();
		}
	}
	
	/**
	 * Parsea y compila el programa
	 * 
	 * @throws LexicalAnalysisException
	 * @throws ArrayException
	 */
	public void executeCompile() throws LexicalAnalysisException, ArrayException{
		System.out.print(command.toString());
		this.parsedProgram.reset();
		this.program.resetProgram();
		try{
			lexicalAnalysis();
			generateByteCode();
		}
		catch (LexicalAnalysisException e){
			throw new LexicalAnalysisException();
		}
		catch(ArrayException e){
			throw new ArrayException();
		}
	}
	
	/**
	 * 	Inicializa el parseador y lo ejecuta.
	 * 
	 * @throws LexicalAnalysisException 
	 * @throws ArrayException 
	 */
	private void lexicalAnalysis() throws LexicalAnalysisException, ArrayException{
		
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
	
	/**A�ade un programa(Bytecode)
	 * 
	 * @param programa
	 * @return
	 * @throws ArrayException 
	 */
	public boolean a�adirPrograma(ByteCode programa) throws ArrayException{
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
	public boolean remplazarInstruccion(int pos)throws BadFormatByteCodeException{
		if(pos < program.getContador()){
			System.out.print("Nueva instruccion: ");
			String linea = capt.nextLine();
			linea = linea.toUpperCase();
			if( program.addInstruccion(linea, pos))
				return true;
			else
				throw new BadFormatByteCodeException();
		}
		else 
			//System.out.print("Error: Ejecucion incorrecta del comando " + System.lineSeparator());
			return false;
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
	 * @throws ArrayException 
	 */
	public boolean readByteCodeProgram() throws ArrayException{
		
		System.out.print(command.toString());
		System.out.println("Introduce el bytecode. Una instruccion por l�nea:");
		System.out.println("");
		
		ByteCode byteCode;
		String lineaByte = capt.nextLine();
		lineaByte = lineaByte.toUpperCase();
		resetProgram();
		while (!lineaByte.equals("END")){
			
			byteCode = ByteCodeParser.parse(lineaByte);
		
			if(byteCode != null){
				ejecutado = a�adirPrograma(byteCode);
			}
			else
				System.out.println("Bytecode erroneo, intentelo de nuevo:");
			lineaByte = capt.nextLine();
			lineaByte = lineaByte.toUpperCase();
		}
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
		ejecutado = true;
		end = true;
		return ejecutado;
	}
	
	/**Remplaza una instruccion.
	 * 
	 * @param pos
	 * @return
	 */
	public boolean executeReplace(int pos)throws BadFormatByteCodeException, ArrayException {
		System.out.print(command.toString());
		if(remplazarInstruccion(pos))
			ejecutado = true;
		else{
			throw new ArrayException();
		}
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
	 * @throws ExecutionErrorException 
	 */
	public boolean executeRun() throws ExecutionErrorException,ArrayException {
		cpu = new CPU(program);
		System.out.print(command.toString());
		if(cpu.run()){
			throw new ExecutionErrorException();
		}
		ejecutado = true;
		return ejecutado;
	}
}

