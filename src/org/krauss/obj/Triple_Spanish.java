package org.krauss.obj;

import java.util.HashMap;

import org.krauss.def.Triple;

public class Triple_Spanish extends Triple{

	private static final HashMap<Integer, String> unidad = new HashMap<Integer, String>();
	{
		unidad.put(0, "");
		unidad.put(1, "uno");
		unidad.put(2, "dos");
		unidad.put(3, "tres");
		unidad.put(4, "cuatro");
		unidad.put(5, "cinco");
		unidad.put(6, "seis");
		unidad.put(7, "siete");
		unidad.put(8, "ocho");
		unidad.put(9, "nueve");
	}
	private static final HashMap<Integer, String> diez = new HashMap<Integer, String>();
	{
		diez.put (0, "");
		diez.put (10, "diez");
		diez.put (11, "once");
		diez.put (12, "doce");
		diez.put (13, "trece");
		diez.put (14, "catorce");
		diez.put (15, "quize");
		diez.put (16, "dieciséis");
		diez.put (17, "diecisiete");
		diez.put (18, "dieciocho");
		diez.put (19, "diecinueve");
		diez.put (2, "veinte");
		diez.put (3, "treinta");
		diez.put (4, "cuarenta");
		diez.put (5, "cincuenta");
		diez.put (6, "sesenta");
		diez.put (7, "setenta");
		diez.put (8, "ochenta");
		diez.put (9, "noventa");
	}
	private static final HashMap<Integer, String> cien = new HashMap<Integer, String>();
	{
		cien.put (0, "");
		cien.put (1, "cien");
		cien.put (2, "doscientos");
		cien.put (3, "trescientos");
		cien.put (4, "cuatrocientos");
		cien.put (5, "quinientos");
		cien.put (6, "seiscientos");
		cien.put (7, "setecientos");
		cien.put (8, "ochocientos");
		cien.put (9, "novecientos");
	}
	
	private static final HashMap<Integer, String> milhar = new HashMap<Integer, String>();
	{
		milhar.put (1, "mil");
		milhar.put (2, "millón");
		milhar.put (3, "billón");
		milhar.put (4, "trillón");
		milhar.put (5, "cuatrillón");
		milhar.put (6, "quintillón");
		milhar.put (7, "sextillón");
		milhar.put (8, "septillón");
		milhar.put (9, "octillón");
		milhar.put (10, "nonillón");
		milhar.put (11, "decillón");
	}

	public Triple_Spanish(char[] t, int tIndex) {
		triple = t;
		tripleIndex = tIndex;
	}

	public String translateTriple() {

		String translatedTriple = "";

		// It can start with zero
		if (triple[0] != '0') {
			
			if (triple[0] == '1' && !isTwoZero()) {
				
				translatedTriple += "ciento y ";
				
			} else if (triple[0] != '1' && !isTwoZero()) {
				
				translatedTriple += cien.get(Integer.parseInt(triple[0] + "")) + " y ";
				
			} else {
				
				translatedTriple += cien.get(Integer.parseInt(triple[0] + "")) + " ";
				
			}
		}

		//
		if (triple[triple.length - 2] != '0') {

			if (triple[triple.length - 2] == '1') {

				translatedTriple += diez
						.get(Integer.parseInt((triple[triple.length - 2] + "") + triple[triple.length - 1] + "")) + " ";

				// Append thousand, million, or billion an so on
				if (tripleIndex > 0 & !isAllZero()) {

					if (triple[triple.length - 2] == '1') {
						
						translatedTriple += milhar.get(tripleIndex);
						
					} else {
						
						translatedTriple += (milhar.get(tripleIndex)).replaceAll("ón", "ones");
						
					}

				}

				return translatedTriple;

			} else {
				
				if (triple[triple.length - 2] != '0' && (triple[triple.length - 1] != '0')) {
					
					translatedTriple += diez.get(Integer.parseInt(triple[triple.length - 2] + "")) + " y ";
					
				} else {
					
					translatedTriple += diez.get(Integer.parseInt(triple[triple.length - 2] + "")) + " ";

				}
			
			}

		}

		if (triple[triple.length - 1] != '0') {

			translatedTriple += unidad.get(Integer.parseInt(triple[triple.length - 1] + "")) + " ";

		}

		// Append thousand, million, or billion an so on
		if (tripleIndex > 0 & !isAllZero()) {
			
			
			if (triple[triple.length - 1] == '1') {
				
				translatedTriple += milhar.get(tripleIndex);				
				
			} else {
				
				translatedTriple += (milhar.get(tripleIndex)).replaceAll("ón", "ones");
				
			}
			
			

		}

		return translatedTriple;
	}
	
	//This method is only used for hundred, because '100' is translated to 'cem' while '101' is tranlated to 'cento e um'
	private boolean isTwoZero() {
		return triple[1] == '0' & triple[2] == '0';
	}

}
