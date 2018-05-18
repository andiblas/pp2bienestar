package org.bienestar.cocina.plugin;

import org.bienestar.cocina.pubsub.PublishSubscribe;
import org.bienestar.cocina.pubsub.SubscriberService;
import org.bienestar.cocina.pubsub.SubscriptionTypes;
import org.junit.Test;

public class ConsumptionSuscriberTest {

	@Test
	public void subscribe(){
		SubscriberService plugin = SubscriberService.getInstance();
		plugin.subscribe();
		PublishSubscribe.getInstance().publish(SubscriptionTypes.CONSUMPTION.getType(), "Ale gato");
	}
}
