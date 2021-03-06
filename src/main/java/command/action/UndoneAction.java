package command.action;

import command.ParamNode;
import duke.Constants;
import duke.TaskList;
import jobs.Task;

/**
 * The type Undone action.
 */
public class UndoneAction extends Action {

    private int index;

    @Override
    public String act(TaskList tasks) {
        Task task = tasks.get(index);
        if (task == null) {
            return Constants.INDEX_OUT;
        } else {
            task.markAsUndone();
            String result = super.act(tasks);
            return result.replace(Constants.TEXT_PLACEHOLDER, task.toString());
        }
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        index = getIndex(args.thisData.name);
    }
}
