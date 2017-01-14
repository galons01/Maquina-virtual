package tp.pr1.bitecode;

import tp.pr1.elements.CPU;
import tp.pr1.exceptions.StackException;

public class Load extends ByteCode {
	
	private int param;

	public Load(int param) {
		super();
		this.param = param;
	}

	@Override
	public boolean execute(CPU cpu)throws StackException{
		if( cpu.read(param))
			return true;
		else
			throw new StackException();
	
	}

	@Override
	public ByteCode parse(String[] s) {
		if(s.length>1 && s.length <3 && s[0].equalsIgnoreCase("LOAD")){
			try {
				Integer.parseInt(s[1]);
				return new Load(Integer.parseInt(s[1]));
			} catch (NumberFormatException nfe){
				return null;
			}
		}
		else
			return null;
	}
	
	public String toString(){
		return "LOAD " + param;
	}

}
