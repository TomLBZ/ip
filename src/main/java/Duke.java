import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static String addFormatLines(String[] messages, boolean isIndexed){
        String strLine = "\t____________________________________________________________\n";
        StringBuilder innerMessage = new StringBuilder();
        if(isIndexed){
            innerMessage.append("\tHere are the tasks in your list:\n");
        }
        for (int i = 0; i < messages.length; i++) {
            if(isIndexed){
                innerMessage.append("\t").append(i + 1).append(".").append(messages[i]).append("\n");
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
        ArrayList<Task> addedTasks = new ArrayList<>();
        boolean running = true;
        while (running) {
            String userInput = userInputGetter.nextLine();
            switch (userInput) {
            case "list":
                String[] commands = new String[addedTasks.size()];
                for(int i = 0; i < commands.length; i++){
                    commands[i] = addedTasks.get(i).toString();
                }
                System.out.print(addFormatLines(commands, true));
                break;
            case "bye":
                System.out.print(addFormatLines(bye));
                running = false;
                break;
            default:
                if(userInput.contains("done")){
                    int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
                    if(index >= 0 && index < addedTasks.size()){
                        addedTasks.get(index).markAsDone();
                        System.out.print(addFormatLines("Nice! I've marked this task as done:\n\t\t" +
                                addedTasks.get(index).toString()));
                    }
                    else{
                        System.out.print(addFormatLines("Index specified is out of range."));
                    }
                }
                else{
                    addedTasks.add(new Task(userInput));
                    System.out.print(addFormatLines("added: " + userInput));
                }
                break;
            }
        }
    }
}
