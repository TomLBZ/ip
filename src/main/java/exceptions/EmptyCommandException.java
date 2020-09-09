package exceptions;
import duke.*;

public class EmptyCommandException extends CommandException{
    public Commands flag;
    public EmptyCommandException(Commands flag){
        super();
        this.flag = flag;
    }
}
