package org.bienestar.cocina.pubsub;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageBroker {

	private static MessageBroker instance;
	
	private MessageBroker() {}
	
	public static MessageBroker getInstance() {
		if (instance == null) {
			instance = new MessageBroker();
		}
		return instance;
	}
	
	private HashMap<String, ArrayList<Subscriber>> subscriptions = new HashMap<String, ArrayList<Subscriber>>();

	public void subscribe(String topic, Subscriber subscriber) {
		if (subscriptions.containsKey(topic)) {
			subscriptions.get(topic).add(subscriber);
		} else {
			ArrayList<Subscriber> subscriberList = new ArrayList<Subscriber>();
			subscriberList.add(subscriber);
			subscriptions.put(topic, subscriberList);
		}
	}

	public void send(String topic, Object message) {
		if (!subscriptions.containsKey(topic))
			return;

		for (Subscriber subscriber : subscriptions.get(topic)) {
			subscriber.onMessageReceived(message);
		}
	}

	public void unsubscribe(String topic, Subscriber subscriber) {
		if (!subscriptions.containsKey(topic))
			return;
		subscriptions.get(topic).remove(subscriber);
	}

}
