package home.work.gwt.client.model;

import home.work.gwt.common.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserModelHandler {

    List<User> users = new ArrayList<>();

    public UserModelHandler() {
    }

    public UserModelHandler(List<User> users) {
        this.users = users;
    }

    public void add(User u) {
        users.add(u);
    }

    public void remove(User u) {
        users.remove(u);
    }

    public void removeAll() {
        users.clear();
    }

    public List<User> getAll() {
        return users;
    }

    public void reloadAll(List<User> list) {
        users.clear();
        for (User u : list) {
            add(u);
        }
    }
}
