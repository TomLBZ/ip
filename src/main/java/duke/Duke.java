package duke;

import io.FileLoader;
import io.FileSaver;
import jobs.Task;
import messages.MessageFormat;
import messages.MessageOptions;
import messages.MessageWrapper;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner inputGetter = new Scanner(System.in);
        FileSaver fileSaver = new FileSaver(Constants.PATH, Constants.FILENAME);
        FileLoader fileLoader = new FileLoader(Constants.PATH, Constants.FILENAME);
        CommandParser parser = new CommandParser();
        MessageFormat msgFormat = new MessageFormat(new MessageOptions[]{
                MessageOptions.LINE_INDENT_1,
                MessageOptions.LINE_BEFORE,
                MessageOptions.INDENTED_2,
                MessageOptions.AUTO_RETURN,
                MessageOptions.LINE_AFTER
        });
        MessageWrapper msgWrapper = new MessageWrapper(
                Constants.LINE_REPETITION, Constants.LINE_UNIT);
        CommandHandler commandHandler = new CommandHandler(parser, msgFormat, msgWrapper);
        ArrayList<Task> addedTasks = fileLoader.loadSavedTasks(commandHandler);
        String[] greetings = new String[] {
                " Hello! I'm duke.Duke",
                " What can I do for you?"
        };
        msgWrapper.show(greetings, msgFormat.getMessageOptions());
        boolean isRunning = true;
        while (isRunning) {
            String userInput = inputGetter.nextLine();
            isRunning = commandHandler.handleCommand(userInput);
            System.out.print(commandHandler.getCommandResult());
            if (commandHandler.isPendingUpdate()) {
                addedTasks = commandHandler.getAddedTasks();
                boolean isSaved = fileSaver.save(addedTasks);
                commandHandler.updateStatus(isSaved);
            }
        }
    }
}
