package tp.pr1.mv;

public class ByteCodeParser {
	private static ByteCode byteCode;
	
	
	public static ByteCode parse(String line){
		String[] aux = line.split(" ");
		switch (aux[0]) {
		case "PUSH":  		byteCode = new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(aux[1]));
        					break;
		case "LOAD":  		byteCode = new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(aux[1]));
							break;
		case "STORE": 	 	byteCode = new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(aux[1]));
							break;
		case "ADD":  		byteCode = new ByteCode(ENUM_BYTECODE.ADD);
							break;
		case "SUB":  		byteCode = new ByteCode(ENUM_BYTECODE.SUB);
							break;
		case "MUL": 	 	byteCode = new ByteCode(ENUM_BYTECODE.MUL);
							break;
		case "DIV": 	 	byteCode = new ByteCode(ENUM_BYTECODE.DIV);
							break;
		case "OUT": 	 	byteCode = new ByteCode(ENUM_BYTECODE.OUT);
							break;
		case "HALT": 	 	byteCode = new ByteCode(ENUM_BYTECODE.HALT);
							break;
		}
		return byteCode;
	}
}
