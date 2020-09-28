package command;

import command.action.UnknownAction;
import duke.Constants;
import command.action.Action;
import duke.TaskList;
import exceptions.InvalidCommandException;

/**
 * The type Command.
 */
public class Command implements Help {

    /**
     * The Args.
     */
    public ParamNode args;
    /**
     * The Flattened args.
     */
    public ParamNode[] flattenedArgs;
    /**
     * The Name.
     */
    public String name;
    private HelpText helpText;
    /**
     * The Action.
     */
    public Action action;
    /**
     * The Result.
     */
    public String result = "";

    /**
     * Instantiates a new Command.
     *
     * @param args the args
     */
    public Command(ParamNode args) {
        this.args = args;
        name = args.name;
        flattenedArgs = new ParamNode[0];
        if (args.thisData != null) {
            flattenedArgs = args.thisData.flatten().toArray(flattenedArgs);
        }
        helpText = Constants.helpMap.getOrDefault(name, HelpText.UNKNOWN); // later change to help.
        initiateAction();
    }

    private boolean isArgsValid() {
        String targetArg = Constants.paramMap.get(name);
        if (targetArg == null) {
            return true; // does not need any parameter
        } else {
            for (ParamNode node: flattenedArgs) {
                if (targetArg.equals(node.name)) {
                    return true;
                }
            }
            return false;
        }
    }

    private void initiateAction() {
        action = Constants.actionMap.getOrDefault(name, new UnknownAction());
    }

    /**
     * Execute.
     *
     * @param tasks the tasks
     */
    public void execute(TaskList tasks) {
        try {
            if (isArgsValid()) {
                action.prepare(args);
                result = action.act(tasks);
            } else {
                throw new InvalidCommandException();
            }
        } catch (Exception e) {
            StringBuilder builder = new StringBuilder(Constants.INVALID);
            for (String string: getSyntax()) {
                builder.append(string).append(Constants.TAB);
            }
            result = builder.toString();
        }
    }

    /**
     * Is exit boolean.
     *
     * @return the boolean
     */
    public boolean isExit() {
        return result.equals(Constants.messageMap.get(Constants.BYE));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return helpText.description;
    }

    @Override
    public String[] getSyntax() {
        return helpText.syntax;
    }

    @Override
    public String[] getUsages() {
        return helpText.usages;
    }

    @Override
    public String getHelp() {
        return helpText.toString();
    }

    @Override
    public String toString() {
        return args.toString();
    }

}
