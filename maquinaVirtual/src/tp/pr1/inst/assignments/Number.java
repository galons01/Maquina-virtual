package tp.pr1.inst.assignments;

import tp.pr1.bitecode.ByteCode;
import tp.pr1.bitecode.Push;
import tp.pr1.elements.Compiler;

public class Number implements Term{
	
	private int number;
	
	public Number(int num){
		this.number = num;
	}
	
	@Override
	public Term parse(String term) {
		//posible chequeo string
		return new Number(Integer.parseInt(term));
	}

	@Override
	public ByteCode compile(Compiler compiler) {
		return new Push(number);
	}


}
