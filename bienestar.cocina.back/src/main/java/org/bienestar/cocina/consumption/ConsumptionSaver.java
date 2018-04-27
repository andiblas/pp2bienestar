package org.bienestar.cocina.consumption;

import org.bienestar.cocina.domain.Consumption;
import org.bienestar.cocina.pubsub.PublishSubscribe;

public class ConsumptionSaver {
	
	public void Save(Consumption consumption) {
		
		//logica para guardar el consumo
		
		PublishSubscribe.getInstance().publish("CONSUMPTION_SAVED", consumption);
		
	}
	
}
