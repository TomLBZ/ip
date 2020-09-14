package io;
import duke.CommandHandler;
import duke.Commands;
import duke.Constants;
import jobs.Task;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileLoader extends IO {

    public FileLoader(String path, String fileName) {
        super(path, fileName);
    }

    public ArrayList<Task> loadSavedTasks(CommandHandler handler) {
        try {
            if (!validateFile()) {
                throw new IOException();
            }
            String[] lines = new String[0];
            lines = Files.readAllLines(Paths.get(path + "/" + fileName)).toArray(lines);
            int numberOfTasks = 1; //
            for (String line: lines) {
                if (line == null || line.equals("")) {
                    continue;
                }
                String[] commands = getCommands(line, numberOfTasks);
                for (String command: commands) {
                    handler.handleCommand(command);
                }
                numberOfTasks++;
            }
            return handler.getAddedTasks();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private String removeBracket(String input) {
        String output = input.trim();
        output = output.substring(1, output.length() - 1);
        return output;
    }

    private String getCommand(String icon, String description, String detail) {
        switch (icon) {
        case Constants.TODO_ICON: // break is unreachable
            return Commands.TODO.NAME + Constants.SPACE + description;
        case Constants.EVENT_ICON: // break is unreachable
            return Commands.EVENT.NAME + Constants.SPACE + description + Constants.SPACE +
                    Commands.EVENT.SIGN + Constants.SPACE + detail;
        case Constants.DDL_ICON: // break is unreachable
            return Commands.DEADLINE.NAME + Constants.SPACE + description + Constants.SPACE +
                    Commands.DEADLINE.SIGN + Constants.SPACE + detail;
        default:
            return ""; //break is unreachable.
        }
    }

    private String getStateCommand(String state, int index) {
        if (state.equals(Constants.TICK)) {
            return Commands.DONE.NAME + Constants.SPACE + index;
        } else if (state.equals(Constants.CROSS)) {
            return Commands.UNDONE.NAME + Constants.SPACE + index;
        } else {
            return "";
        }
    }

    private String[] getCommands(String taskText, int taskIndex) {
        String text = taskText.replace(Constants.ICON_SIGNATURE,Constants.ICON_SEPARATOR);
        text = text.replace(Constants.BODY_SIGNATURE,Constants.BODY_SEPARATOR);
        String[] iconSeparated = text.split(Constants.LINE_UNIT);
        String icon = iconSeparated[0];
        String state = iconSeparated[1];
        StringBuilder body = new StringBuilder();
        for (int i = 2; i < iconSeparated.length; i++) {
            body.append(iconSeparated[i]);
        }
        String description = body.toString();
        description = description.replace(Constants.PARAM_SIGNATURE,Constants.PARAM_SEPARATOR);
        String[] paramSeparated = description.split(Constants.LINE_UNIT);
        description = paramSeparated[0];
        String detail = "";
        if (paramSeparated.length > 1) {
            String param = removeBracket(paramSeparated[1]);
            String[] paramDetails = param.split(Constants.DETAILS_SIGNATURE);
            detail = paramDetails[1].trim();
        }
        return new String[]{
                getCommand(icon, description, detail),
                getStateCommand(removeBracket(state), taskIndex)};
    }
}
