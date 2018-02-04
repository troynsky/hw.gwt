package home.work.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import home.work.gwt.client.model.UserModelHandler;
import home.work.gwt.client.ui.component.ImageButton;
import home.work.gwt.common.model.User;

import java.util.HashMap;
import java.util.Map;

public class MainPanel extends Composite {

    private static MainPanelUiBinder uiBinder = GWT.create(MainPanelUiBinder.class);

    interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
    }

    Map<String, UserWidget> _userWidgets;

    private SimpleEventBus _eventBus;

    private UserModelHandler _userModelHandler;

    private AddUserForm _userWidget;

    @UiField
    ImageButton addButton;

    @UiField
    FlowPanel todoPanel;

    @Inject
    public MainPanel(SimpleEventBus eventBus, UserModelHandler userModelHandler, AddUserForm userWidget) {
        _eventBus = eventBus;
        _userModelHandler = userModelHandler;
        _userWidget = userWidget;
        // init display
        initWidget(uiBinder.createAndBindUi(this));
        _userWidgets = new HashMap<>();

    }

    @UiHandler("addButton")
    void onAddButtonClick(ClickEvent e) {
        _userWidget.init();
    }

    public void addUserToPanel(User user) {
        if (_userWidgets.get(user.getName()) == null) {
            UserWidget w = new UserWidget(user, _eventBus);
            todoPanel.add(w);
            _userWidgets.put(user.getName(), w);
        } else {
            Window.alert("Already existing User : " + user.getName());
        }
    }

    public void removeUserFromPanel(User user) {
        UserWidget userWidget = _userWidgets.get(user.getName());
        todoPanel.remove(userWidget);
        _userWidgets.remove(user.getName());
    }

}
