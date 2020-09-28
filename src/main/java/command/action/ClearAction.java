package command.action;

import command.ParamNode;
import duke.TaskList;

/**
 * The type Clear action.
 */
public class ClearAction extends Action {

    @Override
    public String act(TaskList tasks) {
        tasks.tasks.clear();
        return super.act(tasks);
    }

}
