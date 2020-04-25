package org.krauss.main;

import java.util.Iterator;
import java.util.Stack;

import org.krauss.def.ELanguage;
import org.krauss.def.Triple;
import org.krauss.obj.Triple_English;
import org.krauss.obj.Triple_Portuguese;
import org.krauss.obj.Triple_Spanish;

public class NumberTranslator {
	
	//Triple objects
	private String number;
	private Stack<Triple> tripleStack = new Stack<>();
	private int tripleIndex = 0;
	
	//Singleton pattern
	private static NumberTranslator instance = null;
	private NumberTranslator() {}
	
	//Simple example of using design pattern Singleton
	public static NumberTranslator getInstance() {
		return instance == null ? new NumberTranslator() : instance;
	}
	
	
	public String translate(Long n, ELanguage lang) {

		this.number = String.valueOf(n);

		String finalResult = "";

		// The whole number broken into a big array of chars
		char digitArray[] = number.toCharArray();

		// Each triple that will be pushed into the stack
		char triple[] = new char[] { '0', '0', '0' };

		// Index to control the triple array position
		int index = 2;

		// Fill the stack with Triple objects. Each containing a sequence of three
		// digits starting from the last one up to the first
		for (int i = digitArray.length - 1; i >= 0; i--) {

			triple[index] = digitArray[i];
			index--;

			if (index < 0) {

				tripleStack.push(createTriple(triple, tripleIndex, lang));
				triple = new char[] { '0', '0', '0' };
				index = 2;
				tripleIndex++;

			} else if (i == 0) {

				tripleStack.push(createTriple(triple, tripleIndex, lang));

			}

		}

		Iterator<Triple> itr = tripleStack.iterator();

		// hasNext() returns true if the stack has more elements
		while (itr.hasNext()) {

			finalResult += tripleStack.pop().translateTriple() + " ";

		}

		return finalResult.replaceAll("\\s+", " ");

	}
	
	
	private Triple createTriple(char[] triple, int index, ELanguage lang) {
		Triple t = null;
		
		switch (lang) {
		
		case SPANISH:
			t = new Triple_Spanish(triple, index);
			break;
		case PORTUGUESE:
			t = new Triple_Portuguese(triple, index);
			break;
		default:
			t = new Triple_English(triple, index);
			break;
		}
		
		return t;
	}


	public static void main(String[] args) {
		
		System.out.println(NumberTranslator.getInstance().translate(6252l, ELanguage.ENGLISH));
		
	}
}
