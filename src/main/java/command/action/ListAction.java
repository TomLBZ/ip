package command.action;

import duke.Constants;
import duke.TaskList;
import jobs.Task;
import messages.MessageOptions;

public class ListAction extends Action {

    @Override
    public String act(TaskList tasks) {
        StringBuilder builder = new StringBuilder(Constants.LIST_HEAD);
        tasks.indexOption = MessageOptions.INDEXED_NUM;
        for (Task task: tasks.tasks) {
            builder.append(task.toString()).append(Constants.WIN_NEWLINE);
        }
        return builder.toString();
    }

}
