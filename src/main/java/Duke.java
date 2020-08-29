import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static String[] getCommandStrings(ArrayList<Task> tasks){
        String[] commands = new String[tasks.size()];
        for(int i = 0; i < tasks.size(); i++){
            commands[i] = tasks.get(i).toString();
        }
        return commands;
    }

    private static String[] getAddTaskMessage(String description, int count){
        String[] message = new String[]{
                "Got it. I've added this task",
                description,
                "Now you have " + count + " tasks in the list."
        };
        return message;
    }

    public static void main(String[] args) {
        MessageFormat msgFormat = new MessageFormat(new MessageOptions[]{
                MessageOptions.LINE_INDENT_1,
                MessageOptions.LINE_BEFORE,
                MessageOptions.INDENTED_2,
                MessageOptions.AUTO_RETURN,
                MessageOptions.LINE_AFTER
        });
        CommandParser commandParser = new CommandParser();
        MessageWrapper messageWrapper = new MessageWrapper(60,"_");
        Scanner userInputGetter = new Scanner(System.in);
        String[] greetings = new String[] {
                " Hello! I'm Duke",
                " What can I do for you?"
        };
        String bye = " Bye. Hope to see you again soon!";
        messageWrapper.show(greetings, msgFormat.getMessageOptions());
        ArrayList<Task> addedTasks = new ArrayList<>();
        boolean isRunning = true;
        while (isRunning) {
            String userInput = userInputGetter.nextLine();
            commandParser.Parse(userInput);
            switch (commandParser.getFlag()) {
            case LIST:
                String[] commands = getCommandStrings(addedTasks);
                msgFormat.addMessageOption(MessageOptions.INDEXED_NUM);
                messageWrapper.show(commands, msgFormat.getMessageOptions());
                msgFormat.removeMessageOption(MessageOptions.INDEXED_NUM);
                break;
            case BYE:
                messageWrapper.show(bye, msgFormat.getMessageOptions());
                isRunning = false;
                break;
            case DONE:
                int index = Integer.parseInt(commandParser.getParameter()) - 1;
                Task task = addedTasks.get(index);
                if (task == null) break;
                task.markAsDone();
                messageWrapper.show(new String[]{
                        "Nice! I've marked this task as done:",
                        task.toString()
                }, msgFormat.getMessageOptions());
                break;
            case UNDONE:
                int indexDone = Integer.parseInt(commandParser.getParameter()) - 1;
                Task taskDone = addedTasks.get(indexDone);
                if (taskDone == null) break;
                taskDone.markAsUndone();
                messageWrapper.show(new String[]{
                        "Nice! I've marked this task as undone:",
                        taskDone.toString()
                }, msgFormat.getMessageOptions());
                break;
            case TODO:
                ToDo todo = new ToDo(userInput);
                addedTasks.add(todo);
                messageWrapper.show(
                        getAddTaskMessage(todo.toString(), addedTasks.size()),
                        msgFormat.getMessageOptions());
                break;
            case DEADLINE:
                Deadline ddl = new Deadline(userInput);
                addedTasks.add(ddl);
                messageWrapper.show(
                        getAddTaskMessage(ddl.toString(), addedTasks.size()),
                        msgFormat.getMessageOptions());
                break;
            case EVENT:
                Event event = new Event(userInput);
                addedTasks.add(event);
                messageWrapper.show(
                        getAddTaskMessage(event.toString(), addedTasks.size()),
                        msgFormat.getMessageOptions());
                break;
            default:
                String defaultMessage = "added: " + userInput;
                addedTasks.add(new Task(userInput));
                messageWrapper.show(defaultMessage, msgFormat.getMessageOptions());
                break;
            }
        }
    }
}
