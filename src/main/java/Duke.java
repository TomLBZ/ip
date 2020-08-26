import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static String addFormatLines(String[] messages, boolean isIndexed){
        String strLine = "\t____________________________________________________________\n";
        StringBuilder innerMessage = new StringBuilder();
        for (int i = 0; i < messages.length; i++) {
            if(isIndexed){
                innerMessage.append("\t").append(i + 1).append(". ").append(messages[i]).append("\n");
            }
            else{
                innerMessage.append("\t").append(messages[i]).append("\n");
            }
        }
        return strLine + innerMessage + strLine;
    }

    private static String addFormatLines(String message){
        String strLine = "\t____________________________________________________________\n";
        return strLine + "\t" + message + "\n" + strLine;
    }

    public static void main(String[] args) {
        Scanner userInputGetter = new Scanner(System.in);
        String[] greetings = new String[] {" Hello! I'm Duke", " What can I do for you?"};
        String bye = " Bye. Hope to see you again soon!";
        System.out.print(addFormatLines(greetings, false));
        ArrayList<String> addedCommands = new ArrayList<>();
        boolean running = true;
        while (running) {
            String userInput = userInputGetter.nextLine();
            switch (userInput) {
            case "list":
                String[] commands = new String[addedCommands.size()];
                System.out.print(addFormatLines(addedCommands.toArray(commands), true));
                break;
            case "bye":
                System.out.print(addFormatLines(bye));
                running = false;
                break;
            default:
                addedCommands.add(userInput);
                System.out.print(addFormatLines("added: " + userInput));
                break;
            }
        }
    }
}
