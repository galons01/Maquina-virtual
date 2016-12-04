package tp.pr1.comandos;

public class CommandParser {
	private final static Command[] commands = {
		new Help(), new Quit(), new Reset(),
		new Replace(), new Run(), new AddByteCodeProgram() };
	
	public static Command parse(String line){
		line  = line.trim();
		String[] aux = line.split(" +");
		for(int i=0; i<commands.length; i++){
			if(commands[i].parse(aux)!=null){
				return commands[i].parse(aux);
			}
		}
		return null;
	}
	
	public static void showHelp(){
		for(int i=0; i<commands.length; i++){
			System.out.println(commands[i].textHelp());
		}
	}
}
