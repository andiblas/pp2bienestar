package org.bienestar.cocina.controller.navigation;

import java.util.HashMap;

import org.bienestar.cocina.controller.ConsumptionRegisterController;
import org.bienestar.cocina.controller.ExportFileController;
import org.bienestar.cocina.view.ConsumptionRegisterPage;
import org.bienestar.cocina.view.ExportFilePage;

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
				ConsumptionRegisterPage page = new ConsumptionRegisterPage();
				ConsumptionRegisterController controller = new ConsumptionRegisterController(page);
				page.setVisible(true);
			}
		});
		navigationActionMap.put(ActionRequest.EXPORT_TO_FILE, new NavigationAction() {
			public void OnNavigationAction(ApplicationContext ctx) {
				ExportFilePage page = new ExportFilePage();
				ExportFileController controller = new ExportFileController(page);
				page.setVisible(true);
			}
		});
		
	}
	
	public void navigate(ApplicationContext appCtx) {
		if (appCtx == null)
			throw new IllegalArgumentException("appCtx cannot be null");
		
		navigationActionMap.get(appCtx.getActionReq()).OnNavigationAction(appCtx);
	}
	
	
}
