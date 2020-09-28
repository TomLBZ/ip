package command.action;

import duke.Constants;
import duke.TaskList;

/**
 * The type Unknown action.
 */
public class UnknownAction extends Action{

    @Override
    public String act(TaskList tasks) {
        return Constants.messageMap.getOrDefault(Constants.UNKNOWN, Constants.INVALID);
    }

}
