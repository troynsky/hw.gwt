package home.work.gwt.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import home.work.gwt.client.controller.WebAppController;
import home.work.gwt.client.model.UserModelHandler;
import home.work.gwt.client.resource.ApplicationResources;
import home.work.gwt.client.resource.Messages;
import home.work.gwt.client.ui.MainPanel;

public class GwtWebAppGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        // Resources
        bind(Messages.class).in(Singleton.class);
        bind(ApplicationResources.class).in(Singleton.class);

        // Core
        bind(SimpleEventBus.class).in(Singleton.class);
        bind(WebAppController.class).in(Singleton.class);
        bind(UserModelHandler.class).in(Singleton.class);

        // UI
        bind(MainPanel.class).in(Singleton.class);
//        bind(AddUserForm.class).in(Singleton.class);
    }

}
