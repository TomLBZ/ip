public class IllegalCommandException extends CommandException {
    public Commands flag;
    public IllegalCommandException(Commands flag){
        super();
        this.flag = flag;
    }
}
