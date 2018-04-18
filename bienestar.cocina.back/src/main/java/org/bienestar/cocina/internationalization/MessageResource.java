package org.bienestar.cocina.internationalization;

import java.util.ResourceBundle;

public class MessageResource {

	private static MessageResource instance;
	
	private ResourceBundle bundle;
	
	private MessageResource(ResourceBundle bundle) {
		this.bundle = bundle;
	}
	
	public static MessageResource getInstance() {
		if(instance == null) {
			instance = new MessageResource(ResourceBundle.getBundle("messages"));
		}
		return instance;
	}
	
	public String getMessage(String key) {
		String message = bundle.getString(key);
		return message != null ? message : "";
	}
}
