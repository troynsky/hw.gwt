package home.work.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;
import home.work.gwt.common.model.User;

/**
 * Created by alexander.minaev on 01.02.2018
 */
public class AddUserEvent extends GwtEvent<AddUserEventHandler> {
    public static Type<AddUserEventHandler> TYPE = new Type<AddUserEventHandler>();

    private User user;

    public AddUserEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<AddUserEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddUserEventHandler handler) {
        handler.onAddUserEventHandler(this);
    }
}
