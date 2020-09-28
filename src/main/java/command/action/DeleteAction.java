package command.action;

import command.ParamNode;
import duke.Constants;
import duke.TaskList;
import jobs.Task;

public class DeleteAction extends Action {

    private int index;

    @Override
    public String act(TaskList tasks) {
        if (index < 0 || index >= tasks.tasks.size()) {
            return Constants.INDEX_OUT;
        }
        Task task = tasks.get(index);
        String result = super.act(tasks);
        tasks.tasks.remove(task);
        return replaceStrings(result, task.toString(), tasks.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        index = getIndex(args.thisData.name);
    }
}
