public class CommandParser {
    private Commands flag;
    private String parameter;

    public CommandParser(){
        flag = Commands.UNKNOWN;
        parameter = "";
    }

    public void Parse(String rawInput){
        if (rawInput == null) return;
        String[] input = rawInput.split(" ");
        updateFlag(input[0]);
        if (flag == Commands.DEADLINE || flag == Commands.EVENT ||
            flag == Commands.DONE || flag == Commands.UNDONE){
            String commandSign = getCommandSign(flag);
            if(rawInput.contains(commandSign)){
                parameter = rawInput.split(commandSign)[1].trim();
            }
            else {
                flag = Commands.ILLEGAL;
            }
        }
        else {
            parameter = "";
        }
    }

    public Commands getFlag(){
        return flag;
    }

    public String getParameter(){
        return parameter;
    }

    private String getCommandSign(Commands command){
        switch (command){
        case DEADLINE:
            return Constants.DDL_SIGN;
        case EVENT:
            return Constants.EVENT_SIGN;
        case DONE:
            return Constants.DONE_CMD;
        case UNDONE:
            return Constants.UNDONE_CMD;
        default:
            return "";
        }
    }

    private void updateFlag(String command){
        switch (command){
        case Constants.LIST_CMD:
            flag = Commands.LIST;
            break;
        case Constants.BYE_CMD:
            flag = Commands.BYE;
            break;
        case Constants.DONE_CMD:
            flag = Commands.DONE;
            break;
        case Constants.UNDONE_CMD:
            flag = Commands.UNDONE;
            break;
        case Constants.TODO_CMD:
            flag = Commands.TODO;
            break;
        case Constants.DDL_CMD:
            flag = Commands.DEADLINE;
            break;
        case Constants.EVENT_CMD:
            flag = Commands.EVENT;
            break;
        default:
            flag = Commands.UNKNOWN;
            break;
        }
    }
}
