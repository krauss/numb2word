package org.krauss.obj;

import java.util.HashMap;

public class Triple {

	private static final HashMap<Integer, String> unit = new HashMap<Integer, String>();
	{
		unit.put(0, "");
		unit.put(1, "one");
		unit.put(2, "two");
		unit.put(3, "three");
		unit.put(4, "four");
		unit.put(5, "five");
		unit.put(6, "six");
		unit.put(7, "seven");
		unit.put(8, "eight");
		unit.put(9, "nine");
	}
	private static final HashMap<Integer, String> ten = new HashMap<Integer, String>();
	{
		ten.put(0, "");
		ten.put(10, "ten");
		ten.put(11, "eleven");
		ten.put(12, "twelve");
		ten.put(13, "thirteen");
		ten.put(14, "fourteen");
		ten.put(15, "fifteen");
		ten.put(16, "sixteen");
		ten.put(17, "seventeen");
		ten.put(18, "eighteen");
		ten.put(19, "nineteen");
		ten.put(2, "twenty");
		ten.put(3, "thirty");
		ten.put(4, "forty");
		ten.put(5, "fifty");
		ten.put(6, "sixty");
		ten.put(7, "seventy");
		ten.put(8, "eigthy");
		ten.put(9, "ninety");
	}
	private static final HashMap<Integer, String> size = new HashMap<Integer, String>();
	{
		size.put(1, "thousand");
		size.put(2, "million");
		size.put(3, "billion");
		size.put(4, "trillion");
		size.put(5, "quadrillion");
		size.put(6, "quintillion");
		size.put(7, "sextilion");
		size.put(8, "setillion");
		size.put(9, "octillion");
		size.put(10, "nonillion");
		size.put(11, "decillion");
	}

	private char[] triple;
	private int tripleIndex;

	public Triple(char[] t, int tIndex) {
		this.triple = t;
		this.tripleIndex = tIndex;
	}

	public String translateTriple() {

		String translatedTriple = "";

		// It can start with zero
		if (triple[0] != '0') {
			translatedTriple += unit.get(Integer.parseInt(triple[0] + "")) + " hundred ";
		}

		//
		if (triple[triple.length - 2] != '0') {

			if (triple[triple.length - 2] == '1') {

				translatedTriple += ten
						.get(Integer.parseInt((triple[triple.length - 2] + "") + triple[triple.length - 1] + "")) + " ";

				// Append thousand, million, or billion an so on
				if (tripleIndex > 0 & !isAllZero()) {

					translatedTriple += size.get(tripleIndex);

				}

				return translatedTriple;

			} else {

				translatedTriple += triple[triple.length - 2] == '0' ? ""
						: ten.get(Integer.parseInt(triple[triple.length - 2] + "")) + " ";

			}

		}

		if (triple[triple.length - 1] != '0') {

			translatedTriple += unit.get(Integer.parseInt(triple[triple.length - 1] + "")) + " ";

		}

		// Append thousand, million, or billion an so on
		if (tripleIndex > 0 & !isAllZero()) {

			translatedTriple += size.get(tripleIndex);

		}

		return translatedTriple;
	}

	// True if all the digits within the Triple are ZERO
	private boolean isAllZero() {
		return triple[0] == '0' & triple[1] == '0' & triple[2] == '0';
	}

}
