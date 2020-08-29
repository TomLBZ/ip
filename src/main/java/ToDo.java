public class ToDo extends Task {

    public ToDo(String rawDescription){
        super(rawDescription);
    }

    @Override
    protected void updateDescription(){
        this.description = this.rawDescription.replace(Constants.TODO_CMD, "").trim();
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}
