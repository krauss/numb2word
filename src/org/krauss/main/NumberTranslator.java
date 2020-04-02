package org.krauss.main;

import java.util.HashMap;

public class NumberTranslator {

	private final HashMap<Integer, String> unit = new HashMap<Integer, String>();
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
	private final HashMap<Integer, String> ten = new HashMap<Integer, String>();
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

	private final HashMap<Integer, String> size = new HashMap<Integer, String>();
	{
		size.put(3, "hundred");
		size.put(4, "thousand");
		size.put(5, "thousand");
		size.put(6, "hundread thousand");
		size.put(7, "million");
		size.put(8, "million");
		size.put(9, "hundred million");
		size.put(10, "billion");
		size.put(11, "billion");
		size.put(12, "hundred billion");
		size.put(13, "trillion");
	}

	private String number;
	private String translatedNum = "";

	public NumberTranslator(Integer number) {
		this.number = String.valueOf(number);
	}

	public String translate() {

		char tmp[] = number.toCharArray();
		
		int decimalIndex = 0;
		int digit = 1;
		
		for (int i = tmp.length; i > 0; i--) {
			
			if (decimalIndex == 0) {
				
				translatedNum = " " + unit.get(Integer.parseInt(tmp[i-1]+"")) + translatedNum;
				
				decimalIndex++;
				
			} else if (decimalIndex == 1 ) {
				
				if (Integer.parseInt((tmp[i-1]+"")) == 1) {
					
					//Save the previous digit
					char previous = tmp[i];
					//Remove it from the string
					translatedNum = translatedNum.replaceFirst(unit.get(Integer.parseInt(tmp[i]+"")), "");
					//Append the previous char with the current string
					translatedNum = " " + ten.get(Integer.parseInt((tmp[i-1]+"") + previous)) + translatedNum;					
					
				} else {
					
					translatedNum = tmp[i-1] == '0' ? ten.get(Integer.parseInt(tmp[i-1]+"")) + translatedNum : " " + ten.get(Integer.parseInt(tmp[i-1]+"")) + translatedNum;
				}

				decimalIndex++;
				
			} else {				
				
				translatedNum = " " + size.get(digit) + translatedNum;
				translatedNum = " " + unit.get(Integer.parseInt(tmp[i-1]+"")) + translatedNum ;
				
				decimalIndex = 0;
			}
			digit++;
			
		}
		
		return translatedNum.trim();
	}

	public static void main(String[] args) {

		NumberTranslator nb = new NumberTranslator(459);
		System.out.println(nb.translate());

	}

}
