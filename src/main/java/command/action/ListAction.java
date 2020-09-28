package command.action;

import command.ParamNode;
import duke.Constants;
import duke.TaskList;
import jobs.Event;
import jobs.Task;
import messages.MessageOptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ListAction extends Action {

    private boolean isAsc = false;
    private boolean isDesc = false;
    private String stringDate = "";

    @Override
    public String act(TaskList tasks) {
        StringBuilder builder = new StringBuilder();
        tasks.indexOption = MessageOptions.INDEXED_NUM;
        ArrayList<Task> displayList = new ArrayList<>(tasks.tasks);
        if (!stringDate.equals("")) {
            LocalDateTime dateTime = Task.parseDateTime(stringDate);
            if (dateTime != null) {
                LocalDate date = dateTime.toLocalDate();
                for (Task task : displayList) {
                    if (date.equals(task.getDate())) {
                        builder.append(task.toString()).append(Constants.WIN_NEWLINE);
                    }
                }
            }
        } else {
            if (isAsc) {
                displayList.removeIf(x -> x.getDateTime() == null);
                displayList.sort(Comparator.comparing(Task::getDateTime));
            }
            if (isDesc) {
                displayList.removeIf(x -> x.getDateTime() == null);
                displayList.sort((x, y) -> -x.getDateTime().compareTo(y.getDateTime()));
            }
            for (Task task : displayList) {
                builder.append(task.toString()).append(Constants.WIN_NEWLINE);
            }
        }
        return builder.toString();
    }

    @Override
    public void prepare(ParamNode args) {
        super.prepare(args);
        int len = flattenedArgs.length;
        if (len == 0) {
            stringDate = "";
        } else {
            stringDate = flattenedArgs[0].toFlatString();
            String[] optionalParams = Constants.optionalParamMap.get(args.name);
            String optionalParam = optionalParams[0];
            String asc = optionalParams[1];
            String desc = optionalParams[2];
            String spec = optionalParams[3];
            boolean isDated = stringDate.contains(optionalParam);
            if (isDated) {
                stringDate = stringDate.replace(optionalParam, Constants.ZERO_LENGTH_STRING).trim();
                String[] options = stringDate.split(Constants.SPACE);
                String option = options[0];
                if (option.equals(spec) && options.length > 1) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 1; i < options.length; i++) {
                        builder.append(options[i]).append(Constants.SPACE);
                    }
                    stringDate = builder.toString();
                } else if (option.equals(asc)) {
                    isAsc = true;
                    isDesc = false;
                    stringDate = "";
                } else if (option.equals(desc)) {
                    isDesc = true;
                    isAsc = false;
                    stringDate = "";
                } else {
                    isAsc = false;
                    isDesc = false;
                    stringDate = "";
                }
            } else {
                stringDate = "";
            }
        }
    }

}
