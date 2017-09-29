package no.hvl.dat104.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class InputValidering {
	static List<String> telnums = new ArrayList<String>();
	public static boolean valider(HttpServletRequest request) {
		telnums.add("11111111");
		telnums.add("00000000");
		
		boolean ok = true;
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		char kjonn = (char) request.getAttribute("kjonn");
		String telefonnummer = request.getParameter("telefonnummer");
		Boolean betalingsstatus = (boolean)request.getAttribute("betalingsstatus");
		fornavn.replace(" ", "");
		if(fornavn.length()<2 || fornavn.length()>20) {
			ok = false;
		}
		if(etternavn.length()<2 || etternavn.length()>20) {
			ok = false;
		}
		if(kjonn != 'M' &&  kjonn != 'F') {
			ok = false;
		}
		if(telefonnummer.length() != 8) {
			ok = false;
		}
		
		if(inneholderNum(telefonnummer)) {
			ok = false;
		}
	
		return ok;
	}
	
	public static boolean inneholderNum(String tnum){
		boolean inneholder = false;
		for(String num : telnums) {
			if(tnum == num) {
				inneholder = true;
			}
		}
		return inneholder;
	}
}
