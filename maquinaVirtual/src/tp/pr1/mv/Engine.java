package tp.pr1.mv;

import java.util.Scanner;

public class Engine {

	private ByteCodeProgram program;
	private boolean end;
	Command command;
	
	Scanner capt = new Scanner(System.in);
	
	public void start(){
		
		String linea = capt.next();
		command = CommandParser.parse(linea);
		while(command.getType() != ENUM_COMMAND.QUIT){
			
			
			linea = capt.next();
			command = CommandParser.parse(linea);
		}
	}
}

