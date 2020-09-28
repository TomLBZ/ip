package duke;

import command.Command;
import command.Parser;
import io.Storage;
import java.util.ArrayList;

/**
 * The type Duke.
 */
public class Duke {

    private TaskList tasks;
    private final Storage storage;
    private final UI ui;
    private final Parser parser;

    /**
     * Instantiates a new Duke.
     *
     * @param directory the directory
     * @param fileName  the file name
     */
    public Duke(String directory, String fileName) {
        ui = new UI();
        parser = new Parser();
        storage = new Storage(directory, fileName, parser);
        try {
            tasks = storage.load();
        } catch (Exception e) {
            ui.showText(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Run.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.nextLine();
                ArrayList<Command> commands = parser.parse(fullCommand);
                for (Command c: commands) {
                    c.execute(tasks);
                    ui.update(c.result, tasks);
                    isExit = c.isExit();
                    storage.saveTasks(tasks.tasks);
                }
            } catch (Exception e) {
                ui.showText(e.getMessage());
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new Duke(Constants.PATH, Constants.FILENAME).run();
    }
}
