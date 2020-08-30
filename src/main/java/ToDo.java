public class ToDo extends Task {

    public ToDo(String rawDescription){
        super(rawDescription);
    }

    @Override
    protected void updateDescription(){
        this.description = this.rawDescription.replace(
                Constants.TODO_CMD, Constants.ZERO_LENGTH_STRING).trim();
    }

    @Override
    public String toString(){
        return Constants.TODO_ICON + super.toString();
    }
}
