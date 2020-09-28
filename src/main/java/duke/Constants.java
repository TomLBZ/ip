package duke;

import command.action.Action;
import command.action.ByeAction;
import command.action.ClearAction;
import command.action.DeadlineAction;
import command.action.DeleteAction;
import command.action.DoneAction;
import command.action.EventAction;
import command.action.FindAction;
import command.action.HelpAction;
import command.action.ListAction;
import command.action.TodoAction;
import command.action.UndoneAction;
import command.action.UnknownAction;
import command.HelpText;

import java.util.Map;

/**
 * The type Constants.
 */
public class Constants {

    /**
     * The constant LPAREN.
     */
    public static final char LPAREN = '(';
    /**
     * The constant RPAREN.
     */
    public static final char RPAREN = ')';
    /**
     * The constant PARAM.
     */
    public static final char PARAM = '/';
    public static final char PARAM_ALIAS = '-';
    /**
     * The constant CMD_END.
     */
    public static final char CMD_END = ';';
    /**
     * The constant CHAR_SPACE.
     */
    public static final char CHAR_SPACE = ' ';
    /**
     * The constant LINE_UNIT.
     */
    public static final String LINE_UNIT = "_";
    /**
     * The constant DOT.
     */
    public static final String DOT = ".";
    /**
     * The constant SPACE.
     */
    public static final String SPACE = " ";
    /**
     * The constant ICON_LEFT.
     */
    public static final String ICON_LEFT = "[";
    /**
     * The constant ICON_RIGHT.
     */
    public static final String ICON_RIGHT = "]";
    /**
     * The constant PARAM_LEFT.
     */
    public static final String PARAM_LEFT = "(";
    /**
     * The constant PARAM_RIGHT.
     */
    public static final String PARAM_RIGHT = ")";
    /**
     * The constant TODO_ICON.
     */
    public static final String TODO_ICON = ICON_LEFT + "T" + ICON_RIGHT;
    /**
     * The constant EVENT_ICON.
     */
    public static final String EVENT_ICON = ICON_LEFT + "E" + ICON_RIGHT;
    /**
     * The constant DDL_ICON.
     */
    public static final String DDL_ICON = ICON_LEFT + "D" + ICON_RIGHT;
    /**
     * The constant ICON_SIGNATURE.
     */
    public static final String ICON_SIGNATURE = ICON_RIGHT + ICON_LEFT;
    /**
     * The constant ICON_SEPARATOR.
     */
    public static final String ICON_SEPARATOR = ICON_RIGHT + LINE_UNIT + ICON_LEFT;
    /**
     * The constant BODY_SIGNATURE.
     */
    public static final String BODY_SIGNATURE = ICON_RIGHT + SPACE;
    /**
     * The constant BODY_SEPARATOR.
     */
    public static final String BODY_SEPARATOR = ICON_RIGHT + LINE_UNIT;
    /**
     * The constant PARAM_SIGNATURE.
     */
    public static final String PARAM_SIGNATURE = SPACE + PARAM_LEFT;
    /**
     * The constant PARAM_SEPARATOR.
     */
    public static final String PARAM_SEPARATOR = LINE_UNIT + PARAM_LEFT;
    /**
     * The constant DETAILS_SIGNATURE.
     */
    public static final String DETAILS_SIGNATURE = ": ";
    /**
     * The constant TICK.
     */
    public static final String TICK = "\u2713";
    /**
     * The constant CROSS.
     */
    public static final String CROSS = "\u2718";
    /**
     * The constant TICK_ICON.
     */
    public static final String TICK_ICON = ICON_LEFT + TICK + ICON_RIGHT;
    /**
     * The constant CROSS_ICON.
     */
    public static final String CROSS_ICON = ICON_LEFT + CROSS + ICON_RIGHT;
    /**
     * The constant TAB.
     */
    public static final String TAB = "\t";
    /**
     * The constant NEWLINE.
     */
    public static final String NEWLINE = "\n";
    /**
     * The constant RETURN.
     */
    public static final String RETURN = "\r";
    /**
     * The constant WIN_NEWLINE.
     */
    public static final String WIN_NEWLINE = RETURN + NEWLINE;
    /**
     * The constant ZERO_LENGTH_STRING.
     */
    public static final String ZERO_LENGTH_STRING = "";
    /**
     * The constant TEXT_PLACEHOLDER.
     */
    public static final String TEXT_PLACEHOLDER = "_t_";
    /**
     * The constant NUMBER_PLACEHOLDER.
     */
    public static final String NUMBER_PLACEHOLDER = "_n_";
    public static final String SYNTAX_OR = "    OR    ";
    public static final String NOT_FOUND = "[NOT FOUND]";

