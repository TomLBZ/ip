package jobs;
import duke.*;

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

    /**
     * Instantiates a new Task.
     *
     * @param description the description
     */
    public Task(String description){
        this.isDone = false;
        this.description = description;
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
    public String toString(){
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
