package tp.pr1.mv.bitecode;

import cpu.CPU;

public class Out extends ByteCode{

	public Out() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		if(!cpu.emptyStack()){
			cpu.out();
			return true;
		}
		else
			return false;
	}

	@Override
	public ByteCode parse(String[] s) {
		// TODO Auto-generated method stub
		if(s.length == 1 && s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else
			return null;
	}
	public String toString(){
		return "OUT";
	}

}
