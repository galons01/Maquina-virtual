package tp.pr1.inst.conditionals;

import tp.pr1.elements.LexicalParser;

public class ConditionParser {
	private final static Condition[]
			 conditions={new Less(), new LessEq(), new Equal(), new NotEqual()};

	public static Condition parse(String string, String string2, String string3, LexicalParser lexParser) {
		
		for(int i=0; i<conditions.length; i++){
			if(conditions[i].parse(string, string2, string3, lexParser)!=null){
				return conditions[i].parse(string, string2, string3, lexParser);
			}
		}
		
		return null;
	}
}
