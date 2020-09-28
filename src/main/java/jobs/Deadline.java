package jobs;

import duke.Constants;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        getDateTime(by);
    }

    @Override
    public String toString() {
        String byTime = getDateTimeString(by);
        return Constants.DDL_ICON + super.toString() + " (by: " + byTime + ")";
    }

}
