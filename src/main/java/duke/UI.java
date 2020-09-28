package duke;

import messages.MessageFormat;
import messages.MessageOptions;
import messages.MessageWrapper;

import java.util.Scanner;

/**
 * The type Ui.
 */
public class UI {

    private Scanner inputGetter;
    private MessageFormat msgFormat;
    private MessageWrapper msgWrapper;

    /**
     * Instantiates a new Ui.
     */
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

    /**
     * Show welcome.
     */
    public void showWelcome() {
        msgWrapper.show(Constants.WELCOME, msgFormat.getMessageOptions());
    }

    /**
     * Show text.
     *
     * @param input the input
     */
    public void showText(String input) {
        String[] lines = input.split(Constants.WIN_NEWLINE);
        msgWrapper.show(lines, msgFormat.getMessageOptions());
    }

    /**
     * Update.
     *
     * @param input the input
     * @param tasks the tasks
     */
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

    /**
     * Next line string.
     *
     * @return the string
     */
    public String nextLine() {
        return inputGetter.nextLine();
    }

}
