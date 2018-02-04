package home.work.gwt.client.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import home.work.gwt.client.event.AddUserEvent;
import home.work.gwt.client.event.AddUserEventHandler;
import home.work.gwt.client.event.DeleteUserEvent;
import home.work.gwt.client.event.DeleteUserEventHandler;
import home.work.gwt.client.model.UserModelHandler;
import home.work.gwt.client.ui.MainPanel;
import home.work.gwt.common.model.User;

public class WebAppController {

    private SimpleEventBus _eventBus;

    private UserModelHandler _userModelHandler;

    private MainPanel _mainPanel;

    private final static String pageBaseUrl = GWT.getHostPageBaseURL();
    private final static String restUser = "rest/user";

    @Inject
    public WebAppController(SimpleEventBus eventBus, MainPanel mainPanel, UserModelHandler userModelHandler) {
        _eventBus = eventBus;
        _mainPanel = mainPanel;
        _userModelHandler = userModelHandler;
    }

    public void bindHandlers() {

        _eventBus.addHandler(AddUserEvent.TYPE, new AddUserEventHandler() {
            @Override
            public void onAddUserEventHandler(AddUserEvent event) {
                addUser(event.getUser());
            }
        });

        _eventBus.addHandler(DeleteUserEvent.TYPE, new DeleteUserEventHandler() {
            @Override
            public void onDeleteUserEventHandler(DeleteUserEvent event) {
                deleteUser(event.getUser());
            }
        });

    }

    protected void deleteUser(User user) {
        deleteUserServer(user);
        _userModelHandler.remove(user);
        _mainPanel.removeUserFromPanel(user);
    }

    protected void addUser(User user) {
        saveUser(user);
        _userModelHandler.add(user);
        _mainPanel.addUserToPanel(user);
    }

    private void saveUser(User user) {
        RequestBuilder rb = new RequestBuilder(RequestBuilder.POST, pageBaseUrl + restUser);
        rb.setHeader("Content-type", "application/x-www-form-urlencoded");
        rb.setCallback(new RequestCallback() {

            public void onError(Request request, Throwable e) {
                // some error handling code here
                Window.alert("error = " + e.getMessage());
            }

            public void onResponseReceived(Request request, Response response) {
                if (200 == response.getStatusCode()) {
                    String text = response.getText();
                    System.out.println("text = " + text);
                    Window.alert("response = " + text);
//                    List<User> todoList = JsonHelper.parseDataList(text);
//                    reloadList(todoList);
                }
            }
        });

        try {
            rb.send();
        } catch (RequestException e) {
            e.printStackTrace();
            Window.alert("error = " + e.getMessage());
        }
    }

    private void deleteUserServer(User user) {
        RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, pageBaseUrl + restUser + "?id=" + user.getId());
        rb.setCallback(new RequestCallback() {

            public void onError(Request request, Throwable e) {
                Window.alert("error = " + e.getMessage());
            }

            public void onResponseReceived(Request request, Response response) {
            }
        });

        try {
            rb.send();
        } catch (RequestException e) {
            e.printStackTrace();
            Window.alert("error = " + e.getMessage());
        }
    }
}
