package org.bienestar.cocina.internationalization;

import java.util.ResourceBundle;

public class MessageResource {

	
	private static ResourceBundle bundle;
	
	private MessageResource() {
		
	}
	
	public static String getMessage(String key) {
		if(bundle == null) {
			bundle = ResourceBundle.getBundle("messages");
		}
		String message = bundle.getString(key);
		return message != null ? message : "";
	}
}
