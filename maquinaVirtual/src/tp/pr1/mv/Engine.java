package tp.pr1.mv;

import java.util.Scanner;

public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	
	Scanner capt = new Scanner(System.in);
	
	public void start(){
		end = false;
		do{
			System.out.print("> ");
			String linea = capt.next();
			linea = linea.toUpperCase();
			command = CommandParser.parse(linea);
			if(command == null)
				System.out.println("Error: Comando desconocido");
			else if(!this.command.execute(this)){
				System.out.println("Error: Ejecucion incorrecta del comando");
				if (command.getType() != ENUM_COMMAND.QUIT)
					end = true;
			}
		}while(command == null || !end);
	}
	
	public boolean AņadirPrograma(ByteCode programa){
		return program.addInstruccion(programa);
	}
}

