package org.krauss.main;

import java.util.Scanner;

import org.krauss.def.ELanguage;

public class MainConsole {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String input = "";
		String number_regex = "^[1-9]\\d+$"; //Make sure the number doesn't start with 0.
		ELanguage lang = null;
		Long number = 0l;
		boolean isLanguagePicked = false;
		
		System.out.println("+------------------------------+");
		System.out.println("|                              |");
		System.out.println("|     Welcome to NuToWor!      |");
		System.out.println("|                              |");
		System.out.println("|  A simple number translator  |");
		System.out.println("|                              |");
		System.out.println("+------------------------------+");
		System.out.println();
		System.out.println("1. Choose a language");
		System.out.println();
		System.out.println("[1] - English\n[2] - Spanish\n[3] - Portuguese\n");
		
		do {
			
			System.out.print("Language [ 1 | 2 | 3 ]: ");		
			input = in.nextLine();
			Integer language = Integer.parseInt(input);
			
			if (language == 1) {
				lang = ELanguage.ENGLISH;
				isLanguagePicked = true;
			} else if (language == 2) {
				lang = ELanguage.SPANISH;
				isLanguagePicked = true;
			} else if (language == 3) {
				lang = ELanguage.PORTUGUESE;
				isLanguagePicked = true;
			}
			
		} while (isLanguagePicked == false);
			
		System.out.println();
		System.out.println();
		do {
			
			System.out.print("2. Type a whole number (Up to 18 digits): ");
			input = in.nextLine();
			number = Long.parseLong(input);
			
		} while (!input.matches(number_regex));
		
		
		System.out.println();
		System.out.println("3. Result: "+NumberTranslator.getInstance().translate(number, lang));
		System.out.println();
		in.close();
	}

}
