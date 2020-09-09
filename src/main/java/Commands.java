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
    EMPTY("empty");

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
        if(this.SIGN == null || this.SIGN.equals(Constants.ZERO_LENGTH_STRING)){
            return false;
        }
        return true;
    }

    boolean isExceptional(){
        return this.equals(UNKNOWN) || this.equals(ILLEGAL) || this.equals(EMPTY);
    }

    boolean isNeedTarget(){
        if(this.equals(LIST) || this.equals(BYE) || this.isExceptional()){
            return false;
        }
        return true;
    }
}
