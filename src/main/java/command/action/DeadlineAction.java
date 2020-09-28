package command.action;

import command.ParamNode;
import duke.TaskList;
import jobs.Deadline;

/**
 * The type Deadline action.
 */
public class DeadlineAction extends Action {

    private String description;
    private String by;

    @Override
    public String act(TaskList tasks) {
        String result = super.act(tasks);
        Deadline ddl = new Deadline(description, by);
        tasks.tasks.add(ddl);
        return replaceStrings(result, ddl.toString(), tasks.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) {
        super.prepare(args);
        by = flattenedArgs[1].thisData.toFlatString();
        description = flattenedArgs[0].toFlatString();
    }
}
