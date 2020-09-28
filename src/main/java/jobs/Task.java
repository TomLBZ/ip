package jobs;

import duke.Constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Task {

    protected String description;
    protected boolean isDone;
    protected LocalDateTime dateTime;
    protected boolean isDated;

    public Task(String description) {
        this.isDone = false;
        this.description = description;
        dateTime = null;
        isDated = false;
    }

    protected void getDateTime(String date) {
        dateTime = null;
        ArrayList<String> patterns = new ArrayList<>();
        for (String datePattern : Constants.DATE_PATTERNS) {
            for (String timePattern : Constants.TIME_PATTERNS) {
                String concat = datePattern + Constants.SPACE + timePattern;
                patterns.add(concat);
                patterns.add(concat.replace(Constants.PARAM_ALIAS, Constants.PARAM));
                patterns.add(concat.replace(Constants.PARAM_ALIAS, Constants.CHAR_SPACE));
            }
        }
        int noMatch = 0;
        for (String pattern : patterns) {
            try {
                if (dateTime != null) {
                    break;
                } else {
                    dateTime = LocalDateTime.parse(date.trim(), DateTimeFormatter.ofPattern(pattern));
                }
            } catch (Exception e) {
                noMatch++;
            }
        }
        isDated = noMatch != date.length() && dateTime != null;
    }

    protected LocalDate getDate() {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.toLocalDate();
        }
    }

    protected LocalTime getTime() {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.toLocalTime();
        }
    }

    protected LocalDateTime getDateTime() {
        return dateTime;
    }

    protected String getDateTimeString(String input) {
        String result;
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("MMM dd yyyy");
        if (dateTime == null) {
            result = input;
        } else {
            String date = getDate().format(datePattern);
            String time = getTime().toString();
            result = date + Constants.SPACE + time;
        }
        return result;
    }

    public String getStatusIcon() {
        return (isDone ? Constants.TICK : Constants.CROSS);
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsUndone() {
        isDone = false;
    }
}
