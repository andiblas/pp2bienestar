package org.bienestar.cocina.interpreters;

import org.apache.commons.lang3.StringUtils;

public class DayExpression implements Expression {

	@Override
	public void interpret(DateContext contexto) {
		String[] splitted = contexto.getExpression().split("/");
		splitted[0] = StringUtils.rightPad(splitted[0], 2, "0");
		contexto.setExpression(splitted.toString());
	}

}
