package messages;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageFormat {
    private final ArrayList<MessageOptions> messageOptionsList;

    public MessageFormat(MessageOptions[] options) {
        messageOptionsList = new ArrayList<>(Arrays.asList(options));
    }

    public void addMessageOption(MessageOptions option) {
        messageOptionsList.add(option);
    }

    public void removeMessageOption(MessageOptions option) {
        messageOptionsList.remove(option);
    }

    public MessageOptions[] getMessageOptions() {
        MessageOptions[] output = new MessageOptions[messageOptionsList.size()];
        return messageOptionsList.toArray(output);
    }
}
