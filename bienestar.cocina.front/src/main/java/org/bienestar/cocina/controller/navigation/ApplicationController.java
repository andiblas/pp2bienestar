package org.bienestar.cocina.controller.navigation;

import java.util.HashMap;

public class ApplicationController {

	private HashMap<ActionRequest, NavigationAction> navigationActionMap = new HashMap<ActionRequest, NavigationAction>();
	private static ApplicationController _instance;
	
	public static ApplicationController getInstance() {
		if (_instance == null)
			_instance = new ApplicationController();
		return _instance;
	}
	
	private ApplicationController() {
		navigationActionMap.put(ActionRequest.NEW_CONSUMPTION_REGISTRATION, new NavigationAction() {
			public void OnNavigationAction(ApplicationContext ctx) {
				
			}
		});
		navigationActionMap.put(ActionRequest.EXPORT_TO_FILE, new NavigationAction() {
			public void OnNavigationAction(ApplicationContext ctx) {
				
			}
		});
		
	}
	
	public void navigate(ApplicationContext appCtx) {
		if (appCtx == null)
			throw new IllegalArgumentException("appCtx");
		
		navigationActionMap.get(appCtx.getActionReq()).OnNavigationAction(appCtx);
	}
	
	
}
