package tp.pr1.inst.assignments;

import tp.pr1.bitecode.ByteCode;

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
		// TODO Auto-generated method stub
		return null;
	}

}
