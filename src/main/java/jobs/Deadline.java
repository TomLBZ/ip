package jobs;

import duke.Constants;

/**
 * The type Deadline.
 */
public class Deadline extends Task {

    /**
     * The By.
     */
    protected String by;

    /**
     * Instantiates a new Deadline.
     *
     * @param description the description
     * @param by          the by
     */
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
