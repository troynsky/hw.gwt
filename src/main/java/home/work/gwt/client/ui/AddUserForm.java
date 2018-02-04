package home.work.gwt.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.inject.Inject;
import home.work.gwt.client.event.AddUserEvent;
import home.work.gwt.common.model.User;

public class AddUserForm extends DialogBox {

    private SimpleEventBus _eventBus;

    private TextBox name = new TextBox();
    private DateBox date = new DateBox();

    @Inject
    public AddUserForm(SimpleEventBus eventBus) {
        _eventBus = eventBus;
    }

    public void init() {
        center();
        setText("Add user");
        setAnimationEnabled(true);

        Button add_user = new Button("Add");
        Button closeModal = new Button("Close");

        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new Label("User name"));
        dialogVPanel.add(name);
        dialogVPanel.add(new Label("Birthday"));
        dialogVPanel.add(date);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
        dialogVPanel.add(add_user);
        dialogVPanel.add(closeModal);
        setWidget(dialogVPanel);

        add_user.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event1) {
                User user = prepareUser();
                _eventBus.fireEvent(new AddUserEvent(user));
                hide();
            }
        });

        closeModal.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                name.setText("");
                date.setValue(null);
                hide();
            }
        });
    }

    private User prepareUser() {
        User user = new User(this.name.getText(), this.date.getValue());
        this.name.setText("");
        this.date.setValue(null);

        return user;
    }

}
