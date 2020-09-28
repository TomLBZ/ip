package command.action;

import command.ParamNode;
import duke.Constants;
import duke.TaskList;
import jobs.Task;
import messages.MessageOptions;

import java.util.ArrayList;

public class FindAction extends Action {

    private String keyword;

    @Override
    public String act(TaskList tasks) {
        if (keyword == null || keyword.length() == 0) {
            StringBuilder builder = new StringBuilder(Constants.NO_KEYWORD);
            tasks.indexOption = MessageOptions.INDEXED_NUM;
            for (Task task: tasks.tasks) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
            }
            return builder.toString();
        } else {
            String result = super.act(tasks);
            ArrayList<Task> filtered = new ArrayList<>(tasks.tasks);
            filtered.removeIf(x -> !x.toString().contains(keyword));
            StringBuilder builder = new StringBuilder();
            for (Task task: filtered) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
            }
            return result.replace(Constants.TEXT_PLACEHOLDER, builder.toString());
        }
    }

    @Override
    public void prepare(ParamNode args) {
        super.prepare(args);
        keyword = args.thisData.toFlatString();
    }
}
