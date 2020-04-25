package org.krauss.obj;

import java.util.HashMap;

import org.krauss.def.Triple;

public class Triple_Portuguese extends Triple{

	private static final HashMap<Integer, String> unidade = new HashMap<Integer, String>();
	{
		unidade.put(0, "");
		unidade.put(1, "um");
		unidade.put(2, "dois");
		unidade.put(3, "três");
		unidade.put(4, "quatro");
		unidade.put(5, "cinco");
		unidade.put(6, "seis");
		unidade.put(7, "sete");
		unidade.put(8, "oito");
		unidade.put(9, "nove");
	}
	private static final HashMap<Integer, String> dezena = new HashMap<Integer, String>();
	{
		dezena.put(0, "");
		dezena.put(10, "dez");
		dezena.put(11, "onze");
		dezena.put(12, "doze");
		dezena.put(13, "treze");
		dezena.put(14, "quatorze");
		dezena.put(15, "quize");
		dezena.put(16, "dezesseis");
		dezena.put(17, "dezessete");
		dezena.put(18, "dezoito");
		dezena.put(19, "dezenove");
		dezena.put(2, "vinte");
		dezena.put(3, "trinta");
		dezena.put(4, "quarenta");
		dezena.put(5, "cinquenta");
		dezena.put(6, "sessenta");
		dezena.put(7, "setenta");
		dezena.put(8, "oitenta");
		dezena.put(9, "noventa");
	}
	private static final HashMap<Integer, String> centena = new HashMap<Integer, String>();
	{
		centena.put(0, "");
		centena.put(1, "cem");
		centena.put(2, "duzentos");
		centena.put(3, "trezentos");
		centena.put(4, "quatrocentos");
		centena.put(5, "quinhentos");
		centena.put(6, "seiscentos");
		centena.put(7, "setecentos");
		centena.put(8, "oitocentos");
		centena.put(9, "novecentos");
	}
	
	private static final HashMap<Integer, String> milhar = new HashMap<Integer, String>();
	{
		milhar.put(1, "mil");
		milhar.put(2, "milhão");
		milhar.put(3, "bilhão");
		milhar.put(4, "trilhão");
		milhar.put(5, "quatrilhão");
		milhar.put(6, "quintilhão");
		milhar.put(7, "sextilhão");
		milhar.put(8, "septilhão");
		milhar.put(9, "octilhão");
		milhar.put(10, "nonilhão");
		milhar.put(11, "decilhão");
	}

	public Triple_Portuguese(char[] t, int tIndex) {
		triple = t;
		tripleIndex = tIndex;
	}

	public String translateTriple() {

		String translatedTriple = "";

		// It can start with zero
		if (triple[0] != '0') {
			
			if (triple[0] == '1' && !isTwoZero()) {
				
				translatedTriple += "cento e ";
				
			} else if (triple[0] != '1' && !isTwoZero()) {
				
				translatedTriple += centena.get(Integer.parseInt(triple[0] + "")) + " e ";
				
			} else {
				
				translatedTriple += centena.get(Integer.parseInt(triple[0] + "")) + " ";
				
			}
		}

		//
		if (triple[triple.length - 2] != '0') {

			if (triple[triple.length - 2] == '1') {

				translatedTriple += dezena
						.get(Integer.parseInt((triple[triple.length - 2] + "") + triple[triple.length - 1] + "")) + " ";

				// Append thousand, million, or billion an so on
				if (tripleIndex > 0 & !isAllZero()) {

					if (triple[triple.length - 2] == '1') {
						
						translatedTriple += milhar.get(tripleIndex);
						
					} else {
						
						translatedTriple += (milhar.get(tripleIndex)).replaceAll("ão", "ões");
						
					}

				}

				return translatedTriple;

			} else {
				
				if (triple[triple.length - 2] != '0' && (triple[triple.length - 1] != '0')) {
					
					translatedTriple += dezena.get(Integer.parseInt(triple[triple.length - 2] + "")) + " e ";
					
				} else {
					
					translatedTriple += dezena.get(Integer.parseInt(triple[triple.length - 2] + "")) + " ";

				}
			
			}

		}

		if (triple[triple.length - 1] != '0') {

			translatedTriple += unidade.get(Integer.parseInt(triple[triple.length - 1] + "")) + " ";

		}

		// Append thousand, million, or billion an so on
		if (tripleIndex > 0 & !isAllZero()) {
			
			
			if (triple[triple.length - 1] == '1') {
				
				translatedTriple += milhar.get(tripleIndex);				
				
			} else {
				
				translatedTriple += (milhar.get(tripleIndex)).replaceAll("ão", "ões");
				
			}
			
			

		}

		return translatedTriple;
	}
	
	//This method is only used for hundred, because '100' is translated to 'cem' while '101' is tranlated to 'cento e um'
	private boolean isTwoZero() {
		return triple[1] == '0' & triple[2] == '0';
	}

}
