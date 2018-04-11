package org.bienestar.cocina.breaker;

import java.util.HashMap;
import java.util.Map;

public class CircuitBreakerRegistry {

	private static CircuitBreakerRegistry instance;
	private Map<String, CircuitBreaker<Sender>> registry = new HashMap<String, CircuitBreaker<Sender>>();

	public static synchronized CircuitBreakerRegistry getInstance() {
		if (instance == null) {
			instance = new CircuitBreakerRegistry();
		}
		return instance;
	}

	public synchronized CircuitBreaker<?> getCircuitBreaker(String name) {
		return registry.get(name);
	}

	public synchronized void register(CircuitBreaker<Sender> breaker) {
		if (!isRegistered(breaker.getNombre())) {
			registry.put(breaker.getNombre(), breaker);
		}
	}
	
	private boolean isRegistered(final String name) {
		return registry.containsKey(name);
	}
}
