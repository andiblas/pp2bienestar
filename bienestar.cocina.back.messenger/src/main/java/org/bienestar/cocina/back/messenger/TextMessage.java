package org.bienestar.cocina.back.messenger;

public class TextMessage implements Message {

	private String text;

	public String getText() {
		return text;
	}

	public TextMessage(String text) {
		super();
		this.text = text;
	}

}
