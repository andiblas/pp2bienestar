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
	private SubscriberService(String path) {
		consumptionLoader = IntegrationServiceLoader.loadIntegrations(Paths.get(path), ConsumptionSubscriber.class);
	}

	/**
	 * Devuelve la instancia actual
	 */
	public static synchronized SubscriberService getInstance(String path) {
		if (service == null) {
			service = new SubscriberService(path);
		}
		return service;
	}

	/**
	 * Devuelve una nueva instancia
	 */
	public static synchronized SubscriberService getNewInstance(String path) {
		service = new SubscriberService(path);
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
