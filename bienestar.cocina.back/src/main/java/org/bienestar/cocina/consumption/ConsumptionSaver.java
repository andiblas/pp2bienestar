package org.bienestar.cocina.consumption;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.pubsub.MessageBroker;

public class ConsumptionSaver {
	
	public void Save(Consumption consumption) {
		
		//logica para guardar el consumo
		
		MessageBroker.getInstance().publish("CONSUMPTION_SAVED", consumption);
		
	}
	
}
