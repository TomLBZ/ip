package command.action;

import command.HelpText;
import command.ParamNode;
import duke.Constants;
import duke.TaskList;

/**
 * The type Help action.
 */
public class HelpAction extends Action {

    /**
     * The Is detailed.
     */
    boolean isDetailed = false;
    /**
     * The Help text.
     */
    HelpText helpText = null;

    @Override
    public String act(TaskList tasks) {
        if (isDetailed && helpText != null) {
            return helpText.toString();
        } else {
            StringBuilder builder = new StringBuilder();
            for (HelpText help : HelpText.values()) {
                builder.append("Command: ").append(help.name).append(Constants.TAB).append(Constants.TAB).append(
                        "Description: ").append(help.description).append(Constants.WIN_NEWLINE);
            }
            builder.append(Constants.HELP_PROMPT);
            return builder.toString();
        }
    }

    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        if (flattenedArgs.length > 0) {
            String target = flattenedArgs[0].name;
            if (target != null) {
                isDetailed = true;
                helpText = Constants.helpMap.get(target);
            }
        }
    }
}
