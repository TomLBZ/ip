import java.util.Scanner;

public class Duke {

    private static String wrapMessageWithLines(String message){
        String strLine = "____________________________________________________________\n";
        return strLine + message + "\n" + strLine;
    }

    public static void main(String[] args) {
        Scanner userInputGetter = new Scanner(System.in);
        String greetings = " Hello! I'm Duke\n" + " What can I do for you?";
        String bye = " Bye. Hope to see you again soon!";
        System.out.print(wrapMessageWithLines(greetings));
        String userInput = userInputGetter.nextLine();
        while (!userInput.equals("bye")){
            System.out.print(wrapMessageWithLines(userInput));
            userInput = userInputGetter.nextLine();
        }
        System.out.print(wrapMessageWithLines(bye));
    }
}
