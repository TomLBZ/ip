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
        return new String[]{
                "Got it. I've added this task",
                description,
                "Now you have " + count + " tasks in the list."
        };
    }

    public static void main(String[] args) {
        MessageFormat msgFormat = new MessageFormat(new MessageOptions[]{
                MessageOptions.LINE_INDENT_1,
                MessageOptions.LINE_BEFORE,
                MessageOptions.INDENTED_2,
                MessageOptions.AUTO_RETURN,
                MessageOptions.LINE_AFTER
        });
        CommandParser cmdParser = new CommandParser();
        MessageWrapper msgWrapper = new MessageWrapper(
                Constants.LINE_REPETITION, Constants.LINE_UNIT);
        Scanner inputGetter = new Scanner(System.in);
        String[] greetings = new String[] {
                " Hello! I'm duke.Duke",
                " What can I do for you?"
        };
        String bye = " Bye. Hope to see you again soon!";
        String unknown = "x_x OOPS!!! I'm sorry, but I don't know what that means :-(";
        String illegal = "x_x OOPS!!! The \"_SIGN_\" parameter of the _NAME_ command is missing.";
        String empty = "x_x OOPS!!! The parameter \"_SIGN_\" cannot be empty.";
        String missing = "x_x OOPS!!! The description of the \"_NAME_\" command cannot be empty.";
        msgWrapper.show(greetings, msgFormat.getMessageOptions());
        ArrayList<Task> addedTasks = new ArrayList<>();
        boolean isRunning = true;
        while (isRunning) {
            String userInput = inputGetter.nextLine();
            Commands flag;
            Commands originalFlag;
            try {
                cmdParser.parse(userInput);
                flag = cmdParser.getFlag();
                originalFlag = flag;
            }
            catch (EmptyCommandException e){
                flag = Commands.EMPTY;
                originalFlag = e.flag;
            }
            catch (IllegalCommandException i){
                flag = Commands.ILLEGAL;
                originalFlag = i.flag;
            }
            catch (MissingDescriptionException m){
                flag = Commands.MISSING;
                originalFlag = m.flag;
            }
            catch (UnknownCommandException u){
                flag = Commands.UNKNOWN;
                originalFlag = flag;
            }
            switch (flag) {
            case LIST:
                String[] commands = getCommandStrings(addedTasks);
                msgFormat.addMessageOption(MessageOptions.INDEXED_NUM);
                msgWrapper.show(commands, msgFormat.getMessageOptions());
                msgFormat.removeMessageOption(MessageOptions.INDEXED_NUM);
                break;
            case BYE:
                msgWrapper.show(bye, msgFormat.getMessageOptions());
                isRunning = false;
                break;
            case DONE:
                int index = Integer.parseInt(cmdParser.getParameter()) - 1;
                Task task = addedTasks.get(index);
                if (task == null) {
                    break;
                }
                task.markAsDone();
                msgWrapper.show(new String[]{
                        "Nice! I've marked this task as done:",
                        task.toString()
                }, msgFormat.getMessageOptions());
                break;
            case UNDONE:
                int indexDone = Integer.parseInt(cmdParser.getParameter()) - 1;
                Task taskDone = addedTasks.get(indexDone);
                if (taskDone == null) {
                    break;
                }
                taskDone.markAsUndone();
                msgWrapper.show(new String[]{
                        "Nice! I've marked this task as undone:",
                        taskDone.toString()
                }, msgFormat.getMessageOptions());
                break;
            case TODO:
                ToDo todo = new ToDo(userInput);
                addedTasks.add(todo);
                msgWrapper.show(
                        getAddTaskMessage(todo.toString(), addedTasks.size()),
                        msgFormat.getMessageOptions());
                break;
            case DEADLINE:
                Deadline ddl = new Deadline(userInput);
                addedTasks.add(ddl);
                msgWrapper.show(
                        getAddTaskMessage(ddl.toString(), addedTasks.size()),
                        msgFormat.getMessageOptions());
                break;
            case EVENT:
                Event event = new Event(userInput);
                addedTasks.add(event);
                msgWrapper.show(
                        getAddTaskMessage(event.toString(), addedTasks.size()),
                        msgFormat.getMessageOptions());
                break;
            case UNKNOWN:
                msgWrapper.show(unknown, msgFormat.getMessageOptions());
                break;
            case ILLEGAL:
                String iMessage = illegal.replace(
                        "_SIGN_", originalFlag.SIGN.trim());
                iMessage = iMessage.replace(
                        "_NAME_", originalFlag.NAME.trim());
                msgWrapper.show(iMessage, msgFormat.getMessageOptions());
                break;
            case EMPTY:
                String eMessage = empty.replace("_SIGN_",
                        originalFlag.SIGN.trim());
                msgWrapper.show(eMessage, msgFormat.getMessageOptions());
                break;
            case MISSING:
                String mMessage = missing.replace("_NAME_",
                        originalFlag.NAME.trim());
                msgWrapper.show(mMessage, msgFormat.getMessageOptions());
                break;
            default:
                break;
            }
        }
    }
}
