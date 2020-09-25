package duke;

import messages.MessageFormat;
import messages.MessageOptions;
import messages.MessageWrapper;
import java.util.Scanner;

public class UI {

    private Scanner inputGetter;
    private MessageFormat msgFormat;
    private MessageWrapper msgWrapper;

    public UI() {
        inputGetter = new Scanner(System.in);
        msgFormat = new MessageFormat(new MessageOptions[]{
                MessageOptions.LINE_INDENT_1,
                MessageOptions.LINE_BEFORE,
                MessageOptions.INDENTED_2,
                MessageOptions.AUTO_RETURN,
                MessageOptions.LINE_AFTER
        });
        msgWrapper = new MessageWrapper(Constants.LINE_REPETITION, Constants.LINE_UNIT);

    }

    public void showWelcome() {
        msgWrapper.show(Constants.WELCOME, msgFormat.getMessageOptions());
    }

    public void showText(String input) {
        String[] lines = input.split(Constants.WIN_NEWLINE);
        msgWrapper.show(lines, msgFormat.getMessageOptions());
    }

    public void update(String input, TaskList tasks) {
        if (input == null || input.equals(Constants.ZERO_LENGTH_STRING)) {
            showText(input);
        } else {
            msgFormat.addMessageOption(tasks.indexOption);
            showText(input);
            msgFormat.removeMessageOption(tasks.indexOption);
        }
        tasks.indexOption = MessageOptions.NOT_INDEXED;
    }

    public String nextLine() {
        return inputGetter.nextLine();
    }

}
