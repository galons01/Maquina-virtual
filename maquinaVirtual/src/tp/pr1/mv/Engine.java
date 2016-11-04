package tp.pr1.mv;

import java.util.Scanner;

public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	
	Scanner capt = new Scanner(System.in);
	
	public void start(){
		do{
			System.out.print("> ");
			String linea = capt.next();
			command = CommandParser.parse(linea);
			if(!this.command.execute(this))
				System.out.println("Error: Ejecucion incorrecta del comando");
		}while(command.getType() != ENUM_COMMAND.QUIT);
	}
	
	public boolean AñadirPrograma(ByteCode programa){
		return program.addInstruccion(programa);
	}
}

