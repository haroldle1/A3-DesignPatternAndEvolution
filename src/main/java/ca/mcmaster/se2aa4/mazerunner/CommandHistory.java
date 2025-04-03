package ca.mcmaster.se2aa4.mazerunner;

import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command command) {
        history.push(command);
    }

    public Command pop() {
        return history.pop(); // Optional use
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void printHistory() {
        System.out.println("Executed commands: ");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println("- " + history.get(i).getClass().getSimpleName());
        }
    }

    public Stack<Command> getHistory() {
        return history;
    }
}
