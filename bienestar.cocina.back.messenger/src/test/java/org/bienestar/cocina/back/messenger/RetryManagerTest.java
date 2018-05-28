package org.bienestar.cocina.back.messenger;

import static org.junit.Assert.assertEquals;

import org.bienestar.cocina.back.messenger.RetryManager;
import org.junit.Test;

public class RetryManagerTest {

	@Test
	public void FailedMessage1() {
		RetryManager retryManager = new RetryManager();
		Message msg = new TextMessage("texto");
		retryManager.onError(msg);
		FailedMessageEntry entry = retryManager.getTable().get(0);
		assertEquals(msg, entry.getMessage());
		assertEquals(1, entry.getQuantity());
	}

	@Test
	public void FailedMessage2() {
		RetryManager retryManager = new RetryManager();
		Message msg = new TextMessage("texto");
		retryManager.onError(msg);
		retryManager.onError(msg);
		FailedMessageEntry entry = retryManager.getTable().get(0);
		assertEquals(msg, entry.getMessage());
		assertEquals(2, entry.getQuantity());
	}
	
	@Test
	public void FailedMessage5() {
		RetryManager retryManager = new RetryManager();
		Message msg = new TextMessage("texto");
		retryManager.onError(msg);
		retryManager.onError(msg);
		retryManager.onError(msg);
		retryManager.onError(msg);
		retryManager.onError(msg);
		FailedMessageEntry entry = retryManager.getTable().get(0);
		assertEquals(msg, entry.getMessage());
		assertEquals(5, entry.getQuantity());
	}
	

}
