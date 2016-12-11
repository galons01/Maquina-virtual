package tp.pr1.bitecode;

import tp.pr1.cpu.CPU;

public class Out extends ByteCode{

	public Out() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		if(!cpu.emptyStack()){
			System.out.println("La cima de la pila es: " + cpu.out());
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
