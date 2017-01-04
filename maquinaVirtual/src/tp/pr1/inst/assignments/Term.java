package tp.pr1.inst.assignments;

import tp.pr1.bitecode.ByteCode;

public interface Term {
	Term parse(String term);
	ByteCode compile(Compiler compiler);
}
