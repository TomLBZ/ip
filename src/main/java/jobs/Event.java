package jobs;

import duke.Constants;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        getDateTime(at);
    }

    @Override
    public String toString() {
        String atTime = getDateTimeString(at);
        return Constants.EVENT_ICON + super.toString() + " (at: " + atTime + ")";
    }
}
