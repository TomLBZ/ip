package duke;

import jobs.Task;
import messages.MessageOptions;

import java.util.ArrayList;

/**
 * The type Task list.
 */
public class TaskList {

    /**
     * The Tasks.
     */
    public ArrayList<Task> tasks;
    /**
     * The Index option.
     */
    public MessageOptions indexOption;

    /**
     * Instantiates a new Task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
        indexOption = MessageOptions.NOT_INDEXED;
    }

    /**
     * Load list.
     *
     * @param input the input
     */
    public void loadList(ArrayList<Task> input) {
        tasks = input;
    }
}
