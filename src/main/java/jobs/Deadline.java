package jobs;
import duke.*;

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
    }

    @Override
    public String toString(){
        return Constants.DDL_ICON + super.toString() + " (by: " + by + ")";
    }
}
