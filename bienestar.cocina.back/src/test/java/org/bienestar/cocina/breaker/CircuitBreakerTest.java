package org.bienestar.cocina.breaker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircuitBreakerTest {

	private CircuitBreaker<Sender> breaker;
	
	@Before
	public void setUp() throws Exception {
		breaker = new CircuitBreaker<Sender>("ejemplo", new EjemploSender(), 1, 5000);
	}
	
	@Test
	public void breakerOpen() {
		Message mensaje = new Message();
		breaker = new CircuitBreaker<Sender>("ejemplo",new EjemploSender(), 1, 5000);
		new Thread(breaker).start();
		breaker.addMessage(mensaje);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue("open".equals(breaker.getEstado()));
	}
	
	@Test
	public void breakerHalf() {
		Message mensaje = new Message();
		breaker = new CircuitBreaker<Sender>("ejemplo", new EjemploSender(), 1, 1);
		new Thread(breaker).start();
		breaker.addMessage(mensaje);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue("half".equals(breaker.getEstado()));
	}
}
