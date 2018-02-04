package home.work.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;
import home.work.gwt.common.model.User;

public class EditUserEvent extends GwtEvent<EditUserEventHandler> {

    public static Type<EditUserEventHandler> TYPE = new Type<>();

    private User user;

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<EditUserEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EditUserEventHandler handler) {
        handler.onEditUserEventHandler(this);
    }

    public User getUser() {
        return user;
    }

    public EditUserEvent(User user) {
        this.user = user;
    }
}
