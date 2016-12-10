package tp.pr1.mv;

import java.util.Scanner;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.bitecode.ByteCodeParser;
import tp.pr1.comandos.Command;
import tp.pr1.comandos.CommandParser;
import tp.pr1.cpu.ByteCodeProgram;
import tp.pr1.cpu.CPU;

public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	private CPU cpu;
	private boolean ejecutado;
	
	private static Scanner capt = new Scanner(System.in);
	
	public Engine (){
		this.program = new ByteCodeProgram();				//el tama�o del programa se puede ajustar aqui.
		this.end = true;
	}
	
	public void start(){
		end = false;
		do{
			System.out.print("> ");			String linea = capt.nextLine();
			linea = linea.toUpperCase();
			command = CommandParser.parse(linea);
			ejecutado = false;
			if(command == null)
				System.out.println("Error: Comando desconocido");
			else if(!this.command.execute(this))
				System.out.println("Error: Ejecucion incorrecta del comando");
			/*else if (command.getType() ==)//quitar
					end = true;*/
			
		}while(command == null || !end);
	}
	
	public boolean a�adirPrograma(ByteCode programa){
		return program.addInstruccion(programa);
	}
	
	public void mostrarPrograma(){
		System.out.println("Programa almacenado: ");
		program.mostrarPrograma();
	}
	
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
	
	public void resetProgram() {
		program.resetProgram();
		
	}
	public boolean executeHelp() {
		CommandParser.showHelp();
		ejecutado = true;
		return ejecutado;
}
	public boolean executeQuit() {
		System.out.print(command.toString());
		mostrarPrograma();
		ejecutado = true;
		end = true;
		return ejecutado;
	}
	
	public boolean readByteCodeProgram(){
		
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
		mostrarPrograma();
		return ejecutado;
	}
	
	public boolean executeReplace(int pos) {
		System.out.print(command.toString());
		if(remplazarInstruccion(pos))
			ejecutado = true;
		mostrarPrograma();
		return ejecutado;
	}
	public boolean executeReset() {
		System.out.print(command.toString());
		resetProgram();
		ejecutado = true;
		return ejecutado;
	}
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

