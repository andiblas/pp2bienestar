package org.bienestar.cocina.breaker;

public interface CircuitBreakerCommand {
	void execute() throws Exception;
}
