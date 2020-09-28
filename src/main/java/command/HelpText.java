package command;

import duke.Constants;

/**
 * The enum Help text.
 */
public enum HelpText {

    /**
     * The Bye.
     */
    BYE(
            "bye",
            "Quit the program",
            new String[]{
                    "bye"
            },
            new String[]{
                    "1. \"bye\" >> quits the program"
            }),
    /**
     * The Clear.
     */
    CLEAR(
            "clear",
            "Clear the task list",
            new String[]{
                    "clear"
            },
            new String[]{
                    "1. \"clear\" >> clears the task list"
            }),
    /**
     * The Deadline.
     */
    DEADLINE(
            "deadline",
            "Add a deadline to the task list",
            new String[]{
                    "deadline [description] /by [time]"
            },
            new String[]{
                    "1. \"deadline ddl /by 21/9/15 1:12\" >> "
                            + "adds a deadline with description \"ddl\" and time \"September 15 2021 1:12\""
            }),
    /**
     * The Delete.
     */
    DELETE(
            "delete",
            "Delete a task from the task list",
            new String[]{
                    "delete [index]"
            },
            new String[]{
                    "1. \"delete 1\" >> deletes the task with index 1 from the current list"
            }),
    /**
     * The Done.
     */
    DONE(
            "done",
            "Mark a task as done",
            new String[]{
                    "done [index]"
            },
            new String[]{
                    "1. \"done 1\" >> marks the task with index 1 as done"
            }),
    /**
     * The Event.
     */
    EVENT(
            "event",
            "Add an event to the task list",
            new String[]{
                    "event [description] /at [time]"
            },
            new String[]{
                    "1. \"event e /at May 13 2020 8:00\" >> "
                            + "adds an event with description \"e\" and time \"May 13 2020 8:00\""
            }),
    /**
     * The Find.
     */
    FIND(
            "find",
            "Find an event in the task list with the specified keyword",
            new String[]{
                    "find [keyword]"
            },
            new String[]{
                    "1. \"find exam\" >> finds all tasks with the \"exam\" keyword from the task list"
            }),
    /**
     * The Help.
     */
    HELP(
            "help",
            "Print the list of available commands, or print the details of a specified command",
            new String[]{
                    "help [target]",
                    "target: the name of the target command"
            },
            new String[]{
                    "1. \"help\" >> prints the list of available commands",
                    "2. \"help event\" >> prints the details of the \"event\" command"
            }),
    /**
     * The List.
     */
    LIST(
            "list",
            "Print a list of all added tasks",
            new String[]{
                    "list",
                    "list date [asc / desc / spec MMM dd yyyy]"
            },
            new String[]{
                    "1. \"list\" >> list all added tasks",
                    "2. \"list date asc\" >> list tasks with a \"date\" field in ascending order",
                    "3. \"list date spec Oct 5 2020\" >> list tasks with specific \"date\" field of October 5 2020"
            }),
    /**
     * The Todo.
     */
    TODO(
            "todo",
            "Add a todo to the task list",
            new String[]{
                    "todo [description]"
            },
            new String[]{
                    "1. \"todo class\" >> adds a todo with description \"class\""
            }),
    /**
     * The Undone.
     */
    UNDONE(
            "undone",
            "Mark a task as undone",
            new String[]{
                    "undone [index]"
            },
            new String[]{
                    "1. \"undone 1\" >> marks the task with index 1 as undone"
            }),
    /**
     * The Unknown.
     */
    UNKNOWN(
            "unknown",
            "Prints the error message for an unrecognized command for debug purposes",
            new String[]{
                    "unknown"
            },
            new String[]{
                    "1. \"unknown\" >> prints \"OOPS, I don't know what that means :-( Try \"help\"!\""
            });

    /**
     * The Name.
     */
    public String name;
    /**
     * The Description.
     */
    public String description;
    /**
     * The Syntax.
     */
    public String[] syntax;
    /**
     * The Usages.
     */
    public String[] usages;

    HelpText(String name, String description, String[] syntax, String[] usages) {
        this.name = name;
        this.syntax = syntax;
        this.description = description;
        this.usages = usages;
    }

    /**
     * Array to string string.
     *
     * @param input the input
     * @return the string
     */
    public String arrayToString(String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : input) {
            stringBuilder.append(string).append(Constants.WIN_NEWLINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Name:");
        stringBuilder.append(Constants.SPACE).append(name).append(Constants.WIN_NEWLINE);
        stringBuilder.append("Description:").append(Constants.SPACE).append(
                description).append(Constants.WIN_NEWLINE);
        stringBuilder.append("Syntax:").append(Constants.WIN_NEWLINE).append(arrayToString(syntax));
        stringBuilder.append("Usages:").append(Constants.WIN_NEWLINE).append(arrayToString(usages));
        return stringBuilder.toString();
    }
}
