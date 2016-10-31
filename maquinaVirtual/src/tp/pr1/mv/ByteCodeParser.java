package tp.pr1.mv;

public class ByteCodeParser {
	private static ENUM_BYTECODE enumByteCode;
	private static ByteCode byteCode;
	
	
	public static ByteCode parse(String line){
		switch (line) {
		case "PUSH":  		byteCode = new ByteCode(enumByteCode.PUSH);
        					break;
		case "LOAD":  		byteCode = new ByteCode(enumByteCode.LOAD);
							break;
		case "STORE": 	 	byteCode = new ByteCode(enumByteCode.STORE);
							break;
		case "ADD":  		byteCode = new ByteCode(enumByteCode.ADD);
							break;
		case "SUB":  		byteCode = new ByteCode(enumByteCode.SUB);
							break;
		case "MUL": 	 	byteCode = new ByteCode(enumByteCode.MUL);
							break;
		case "DIV": 	 	byteCode = new ByteCode(enumByteCode.DIV);
							break;
		case "OUT": 	 	byteCode = new ByteCode(enumByteCode.OUT);
							break;
		case "HALT": 	 	byteCode = new ByteCode(enumByteCode.HALT);
							break;
		}
		return byteCode;
	}
}
