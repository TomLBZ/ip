package duke;

public enum Commands {
    LIST("list"),
    BYE("bye"),
    DONE("done"),
    UNDONE("undone"),
    TODO("todo"),
    DEADLINE("deadline", "/by"),
    EVENT("event", "/at"),
    UNKNOWN("unknown"),
    ILLEGAL("illegal"),
    EMPTY("empty"),
    MISSING("missing");

    public final String SIGN;
    public final String NAME;

    Commands(String name) {
        this.NAME = name;
        SIGN = "";
    }

    Commands(String name, String sign){
        this.NAME = name;
        this.SIGN = sign;
    }

    boolean isNeedParameter(){
        return this.SIGN != null && !this.SIGN.equals(Constants.ZERO_LENGTH_STRING);
    }

    boolean isExceptional(){
        return this.equals(UNKNOWN) || this.equals(ILLEGAL) ||
                this.equals(EMPTY) || this.equals(MISSING);
    }

    boolean isNeedTarget(){
        return !this.equals(LIST) && !this.equals(BYE) && !this.isExceptional();
    }
}
