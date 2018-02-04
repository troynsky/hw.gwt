package home.work.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;
import home.work.gwt.client.event.DeleteUserEvent;
import home.work.gwt.client.event.EditUserEvent;
import home.work.gwt.client.ui.component.ImageButton;
import home.work.gwt.common.model.User;

public class UserWidget extends Composite {

    private static TodoWidgetUiBinder uiBinder = GWT
            .create(TodoWidgetUiBinder.class);

    interface TodoWidgetUiBinder extends UiBinder<Widget, UserWidget> {
    }

    private User currentUser;

    private SimpleEventBus _eventBus;

    public UserWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public UserWidget(User user, SimpleEventBus eventBus) {
        _eventBus = eventBus;
        initWidget(uiBinder.createAndBindUi(this));
        this.currentUser = user;
        textBox.setText(user.getName() + user.getBirthday());
    }

    @UiField
    ImageButton deleteButton;

    @UiField
    ImageButton editButton;

    @UiField
    InlineLabel textBox;

    @UiHandler("deleteButton")
    void onAddButtonClick(ClickEvent e) {
        boolean confirm = Window.confirm("Delete " + currentUser.getName() + " ?");
        if (confirm) {
            _eventBus.fireEvent(new DeleteUserEvent(currentUser));
        }
    }

    @UiHandler("editButton")
    void onEditButtonClick(ClickEvent e) {
        _eventBus.fireEvent(new EditUserEvent(currentUser));
    }

}
