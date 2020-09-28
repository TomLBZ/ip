package command.action;

import command.ParamNode;
import duke.Constants;
import duke.TaskList;

public class Action {

    protected ParamNode args;
    protected ParamNode[] flattenedArgs;
    public boolean isExiting = false;

    public Action() {
        args = null;
    }

    public Action(ParamNode args) throws Exception {
        prepare(args);
    }

    public String act(TaskList tasks) {
        return Constants.messageMap.getOrDefault(args.name, Constants.INVALID);
    }

    public void prepare(ParamNode args) throws Exception {
        this.args = args;
        flattenedArgs = new ParamNode[0];
        if (args.thisData != null) {
            flattenedArgs = args.thisData.flatten().toArray(flattenedArgs);
        }
    }

    protected String replaceStrings(String source, String text, int count) {
        String output = source.replace(Constants.TEXT_PLACEHOLDER, text);
        return output.replace(Constants.NUMBER_PLACEHOLDER, String.valueOf(count));
    }

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
