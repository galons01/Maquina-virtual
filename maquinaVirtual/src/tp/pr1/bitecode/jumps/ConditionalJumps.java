package tp.pr1.bitecode.jumps;

//import tp.pr1.mv.bitecode.ByteCode;
import tp.pr1.cpu.CPU;

public abstract class ConditionalJumps extends Jump{
	//private int n;
	private int c, sc;
	
	public ConditionalJumps(int n){
		super(n);
		//this.n=n;
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		if(!cpu.emptyStack()){
			c = cpu.pop();
			cpu.meterPila(c);
			if(!cpu.emptyStack()){
				sc = cpu.pop();
				cpu.meterPila(sc);
				if(compares(c, sc, cpu))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else{
			return false;
		}
	}

	protected abstract boolean compares(int c, int sc, CPU cpu);

}
