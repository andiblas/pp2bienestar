package org.bienestar.cocina.pubsub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageBrokerTests {

	@Before
	public void setUp() {
	}
	
	@Test()
	public void subscriptionTest()  {
		MessageBroker.getInstance().subscribe("TOPIC", new Subscriber() {
			public void onMessageReceived(Object message) {
				Assert.assertEquals(new Integer(1), (Integer) message);
			}
		});
		MessageBroker.getInstance().publish("TOPIC", new Integer(1));
	}
	
	@Test()
	public void multipleSubscriptionTest()  {
		MessageBroker.getInstance().subscribe("TOPIC", new Subscriber() {
			public void onMessageReceived(Object message) {
				Assert.assertEquals(new Integer(1), (Integer) message);
			}
		});
		MessageBroker.getInstance().subscribe("TOPIC", new Subscriber() {
			public void onMessageReceived(Object message) {
				Assert.assertEquals(new Integer(1), (Integer) message);
			}
		});
		MessageBroker.getInstance().publish("TOPIC", new Integer(1));
	}
	
}