    /**
     * The constant PATH.
     */
    public static final String PATH = "./data";
    /**
     * The constant FILENAME.
     */
    public static final String FILENAME = "duke.txt";

    /**
     * The constant BYE.
     */
    public static final String BYE = "bye";
    /**
     * The constant CLEAR.
     */
    public static final String CLEAR = "clear";
    /**
     * The constant DEADLINE.
     */
    public static final String DEADLINE = "deadline";
    /**
     * The constant DELETE.
     */
    public static final String DELETE = "delete";
    /**
     * The constant DONE.
     */
    public static final String DONE = "done";
    /**
     * The constant EVENT.
     */
    public static final String EVENT = "event";
    public static final String FIND = "find";
    /**
     * The constant HELP.
     */
    public static final String HELP = "help";
    /**
     * The constant LIST.
     */
    public static final String LIST = "list";
    /**
     * The constant TODO.
     */
    public static final String TODO = "todo";
    /**
     * The constant UNDONE.
     */
    public static final String UNDONE = "undone";
    /**
     * The constant UNKNOWN.
     */
    public static final String UNKNOWN = "unknown";

    /**
     * The constant INDEX_OUT.
     */
    public static final String INDEX_OUT = "Index out of range.";
    /**
     * The constant ADDED.
     */
    public static final String ADDED = "Got it. I've added this task:";
    /**
     * The constant REMOVED.
     */
    public static final String REMOVED = "Noted. I've removed this task:";
    /**
     * The constant COUNT_PREFIX.
     */
    public static final String COUNT_PREFIX = "Now you have ";
    /**
     * The constant COUNT_SUFFIX.
     */
    public static final String COUNT_SUFFIX = " tasks in the list.";
    /**
     * The constant CHANGED.
     */
    public static final String CHANGED = Constants.WIN_NEWLINE + Constants.TEXT_PLACEHOLDER
            + Constants.WIN_NEWLINE + Constants.COUNT_PREFIX + Constants.NUMBER_PLACEHOLDER
            + Constants.COUNT_SUFFIX;
    /**
     * The constant INVALID.
     */
    public static final String INVALID = "Invalid Command! Please check the syntax." + WIN_NEWLINE;
    /**
     * The constant WELCOME.
     */
    public static final String WELCOME = "Hello, I'm Duke. What can I do for you?";
    /**
     * The constant HELP_PROMPT.
     */
    public static final String HELP_PROMPT = "Use \"help [target]\" to see details :) Try \"help help\"!";
    public static final String[] DATE_PATTERNS = {
            "yyyy-MMM-dd", "yyyy-MMM-d", "yyyy-MM-dd", "yyyy-MM-d", "yyyy-M-dd", "yyyy-M-d",
            "yy-MMM-dd", "yy-MMM-d", "yy-MM-dd", "yy-MM-d", "yy-M-dd", "yy-M-d",
            "MMM-dd-yyyy", "MMM-d-yyyy", "MM-dd-yyyy", "MM-d-yyyy", "M-dd-yyyy", "M-d-yyyy",
            "MMM-dd-yy", "MMM-d-yy", "MM-dd-yy", "MM-d-yy", "M-dd-yy", "M-d-yy",
            "dd-MMM-yyyy", "d-MMM-yyyy", "dd-MM-yyyy", "d-MM-yyyy", "dd-M-yyyy", "d-M-yyyy",
            "dd-MMM-yy", "d-MMM-yy", "dd-MM-yy", "d-MM-yy", "dd-M-yy", "d-M-yy"};
    public static final String[] TIME_PATTERNS = {"HH:mm:ss", "H:mm:ss", "HH:m:ss", "HH:mm:s", "H:m:ss",
            "HH:m:s", "H:mm:s", "H:m:s", "HH:mm", "H:mm", "HH:m", "H:m", "HH", "H", ""};

