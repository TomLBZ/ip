package duke;

import exceptions.EmptyCommandException;
import exceptions.IllegalCommandException;
import exceptions.MissingDescriptionException;
import exceptions.UnknownCommandException;
import jobs.Deadline;
import jobs.Event;
import jobs.Task;
import jobs.ToDo;
import messages.MessageFormat;
import messages.MessageOptions;
import messages.MessageWrapper;
import java.util.ArrayList;

public class CommandHandler {

    private final MessageFormat format;
    private final MessageWrapper wrapper;
    private final CommandParser parser;
    private String result = "";
    private boolean isUpdatable = false;
    private final ArrayList<Task> tasks = new ArrayList<>();

    public CommandHandler(CommandParser parser, MessageFormat format, MessageWrapper wrapper){
        this.format = format;
        this.wrapper = wrapper;
        this.parser = parser;
    }

    public boolean isPendingUpdate() {
        return isUpdatable;
    }

    public void updateStatus(boolean success) {
        isUpdatable = !success;
    }

    public String getCommandResult() {
        return result;
    }

    public ArrayList<Task> getAddedTasks() {
        return tasks;
    }

    private String[] getCommandStrings(ArrayList<Task> tasks){
        String[] commands = new String[tasks.size()];
        for(int i = 0; i < tasks.size(); i++){
            commands[i] = tasks.get(i).toString();
        }
        return commands;
    }

    private String[] getAddTaskMessage(String description, int count){
        return new String[]{
                "Got it. I've added this task",
                description,
                "Now you have " + count + " tasks in the list."
        };
    }

    private void handleException(Exception e, Commands flag) {
        String unknown = "x_x OOPS!!! I'm sorry, but I don't know what that means :-(";
        String illegal = "x_x OOPS!!! The \"_SIGN_\" parameter of the _NAME_ command is missing.";
        String empty = "x_x OOPS!!! The parameter \"_SIGN_\" cannot be empty.";
        String missing = "x_x OOPS!!! The description of the \"_NAME_\" command cannot be empty.";
        if (e instanceof EmptyCommandException) {
            result = wrapper.wrap(
                    empty.replace("_SIGN_", flag.SIGN.trim()),
                    format.getMessageOptions());
        } else if (e instanceof IllegalCommandException) {
            result = wrapper.wrap(
                    illegal.replace("_SIGN_", flag.SIGN.trim())
                            .replace("_NAME_", flag.NAME.trim()),
                    format.getMessageOptions());
        } else if (e instanceof MissingDescriptionException) {
            result = wrapper.wrap(
                    missing.replace("_NAME_",flag.NAME.trim()),
                    format.getMessageOptions());

        } else if (e instanceof UnknownCommandException) {
            result = wrapper.wrap(unknown, format.getMessageOptions());
        } else {
            result = wrapper.wrap(
                    new String[]{"An unknown Exception has occurred.", e.getMessage()},
                    format.getMessageOptions());
        }
    }

    public boolean handleCommand(String userInput) {
        try {
            parser.parse(userInput);
        } catch (Exception e) {
            handleException(e, parser.getFlag());
            return true; //although there is exception, still should continue.
        }
        Commands flag = parser.getFlag();
        if (flag == null) {
            return true; //although no flag, still should continue.
        }
        String doTaskPrefix = "Nice! I've marked this task as done:";
        String undoTaskPrefix = "Nice! I've marked this task as undone:";
        String bye = " Bye. Hope to see you again soon!";
        switch (flag) {
        case LIST:
            String[] commands = getCommandStrings(tasks);
            format.addMessageOption(MessageOptions.INDEXED_NUM);
            result = wrapper.wrap(commands, format.getMessageOptions());
            format.removeMessageOption(MessageOptions.INDEXED_NUM);
            break;
        case BYE:
            result = wrapper.wrap(bye, format.getMessageOptions());
            return false; //break is unreachable
        case DONE:
            int index = Integer.parseInt(parser.getParameter()) - 1;
            Task task = tasks.get(index);
            if (task == null) {
                break;
            }
            task.markAsDone();
            result = wrapper.wrap(
                    new String[]{ doTaskPrefix, task.toString()},
                    format.getMessageOptions());
            isUpdatable = true;
            break;
        case UNDONE:
            int indexDone = Integer.parseInt(parser.getParameter()) - 1;
            Task taskDone = tasks.get(indexDone);
            if (taskDone == null) {
                break;
            }
            taskDone.markAsUndone();
            result = wrapper.wrap(
                    new String[]{ undoTaskPrefix, taskDone.toString()},
                    format.getMessageOptions());
            isUpdatable = true;
            break;
        case TODO:
            ToDo todo = new ToDo(userInput);
            tasks.add(todo);
            result = wrapper.wrap(
                    getAddTaskMessage(todo.toString(), tasks.size()),
                    format.getMessageOptions());
            isUpdatable = true;
            break;
        case DEADLINE:
            Deadline ddl = new Deadline(userInput);
            tasks.add(ddl);
            result = wrapper.wrap(
                    getAddTaskMessage(ddl.toString(), tasks.size()),
                    format.getMessageOptions());
            isUpdatable = true;
            break;
        case EVENT:
            Event event = new Event(userInput);
            tasks.add(event);
            result = wrapper.wrap(
                    getAddTaskMessage(event.toString(), tasks.size()),
                    format.getMessageOptions());
            isUpdatable = true;
            break;
        default:
            break;
        }
        return true;
    }
}
