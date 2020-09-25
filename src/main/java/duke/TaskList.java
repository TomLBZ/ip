package duke;

import jobs.Task;
import messages.MessageOptions;

import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> tasks;
    public MessageOptions indexOption;

    public TaskList() {
        tasks = new ArrayList<>();
        indexOption = MessageOptions.NOT_INDEXED;
    }

    public void loadList(ArrayList<Task> input) {
        tasks = input;
    }
}
