package home.work.gwt.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import home.work.gwt.client.controller.WebAppController;
import home.work.gwt.client.model.UserModelHandler;
import home.work.gwt.client.resource.ApplicationResources;
import home.work.gwt.client.resource.Messages;
import home.work.gwt.client.ui.MainPanel;

@GinModules(GwtWebAppGinModule.class)
public interface GwtWebAppGinjector extends Ginjector {

    SimpleEventBus getEventBus();

    ApplicationResources getApplicationResources();

    Messages getMessages();

    WebAppController getWebAppController();

    UserModelHandler getUserModelHandler();

    MainPanel getMainPanel();
}
