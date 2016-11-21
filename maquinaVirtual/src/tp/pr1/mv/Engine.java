package tp.pr1.mv;

import java.util.Scanner;

public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	private CPU cpu;
	private boolean ejecutado;
	
	private static Scanner capt = new Scanner(System.in);
	
	public Engine (){
		this.program = new ByteCodeProgram();				//el tamaño del programa se puede ajustar aqui.
		this.end = true;
	}
	
	public void start(){
		end = false;
		do{
			System.out.print("> ");
			String linea = capt.nextLine();
			linea = linea.toUpperCase();
			command = CommandParser.parse(linea);
			ejecutado = false;
			if(command == null)
				System.out.println("Error: Comando desconocido");
			else if(!this.command.execute(this))
				System.out.println("Error: Ejecucion incorrecta del comando");
			else if (command.getType() == ENUM_COMMAND.QUIT)
					end = true;
			
		}while(command == null || !end);
	}
	
	public boolean añadirPrograma(ByteCode programa){
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
	
	public boolean iniciar(){
		boolean error = false;
		int contador = program.getContador();
		for(int i = 0; i < contador && !error; i++){
			if(cpu.execute(program.devolverInstruccion(i)) && !error){
				System.out.println("El estado de la maquina tras ejecutar el bytecode " + program.devolverInstruccion(i) + " es:");
				System.out.println(" ");
				System.out.println(cpu.toString());
				System.out.println();
			}
			else
				error = true;
		}
		cpu.finPrograma();
		return error;
	}
	
	public void resetProgram() {
		program.resetProgram();
		
	}
	public boolean executeHelp() {
		System.out.print(command.toString());
		System.out.println("	HELP: Muestra esta ayuda");
		System.out.println("	QUIT: Cierra la aplicacion");
		System.out.println("	RUN: Ejecuta el programa");
		System.out.println("	NEWINST BYTECODE: Introduce una nueva instrucción al programa");
		System.out.println("	RESET: Vacia el programa actual");
		System.out.println("	REPLACE N: Reemplaza la instruccion N por la solicitada al usuario");
		ejecutado = true;
		return ejecutado;
}
	public boolean executeQuit() {
		System.out.print(command.toString());
		mostrarPrograma();
		ejecutado = true;
		return ejecutado;
	}
	public boolean executeNewInst(ByteCode instruccion) {
		if(instruccion != null){
			System.out.print(command.toString());
			ejecutado = añadirPrograma(instruccion);
			mostrarPrograma();
		}
		else
			System.out.print(command.toString());
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
		cpu = new CPU();
		System.out.print(command.toString());
		if(iniciar())
			System.out.println("Error: Ejecucion incorrecta del comando");
		ejecutado = true;
		mostrarPrograma();
		return ejecutado;
	}
}

