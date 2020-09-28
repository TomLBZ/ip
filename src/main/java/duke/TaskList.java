package duke;

import jobs.Task;
import messages.MessageOptions;

import java.util.ArrayList;

public class TaskList {

    public ArrayList<Task> tasks;
    public MessageOptions indexOption;
    public ArrayList<Integer> indices;

    public TaskList() {
        tasks = new ArrayList<>();
        indexOption = MessageOptions.NOT_INDEXED;
        indices = new ArrayList<>();
    }

    public Task get(int index) {
        return tasks.get(indices.get(index));
    }

    public int indexOf(Task task) {
        return tasks.indexOf(task);
    }

    public void loadList(ArrayList<Task> input) {
        tasks = input;
    }
}
