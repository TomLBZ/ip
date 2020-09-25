package command;

import java.util.ArrayList;

public class Parser {

    private Lexer lexer;

    public Parser() {
        lexer = new Lexer();
    }

    public ArrayList<Command> parseTree(ArrayList<Token> input) {
        ParamNode node = new ParamNode(input);
        ArrayList<ParamNode> flattened = node.flatten();
        ArrayList<Command> commands = new ArrayList<>();
        for (ParamNode args: flattened) {
            commands.add(new Command(args));
        }
        return commands;
    }

    public ArrayList<Command> parse(String input) {
        return parseTree(lexer.analyze(input));
    }

}
