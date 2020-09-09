public class MissingDescriptionException extends CommandException {
    public Commands flag;
    public MissingDescriptionException(Commands flag){
        super();
        this.flag = flag;
    }
}
