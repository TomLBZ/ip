package command.action;

import command.ParamNode;
import duke.TaskList;
import jobs.Event;

/**
 * The type Event action.
 */
public class EventAction extends Action {

    private String description;
    private String at;

    @Override
    public String act(TaskList tasks) {
        String result = super.act(tasks);
        Event event = new Event(description, at);
        tasks.tasks.add(event);
        return replaceStrings(result, event.toString(), tasks.tasks.size());
    }

    @Override
    public void prepare(ParamNode args) {
        super.prepare(args);
        at = flattenedArgs[1].thisData.toFlatString();
        description = flattenedArgs[0].toFlatString();
    }
}
