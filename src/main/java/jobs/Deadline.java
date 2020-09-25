package jobs;
import duke.*;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString(){
        return Constants.DDL_ICON + super.toString() + " (by: " + by + ")";
    }
}
