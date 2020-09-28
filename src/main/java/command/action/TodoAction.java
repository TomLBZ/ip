package command.action;

import command.ParamNode;
import duke.TaskList;
import jobs.ToDo;

public class TodoAction extends Action {

    private String description;

    @Override
    public String act(TaskList tasks) {
        String result = super.act(tasks);
        ToDo todo = new ToDo(description);
        tasks.tasks.add(todo);
        return replaceStrings(result, todo.toString(), tasks.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        description = args.thisData.toFlatString();
    }
}
