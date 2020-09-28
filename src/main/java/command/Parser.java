package command;

import java.util.ArrayList;

/**
 * The type Parser.
 */
public class Parser {

    private Lexer lexer;

    /**
     * Instantiates a new Parser.
     */
    public Parser() {
        lexer = new Lexer();
    }

    /**
     * Parse tree array list.
     *
     * @param input the input
     * @return the array list
     */
    public ArrayList<Command> parseTree(ArrayList<Token> input) {
        ParamNode node = new ParamNode(input);
        ArrayList<ParamNode> flattened = node.flatten();
        ArrayList<Command> commands = new ArrayList<>();
        for (ParamNode args : flattened) {
            commands.add(new Command(args));
        }
        return commands;
    }

    /**
     * Parse array list.
     *
     * @param input the input
     * @return the array list
     */
    public ArrayList<Command> parse(String input) {
        return parseTree(lexer.analyze(input));
    }

}
