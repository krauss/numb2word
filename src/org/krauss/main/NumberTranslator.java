package org.krauss.main;

import java.util.Iterator;
import java.util.Stack;
import org.krauss.obj.Triple_English;
import org.krauss.obj.Triple_Portuguese;
import org.krauss.obj.Triple_Spanish;

public class NumberTranslator {

	private String number;
	private Stack<Triple_Spanish> tripleStack = new Stack<>();
	private int tripleIndex = 0;
	
	
	//Singleton pattern
	private static NumberTranslator instance = null;
	private NumberTranslator() {}
	
	//Simple example of using design pattern Singleton
	public static NumberTranslator getInstance() {
		return instance == null ? new NumberTranslator() : instance;
	}

	public String translate(Long n) {
		this.number = String.valueOf(n);

		String finalResult = "";

		// The whole number broken into a big array of chars
		char digitArray[] = number.toCharArray();

		// Each triple that will be pushed into the stack
		char triple[] = new char[]{'0','0','0'};

		// Index to control the triple array position
		int index = 2;

		// Fill the stack with Triple objects. Each containing a sequence of three
		// digits starting from the last one up to the first
		for (int i = digitArray.length - 1; i >= 0; i--) {

			triple[index] = digitArray[i];
			index--;

			if (index < 0) {

				tripleStack.push(new Triple_Spanish(triple, tripleIndex));
				triple = new char[]{'0','0','0'};
				index = 2;
				tripleIndex++;

			} else if (i == 0) {

				tripleStack.push(new Triple_Spanish(triple, tripleIndex));

			}

		}
		
		Iterator<Triple_Spanish> itr = tripleStack.iterator();

		// hasNext() returns true if the stack has more elements
		while (itr.hasNext()){
			
			finalResult += tripleStack.pop().translateTriple() + " ";
			
		}

		return finalResult.replaceAll("\\s+", " ");
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(NumberTranslator.getInstance().translate(46778998l));
		
	}
}
