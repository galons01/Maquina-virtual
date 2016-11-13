package tp.pr1.mv;

import java.util.Scanner;

public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	private CPU cpu;
	
	private static Scanner capt = new Scanner(System.in);
	
	public Engine (){
		this.program = new ByteCodeProgram();				//el tamaño del programa se puede ajustar aqui.
		this.end = true;
		this.cpu = new CPU();
	}
	
	public void start(){
		end = false;
		do{
			System.out.print("> ");
			String linea = capt.nextLine();
			linea = linea.toUpperCase();
			command = CommandParser.parse(linea);
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
		for(int i = 0; i < contador; i++){
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
}

