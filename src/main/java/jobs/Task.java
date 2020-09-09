package jobs;
import duke.*;

public class Task {
    protected String rawDescription;
    protected String description;
    protected boolean isDone;

    public Task(String rawDescription){
        this.rawDescription = rawDescription;
        this.isDone = false;
        updateDescription();
    }

    protected void updateDescription(){
        description = rawDescription;
    }

    public String getStatusIcon(){
        return (isDone ? Constants.TICK : Constants.CROSS);
    }

    @Override
    public String toString(){
        return "[" + getStatusIcon() + "] " + description;
    }

    public void markAsDone(){
        isDone = true;
    }

    public void markAsUndone(){
        isDone = false;
    }
}
