package org.bienestar.cocina.interpreters;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

public class MonthExpression implements Expression{

	@Override
	public void interpret(DateContext contexto) {
		String[] splitted = contexto.getExpression().split("/");
		if(splitted[2] == null){
			Integer currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
			//TODO revisar si hace falta redimensionar el array
			splitted[2] = currentMonth.toString();
		} else if(!StringUtils.isNumeric(splitted[2])){
			splitted[2] = convertToMonth(splitted[2]);
		}
		contexto.setExpression(splitted.toString());
	}

	private String convertToMonth(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