    public static final String NO_KEYWORD = "No keyword provided, listing all tasks:" + WIN_NEWLINE;
    public static final String LIST_HEAD = "Here is the list of tasks:" + WIN_NEWLINE;
    /**
     * The constant LINE_REPETITION.
     */
    public static final int LINE_REPETITION = 60;
    /**
     * The constant NO_INDENT.
     */
    public static final int NO_INDENT = 0;
    /**
     * The constant INDENT_1.
     */
    public static final int INDENT_1 = 1;
    /**
     * The constant INDENT_2.
     */
    public static final int INDENT_2 = 2;
    /**
     * The constant INDENT_3.
     */
    public static final int INDENT_3 = 3;
    /**
     * The constant LETTER_OFFSET.
     */
    public static final int LETTER_OFFSET = 64;

    /**
     * The constant actionMap.
     */
    public static final Map<String, Action> actionMap = Map.ofEntries(
            Map.entry(BYE, new ByeAction()),
            Map.entry(CLEAR, new ClearAction()),
            Map.entry(DEADLINE, new DeadlineAction()),
            Map.entry(DELETE, new DeleteAction()),
            Map.entry(DONE, new DoneAction()),
            Map.entry(EVENT, new EventAction()),
            Map.entry(FIND, new FindAction()),
            Map.entry(HELP, new HelpAction()),
            Map.entry(LIST, new ListAction()),
            Map.entry(TODO, new TodoAction()),
            Map.entry(UNDONE, new UndoneAction()),
            Map.entry(UNKNOWN, new UnknownAction()));
    /**
     * The constant helpMap.
     */
    public static final Map<String, HelpText> helpMap = Map.ofEntries(
            Map.entry(BYE, HelpText.BYE),
            Map.entry(CLEAR, HelpText.CLEAR),
            Map.entry(DEADLINE, HelpText.DEADLINE),
            Map.entry(DELETE, HelpText.DELETE),
            Map.entry(DONE, HelpText.DONE),
            Map.entry(EVENT, HelpText.EVENT),
            Map.entry(FIND, HelpText.FIND),
            Map.entry(HELP, HelpText.HELP),
            Map.entry(LIST, HelpText.LIST),
            Map.entry(TODO, HelpText.TODO),
            Map.entry(UNDONE, HelpText.UNDONE),
            Map.entry(UNKNOWN, HelpText.UNKNOWN));
    /**
     * The constant paramMap.
     */
    public static final Map<String, String> paramMap = Map.ofEntries(
            Map.entry(DEADLINE, "by"),
            Map.entry(EVENT, "at"));
    public static final Map<String, String[]> optionalParamMap = Map.ofEntries(
            Map.entry(LIST, new String[]{"date", "asc", "desc", "spec"}));
    /**
     * The constant messageMap.
     */
    public static final Map<String, String> messageMap = Map.ofEntries(
            Map.entry(BYE, "Bye. Hope to see you again soon!"),
            Map.entry(CLEAR, "Nice! I've cleared everything in the list."),
            Map.entry(DEADLINE, Constants.ADDED + Constants.CHANGED),
            Map.entry(DELETE, Constants.REMOVED + Constants.CHANGED),
            Map.entry(DONE, "Nice! I've marked this task as done:"
                    + Constants.WIN_NEWLINE + Constants.TEXT_PLACEHOLDER),
            Map.entry(EVENT, Constants.ADDED + Constants.CHANGED),
            Map.entry(FIND, "Tasks with the specified keyword are:"
                    + Constants.WIN_NEWLINE + Constants.TEXT_PLACEHOLDER),
            Map.entry(HELP, Constants.TEXT_PLACEHOLDER),
            Map.entry(LIST, Constants.TEXT_PLACEHOLDER),
            Map.entry(TODO, Constants.ADDED + Constants.CHANGED),
            Map.entry(UNDONE, "Nice! I've marked this task as undone:"
                    + Constants.WIN_NEWLINE + Constants.TEXT_PLACEHOLDER),
            Map.entry(UNKNOWN, "OOPS, I don't know what that means :-( Try \"help\"!"));
}
