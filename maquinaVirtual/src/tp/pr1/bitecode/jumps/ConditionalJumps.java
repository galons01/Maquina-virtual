package tp.pr1.bitecode.jumps;

import tp.pr1.elements.CPU;

public abstract class ConditionalJumps extends Jump{
	private int c, sc;
	
	public ConditionalJumps(int n){
		super(n);
	}

	@Override
	/**
	 * Ejecuta la parte com�n de la ejecuci�n de los bytecodes de salto, es decir, 
	 * extrae la cima y la subcima de la pila de operandos. La operaci�n concreta 
	 * la lleva a cabo el m�todo abstracto compares()
	 * 
	 * @param cpu
	 */
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		if(!cpu.emptyStack()){
			c = cpu.pop();
			//cpu.meterPila(c);
			if(!cpu.emptyStack()){
				sc = cpu.pop();
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

	public void setN(int n){
		//Cambiar el tama�o de la n
	}
}
