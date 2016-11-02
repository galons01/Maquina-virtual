package tp.pr1.mv;

public class CommandParser {
	private static ENUM_COMMAND enumComands;
	private static Command command;
	
	public static Command parse(String line){
		command = null;
		String[] aux = line.split(" ");
		switch (aux[0]) {
		case "HELP":  		command = new Command(enumComands.HELP, null, -1);
        					break;
		case "QUIT":  		command = new Command(enumComands.QUIT, null, -1);
							break;
		case "NEWINST":  	command = new Command(enumComands.NEWINST, ByteCodeParser.parse(aux[1]), Integer.parseInt(aux[2]));
							break;
		case "RUN":  		command = new Command(enumComands.RUN, null, -1);
							break;
		case "RESET":  		command = new Command(enumComands.RESET, null, -1);
							break;
		case "REPLACE":  	command = new Command(enumComands.REPLACE, null, Integer.parseInt(aux[1]));
							break;
		}
		return command;
	}
}
