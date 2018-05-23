package org.bienestar.cocina.repository;

import org.bienestar.cocina.preparation.PreparationRepository;

public class RepositoryStore {
	
	private static RepositoryStore _instance;
	
	private RepositoryStore() {	}
	
	public static RepositoryStore getInstance() {
		if (_instance == null)
			_instance = new RepositoryStore();
		return _instance;
	}
	
	public PreparationRepository getPreparationRepository() {
		return new PreparationRepository();
	}
	
}
