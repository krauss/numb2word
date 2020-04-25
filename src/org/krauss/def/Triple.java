package org.krauss.def;


public abstract class Triple {

	protected char[] triple;
	protected int tripleIndex;

	public abstract String translateTriple();
	
	protected boolean isAllZero() {
		return triple[0] == '0' & triple[1] == '0' & triple[2] == '0';
	}
	
}
