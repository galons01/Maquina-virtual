package tp.pr1.mv;

public class ByteCodeParser {
	private static ByteCode byteCode;
	
	
	public static ByteCode parse(String line){
		switch (line) {
		case "PUSH":  		byteCode = new ByteCode(ENUM_BYTECODE.PUSH);
        					break;
		case "LOAD":  		byteCode = new ByteCode(ENUM_BYTECODE.LOAD);
							break;
		case "STORE": 	 	byteCode = new ByteCode(ENUM_BYTECODE.STORE);
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
