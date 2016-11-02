package tp.pr1.mv;

import java.util.Scanner;

public class Engine {

	Command command;
	
	Scanner capt = new Scanner(System.in);
	
	public void start(){
		
		String linea = capt.next();
		command = CommandParser.parse(linea);
		while(command. != ENUM_COMMAND.QUIT){
			
		}
	}
}

