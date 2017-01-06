package tp.pr1.bitecode;

import tp.pr1.elements.CPU;

public class Halt extends ByteCode{

	public Halt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		cpu.halt();
		return true;
	}

	@Override
	public ByteCode parse(String[] s) {
		// TODO Auto-generated method stub
		if(s.length == 1 && s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else
			return null;
	}
	public String toString(){
		return "HALT ";
	}

}
