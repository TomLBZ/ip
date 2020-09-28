package command.action;

import duke.TaskList;

public class ClearAction extends Action {

    @Override
    public String act(TaskList tasks) {
        tasks.tasks.clear();
        return super.act(tasks);
    }

}
