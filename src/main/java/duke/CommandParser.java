package duke;

import exceptions.EmptyCommandException;
import exceptions.IllegalCommandException;
import exceptions.MissingDescriptionException;
import exceptions.UnknownCommandException;

public class CommandParser {
    private Commands flag;
    private String parameter;

    public CommandParser(){
        flag = Commands.UNKNOWN;
        parameter = Constants.ZERO_LENGTH_STRING;
    }

    public void parse(String rawInput) throws
            EmptyCommandException, IllegalCommandException,
            UnknownCommandException, MissingDescriptionException {
        if (rawInput == null) return;
        String[] input = rawInput.split(Constants.SPACE);
        updateFlag(input[0]);
        parameter = Constants.ZERO_LENGTH_STRING;
        if (flag.isNeedParameter()){
            if(rawInput.contains(flag.SIGN)){
                String[] splitInput = rawInput.split(flag.SIGN);
                if (splitInput.length < 2) {
                    throw new EmptyCommandException(flag);
                }
                parameter = splitInput[1].trim();
                if (parameter.equals(Constants.ZERO_LENGTH_STRING)) {
                    throw new EmptyCommandException(flag);
                }
                String description = splitInput[0].replace(flag.NAME,
                        Constants.ZERO_LENGTH_STRING).trim();
                if (description.equals(Constants.ZERO_LENGTH_STRING)){
                    throw new MissingDescriptionException(flag);
                }
            } else {
                throw new IllegalCommandException(flag);
            }
        } else if (flag.isNeedTarget()){
            String target = rawInput.replace(flag.NAME,
                    Constants.ZERO_LENGTH_STRING).trim();
            if (target.equals(Constants.ZERO_LENGTH_STRING)) {
                throw new MissingDescriptionException(flag);
            }
            parameter = target;
        } else if (flag.equals(Commands.UNKNOWN)) {
            throw new UnknownCommandException();
        }
    }

    public Commands getFlag(){
        return flag;
    }

    public String getParameter(){
        return parameter.trim();
    }

    private void updateFlag(String command) throws UnknownCommandException{
        Commands[] commandValues = Commands.values();
        for (Commands cmdValue: commandValues) {
            if (command.equals(cmdValue.NAME)) {
                flag = cmdValue;
                return;
            }
        }
        throw new UnknownCommandException(); //break is unreachable
    }
}
