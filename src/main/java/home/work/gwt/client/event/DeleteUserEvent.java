package home.work.gwt.client.event;

import com.google.gwt.event.shared.GwtEvent;
import home.work.gwt.common.model.User;

public class DeleteUserEvent extends GwtEvent<DeleteUserEventHandler> {

    public static Type<DeleteUserEventHandler> TYPE = new Type<>();

    private User user;

    public User getUser() {
        return user;
    }

    public DeleteUserEvent(User user) {
        this.user = user;
    }

    @Override
    protected void dispatch(DeleteUserEventHandler handler) {
        handler.onDeleteUserEventHandler(this);
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<DeleteUserEventHandler> getAssociatedType() {
        return TYPE;
    }

}