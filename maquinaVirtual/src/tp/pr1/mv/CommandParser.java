package tp.pr1.mv;

public class CommandParser {
	private static Command command;
	
	public static Command parse(String line){
		command = null;
		String[] aux = line.split(" ");
		switch (aux[0]) {
		case "HELP":  		command = new Command(ENUM_COMMAND.HELP);
        					break;
		case "QUIT":  		command = new Command(ENUM_COMMAND.QUIT);
							break;
		case "NEWINST":  	command = new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(aux[1]), Integer.parseInt(aux[2]));
							break;
		case "RUN":  		command = new Command(ENUM_COMMAND.RUN);
							break;
		case "RESET":  		command = new Command(ENUM_COMMAND.RESET);
							break;
		case "REPLACE":  	command = new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(aux[1]));
							break;
		}
		return command;
	}
}
