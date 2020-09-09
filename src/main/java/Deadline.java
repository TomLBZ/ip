public class Deadline extends Task {
    protected String by;

    public Deadline(String rawDescription){
        super(rawDescription);
        by = deadline();
    }

    @Override
    protected void updateDescription(){
        this.description = this.rawDescription.split(Commands.DEADLINE.SIGN)[0];
        this.description = this.description.replace(Commands.DEADLINE.NAME, Constants.ZERO_LENGTH_STRING);
        this.description = this.description.trim();
    }

    private String deadline(){
        String[] splitDescription = rawDescription.split(Commands.DEADLINE.SIGN);
        if (splitDescription.length > 1){
            return splitDescription[1];
        } else {
            return Constants.ZERO_LENGTH_STRING;
        }
    }

    @Override
    public String toString(){
        return Constants.DDL_ICON + super.toString() + " (by: " + by + ")";
    }
}
