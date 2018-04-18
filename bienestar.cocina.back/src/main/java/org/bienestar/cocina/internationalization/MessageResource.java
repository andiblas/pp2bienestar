package org.bienestar.cocina.internationalization;

import java.util.MissingResourceException;
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
		String message;
		try {
			message = bundle.getString(key);
			
		} catch (MissingResourceException e) {
			message = "";
		}
		return message;
	}
}
