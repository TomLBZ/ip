package command.action;

import command.ParamNode;
import duke.Constants;
import duke.TaskList;

/**
 * The type Action.
 */
public class Action {

    /**
     * The Args.
     */
    protected ParamNode args;
    /**
     * The Flattened args.
     */
    protected ParamNode[] flattenedArgs;
    /**
     * The Is exiting.
     */
    public boolean isExiting = false;

    /**
     * Instantiates a new Action.
     */
    public Action() {
        args = null;
    }

    /**
     * Instantiates a new Action.
     *
     * @param args the args
     */
    public Action(ParamNode args) throws Exception {
        prepare(args);
    }

    /**
     * Act string.
     *
     * @param tasks the tasks
     * @return the string
     */
    public String act(TaskList tasks) {
        return Constants.messageMap.getOrDefault(args.name, Constants.INVALID);
    }

    /**
     * Prepare.
     *
     * @param args the args
     */
    public void prepare(ParamNode args) throws Exception {
        this.args = args;
        flattenedArgs = new ParamNode[0];
        if (args.thisData != null) {
            flattenedArgs = args.thisData.flatten().toArray(flattenedArgs);
        }
    }

    /**
     * Replace strings string.
     *
     * @param source the source
     * @param text   the text
     * @param count  the count
     * @return the string
     */
    protected String replaceStrings(String source, String text, int count) {
        String output = source.replace(Constants.TEXT_PLACEHOLDER, text);
        return output.replace(Constants.NUMBER_PLACEHOLDER, String.valueOf(count));
    }

    /**
     * Gets index.
     *
     * @param input the input
     * @return the index
     */
    protected int getIndex(String input) {
        int index = -1;
        if (input.length() != 1) {
            return index;
        }
        char character = input.toCharArray()[0];
        if (Character.isDigit(character)) {
            index = Integer.parseInt(input) - 1;
        } else if (Character.isLetter(character)) {
            character = Character.toUpperCase(character);
            index = (int) character - Constants.LETTER_OFFSET - 1;
        } else {
            index = -1;
        }
        return index;
    }
}
