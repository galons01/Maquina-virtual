package tp.pr1.mv;

public class CommandParser {
	private static ENUM_COMMAND enumComands;
	private static Command command;
	
	public static Command parse(String line){
		command = null;
		switch (line) {
		case "HELP":  		command = new Command(enumComands.HELP);
        					break;
		case "QUIT":  		command = new Command(enumComands.QUIT);
							break;
		case "NEWINST":  	command = new Command(enumComands.NEWINST);
							break;
		case "RUN":  		command = new Command(enumComands.RUN);
							break;
		case "RESET":  		command = new Command(enumComands.RESET);
							break;
		case "REPLACE":  	command = new Command(enumComands.REPLACE);
							break;
		}
		return command;
	}
}
