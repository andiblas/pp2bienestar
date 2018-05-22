package org.bienestar.cocina.interpreters;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class MonthExpression implements Expression {

	public MonthExpression() {
		monthDictionary = new HashMap<>();
		monthDictionary.put("enero", "01");
		monthDictionary.put("febrero", "02");
		monthDictionary.put("marzo", "03");
		monthDictionary.put("abril", "04");
		monthDictionary.put("mayo", "05");
		monthDictionary.put("junio", "06");
		monthDictionary.put("julio", "07");
		monthDictionary.put("agosto", "08");
		monthDictionary.put("septiembre", "09");
		monthDictionary.put("octubre", "10");
		monthDictionary.put("noviembre", "11");
		monthDictionary.put("diciembre", "12");
		monthDictionary.put("ene", "01");
		monthDictionary.put("feb", "02");
		monthDictionary.put("mar", "03");
		monthDictionary.put("abr", "04");
		monthDictionary.put("may", "05");
		monthDictionary.put("jun", "06");
		monthDictionary.put("jul", "07");
		monthDictionary.put("ago", "08");
		monthDictionary.put("sep", "09");
		monthDictionary.put("oct", "10");
		monthDictionary.put("nov", "11");
		monthDictionary.put("dic", "12");
	}
	
	@Override
	public void interpret(DateContext contexto) {
		if (contexto.getMonth() == null) {
			Integer currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
			contexto.setMonth(currentMonth.toString());
		} else if (!StringUtils.isNumeric(contexto.getMonth())) {
			contexto.setMonth(this.convertToMonth(contexto.getMonth()));
		}
	}

	private String convertToMonth(String month) {
		String lowerCaseMonth = month.toLowerCase();
		return monthDictionary.get(lowerCaseMonth);
	}

	private Map<String, String> monthDictionary;
}
