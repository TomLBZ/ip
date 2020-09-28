package duke;

import messages.MessageFormat;
import messages.MessageOptions;
import messages.MessageWrapper;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void showListText(String input, MessageOptions indexOption) {
        ArrayList<String> lines = new ArrayList<>(Arrays.asList(input.split(Constants.WIN_NEWLINE)));
        String head = lines.get(0);
        lines.remove(head);
        msgFormat.removeMessageOption(MessageOptions.LINE_AFTER);
        msgWrapper.show(head, msgFormat.getMessageOptions());
        msgFormat.addMessageOption(MessageOptions.LINE_AFTER);
        msgFormat.removeMessageOption(MessageOptions.LINE_BEFORE);
        msgFormat.addMessageOption(indexOption);
        String[] strings = new String[0];
        strings = lines.toArray(strings);
        msgWrapper.show(strings, msgFormat.getMessageOptions());
        msgFormat.addMessageOption(MessageOptions.LINE_BEFORE);
        msgFormat.removeMessageOption(indexOption);
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
            showListText(input, tasks.indexOption);
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
