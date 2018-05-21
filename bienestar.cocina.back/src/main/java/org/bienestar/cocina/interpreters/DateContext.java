package org.bienestar.cocina.interpreters;

public class DateContext {

	private String expression;
	
	public DateContext(String expression) {
		this.expression = expression;
	}
	
	public String getExpression(){
		return expression;
	}
	
	public void setExpression(String expression){
		this.expression = expression;
	}
}
