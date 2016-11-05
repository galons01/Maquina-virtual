package tp.pr1.mv;

import java.util.Scanner;

public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	
	Scanner capt = new Scanner(System.in);
	
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
	public void iniciar(){
		 program.iniciarPrograma();
	}
}

