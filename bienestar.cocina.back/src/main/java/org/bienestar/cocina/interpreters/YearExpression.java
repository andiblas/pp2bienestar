package org.bienestar.cocina.interpreters;

import java.util.Calendar;

public class YearExpression implements Expression{

	@Override
	public void interpret(DateContext contexto) {
		String[] splitted = contexto.getExpression().split("/");
		if(splitted[3] == null){
			Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
			//TODO revisar si hace falta redimensionar el array
			splitted[3] = currentYear.toString();
		}
		contexto.setExpression(splitted.toString());
	}

}
