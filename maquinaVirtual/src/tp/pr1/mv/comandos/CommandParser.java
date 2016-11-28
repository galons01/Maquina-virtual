package tp.pr1.mv.comandos;

import tp.pr1.mv.ENUM_COMMAND;

public class CommandParser {
	private static Command command;
	
	public static Command parse(String line){
		command = null;
		line  = line.trim();
		String[] aux = line.split(" +");
		switch (aux[0]) {
		case "HELP":  		if(aux.length==1)
								command = new Command(ENUM_COMMAND.HELP);
        					break;
        					
		case "QUIT":  		if(aux.length==1)
								command = new Command(ENUM_COMMAND.QUIT);
							break;
							
		case "BYTECODE":	if(aux.length==1)
								command = new Command(ENUM_COMMAND.BYTECODE);
							break;
							
		case "RUN":  		if(aux.length==1)
								command = new Command(ENUM_COMMAND.RUN);
							break;
							
		case "RESET":  		if(aux.length==1)
								command = new Command(ENUM_COMMAND.RESET);
							break;
							
		case "REPLACE":  	if(aux.length == 2){
								try{
									Integer.parseInt(aux[1]);
								command = new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(aux[1]));
								}catch (NumberFormatException nfe){
								}
							}
							break;
							
		}
		return command;
	}
}
