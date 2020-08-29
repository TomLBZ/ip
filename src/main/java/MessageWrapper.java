import java.util.Arrays;

public class MessageWrapper {
    private String lineBase;

    public MessageWrapper(String lineBase){
        setLineBase(lineBase);
    }

    public MessageWrapper(int length, String baseUnit){
        setLineBase(length, baseUnit);
    }

    public void setLineBase(int length, String baseUnit){
        lineBase = baseUnit.repeat(length);
    }

    public void setLineBase(String newLineBase){
        lineBase = newLineBase;
    }

    public String wrap(String input, MessageOptions[] options){
        return wrap(new String[]{input}, options);
    }

    public String wrap(String[] inputs, MessageOptions[] options){
        boolean isLineBefore = Arrays.asList(options).contains(MessageOptions.LINE_BEFORE);
        boolean isLineAfter = Arrays.asList(options).contains(MessageOptions.LINE_AFTER);
        boolean isAutoReturn = Arrays.asList(options).contains(MessageOptions.AUTO_RETURN);
        MessageOptions indexOption = getIndexOption(options);
        StringBuilder stringBuilder = new StringBuilder();
        int lineIndent = getLineIndent(options);
        int textIndent = getTextIndent(options);
        if (isLineBefore){
            stringBuilder.append(buildLine(lineIndent, lineBase));
        }
        for(int i = 0; i < inputs.length; i++){
            int index = i + 1;
            stringBuilder.append(buildMessage(textIndent, index, inputs[i], isAutoReturn, indexOption));
        }
        if (isLineAfter){
            stringBuilder.append(buildLine(lineIndent, lineBase));
        }
        return stringBuilder.toString();
    }

    public void show(String[] inputs, MessageOptions[] options){
        System.out.print(wrap(inputs, options));
    }

    public void show(String input, MessageOptions[] options){
        System.out.print(wrap(input, options));
    }

    private int getLineIndent(MessageOptions[] options){
        if (Arrays.asList(options).contains(MessageOptions.LINE_INDENT_1)) return 1;
        else if (Arrays.asList(options).contains(MessageOptions.LINE_INDENT_2)) return 2;
        else if (Arrays.asList(options).contains(MessageOptions.LINE_INDENT_3)) return 3;
        return 0;
    }

    private int getTextIndent(MessageOptions[] options){
        if (Arrays.asList(options).contains(MessageOptions.INDENTED_1)) return 1;
        else if (Arrays.asList(options).contains(MessageOptions.INDENTED_2)) return 2;
        else if (Arrays.asList(options).contains(MessageOptions.INDENTED_3)) return 3;
        return 0;
    }

    private MessageOptions getIndexOption(MessageOptions[] options){
        if (Arrays.asList(options).contains(MessageOptions.INDEXED_NUM)) return MessageOptions.INDEXED_NUM;
        else if (Arrays.asList(options).contains(MessageOptions.INDEXED_ABC)) return MessageOptions.INDEXED_ABC;
        else return MessageOptions.NOT_INDEXED;
    }

    private String buildLine(int lineIndent, String lineBase){
        return "\t".repeat(lineIndent) + lineBase + "\n";
    }

    private String buildMessage(int indent, int index, String message, boolean isAutoReturn, MessageOptions indexOption){
        String formattedMessage = "\t".repeat(indent);
        if(index > 0){
            if(indexOption == MessageOptions.INDEXED_NUM){
                formattedMessage += index + ".";
            }
            else if (indexOption == MessageOptions.INDEXED_ABC){
                formattedMessage += (char)(index + 64) + ".";
            }
        }
        formattedMessage += message;
        if (isAutoReturn){
            formattedMessage += "\n";
        }
        return formattedMessage;
    }
}
