package ca.mcmaster.se2aa4.mazerunner;

public class MovesCounterDecorator extends SolutionDecorator {

    public MovesCounterDecorator(SolvingInterface decorated) {
        super(decorated);
    }

    private int countMoves(String factorizedPath) {
        String[] tokens = factorizedPath.split(" ");
        int total = 0;

        for (String token : tokens) {
            if (token.length() >= 2) {
                try {
                    int count = Integer.parseInt(token.substring(0, token.length() - 1));
                    total += count;
                } catch (NumberFormatException e) {
                    // Handle or log malformed input if needed
                }
            }
        }

        return total;
    }

    @Override
    public String solveMaze() {
        String result = decorated.solveMaze(); // Factorized path like "1F 5R 4L"
        int moveCount = countMoves(result);
        System.out.println("Total number of moves: " + moveCount);
        return result;
    }

    @Override
    public String factorizePath(String path) {
        return decorated.factorizePath(path);
    }
}
