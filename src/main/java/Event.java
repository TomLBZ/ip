public class Event extends Task{
    protected String at;

    public Event(String rawDescription){
        super(rawDescription);
        at = timing();
    }

    @Override
    protected void updateDescription(){
        this.description = this.rawDescription.split(Constants.EVENT_SIGN)[0];
        this.description = this.description.replace(Constants.EVENT_CMD, Constants.ZERO_LENGTH_STRING);
        this.description = this.description.trim();
    }

    private String timing(){
        String[] splitDescription = rawDescription.split(Constants.EVENT_SIGN);
        if (splitDescription.length > 1){
            return splitDescription[1];
        } else {
            return Constants.ZERO_LENGTH_STRING;
        }
    }

    @Override
    public String toString(){
        return Constants.EVENT_ICON + super.toString() + " (at: " + at + ")";
    }
}
