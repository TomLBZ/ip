package jobs;

import duke.Constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The type Task.
 */
public class Task {

    /**
     * The Description.
     */
    protected String description;
    /**
     * The Is done.
     */
    protected boolean isDone;
    protected LocalDateTime dateTime;
    protected boolean isDated;

    /**
     * Instantiates a new Task.
     *
     * @param description the description
     */
    public Task(String description){
        this.isDone = false;
        this.description = description;
        dateTime = null;
        isDated = false;
    }

    private static ArrayList<String> getPatterns(boolean isDateOnly) {
        ArrayList<String> patterns = new ArrayList<>();
        if (isDateOnly) {
            for (String datePattern : Constants.DATE_PATTERNS) {
                patterns.add(datePattern);
                patterns.add(datePattern.replace(Constants.PARAM_ALIAS, Constants.PARAM));
                patterns.add(datePattern.replace(Constants.PARAM_ALIAS, Constants.CHAR_SPACE));
            }
        } else {
            for (String datePattern : Constants.DATE_PATTERNS) {
                for (String timePattern : Constants.TIME_PATTERNS) {
                    String concat = datePattern + Constants.SPACE + timePattern;
                    patterns.add(concat);
                    patterns.add(concat.replace(Constants.PARAM_ALIAS, Constants.PARAM));
                    patterns.add(concat.replace(Constants.PARAM_ALIAS, Constants.CHAR_SPACE));
                }
            }
        }
        return patterns;
    }

    public static LocalDateTime parseDateTime(String input) {
        LocalDateTime dateTime = null;
        ArrayList<String> patterns = getPatterns(false);
        for (String pattern : patterns) {
            try {
                if (dateTime != null) {
                    break;
                } else {
                    dateTime = LocalDateTime.parse(input.trim(), DateTimeFormatter.ofPattern(pattern));
                }
            } catch (Exception ignored) {
            }
        }
        if (dateTime == null) {
            patterns = getPatterns(true);
            for (String datePattern : patterns) {
                try {
                    if (dateTime != null) {
                        break;
                    } else {
                        dateTime = LocalDate.parse(input.trim(),
                                DateTimeFormatter.ofPattern(datePattern)).atStartOfDay();
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return dateTime;
    }

    protected void getDateTime(String date) {
        dateTime = parseDateTime(date);
        isDated = dateTime != null;
    }

    public LocalDate getDate() {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.toLocalDate();
        }
    }

    public LocalTime getTime() {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.toLocalTime();
        }
    }

    public LocalDateTime getDateTime() {
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

    /**
     * Get status icon string.
     *
     * @return the string
     */
    public String getStatusIcon(){
        return (isDone ? Constants.TICK : Constants.CROSS);
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Mark as done.
     */
    public void markAsDone(){
        isDone = true;
    }

    /**
     * Mark as undone.
     */
    public void markAsUndone(){
        isDone = false;
    }
}
