package org.bienestar.cocina.back.senders;

import java.util.List;

import org.apache.http.NameValuePair;
import org.bienestar.cocina.back.messenger.Message;
import org.bienestar.cocina.exceptions.SendingException;

public class HttpSender implements Sender<Message<List<NameValuePair>>>{

	private String urlService;
	
	public HttpSender(String urlService) {
		this.urlService = urlService;
	}
	
	@Override
	public void send(Message<List<NameValuePair>> message) throws SendingException {
		if(urlService == null){
			throw new SendingException();
		}
		return;

	}

}
