package tp.pr1.mv.comandos;

public class CommandParser {
	private static Command command;
	private final static Command[] commands = {
		new Help(), new Quit(), new Reset(),
		new Replace(), new Run(), new AddByteCodeProgram() };
	
	public static Command parse(String line){
		command = null;
		line  = line.trim();
		String[] aux = line.split(" +");
		for(int i=0; i<commands.length; i++){
			if(commands[i].parse(aux)!=null){
				return commands[i].parse(aux);
			}
		}
		return command;
	}
	
	public static void showHelp(){
		command.textHelp();
	}
}
