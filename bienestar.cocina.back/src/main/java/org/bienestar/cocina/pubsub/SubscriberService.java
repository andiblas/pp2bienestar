package org.bienestar.cocina.pubsub;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import org.bienestar.cocina.service.loader.IntegrationServiceLoader;

public class SubscriberService {

	private static SubscriberService service;
	private ServiceLoader<ConsumptionSubscriber> consumptionLoader;

	/**
	 * Creates a new instance of SubscriberService
	 */
	private SubscriberService() {
		consumptionLoader = IntegrationServiceLoader.loadIntegrations(Paths.get("C:\\Users\\Leandro\\Documents\\bienestarPP2\\bienestar.cocina.back.messenger\\target"), ConsumptionSubscriber.class);
	}

	/**
	 * Retrieve the singleton static instance of SubscriberService.
	 */
	public static synchronized SubscriberService getInstance() {
		if (service == null) {
			service = new SubscriberService();
		}
		return service;
	}

	public void subscribe() {
		try {
			Iterator<ConsumptionSubscriber> suscriberIterator = consumptionLoader.iterator();
			while (suscriberIterator.hasNext()) {
				ConsumptionSubscriber plugin = suscriberIterator.next();
				PublishSubscribe.getInstance().subscribe(SubscriptionTypes.CONSUMPTION.getType(), plugin.getSubscriber());
			}
		} catch (ServiceConfigurationError e) {
			e.printStackTrace();
		}
	}
}
