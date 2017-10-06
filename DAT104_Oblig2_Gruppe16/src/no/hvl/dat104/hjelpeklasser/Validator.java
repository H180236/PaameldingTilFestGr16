package no.hvl.dat104.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Digits;

import java.util.*;

public class Validator {
	static final String DIGITS = "[0-9]";
	static final String BOKSTAVER_MED_MELLOMROM = "[a-zA-Z -]";
	static final String BOKSTAVER = "[a-zA-Z������-]";
	static final String STORE_BOKSTAVER = "[A-ZÆØÅ]";

	static List<String> telnums = new ArrayList<String>();

	public static boolean valider(HttpServletRequest request) {

		boolean ok = true;
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String kjonn = request.getParameter("kjonn");
		String telefonnummer = request.getParameter("mobil");

		return (validFornavn(fornavn) && validEtternavn(etternavn) && validKjonn(kjonn) && validTelNum(telefonnummer));
	}

	public static boolean validFornavn(String navn) {
		if (navn == null) {
			return false;
		}
		return navn.matches("^" + STORE_BOKSTAVER + BOKSTAVER_MED_MELLOMROM + "{1,19}");
	}

	public static boolean validEtternavn(String navn) {
		if (navn == null) {
			return false;
		}
		return navn.matches("^" + STORE_BOKSTAVER + BOKSTAVER + "{1,19}");
	}

	public static boolean validTelNum(String num) {
		if (num == null) {
			return false;
		}

		return num.matches("^" + DIGITS + "{8}");
	}

	public static boolean validKjonn(String kjonn) {
		if (kjonn == null) {
			return false;
		}
		return kjonn.matches("[MF]");
	}

}
