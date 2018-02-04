package home.work.gwt.client.ui.schedule;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import home.work.gwt.client.ui.MainPanel;
import home.work.gwt.common.model.User;

import java.util.List;

public class ReloadTodoListCommand implements ScheduledCommand {

    private List<User> _userList;

    private MainPanel _mainPanel;

    private int _index;

    public ReloadTodoListCommand(List<User> list, MainPanel mainPanel) {
        _userList = list;
        _mainPanel = mainPanel;
        _index = 0;
    }


    @Override
    public void execute() {
        if (_index < _userList.size()) {
            User user = _userList.get(_index);
            _mainPanel.addUserToPanel(user);
            Scheduler.get().scheduleDeferred(this);
            _index++;
        }
    }
}
