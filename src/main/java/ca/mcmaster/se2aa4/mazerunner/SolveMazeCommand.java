package ca.mcmaster.se2aa4.mazerunner;

public class SolveMazeCommand implements Command {
    private SolvingInterface solver;

    public SolveMazeCommand(SolvingInterface solver) {
        this.solver = solver;
    }

    @Override
    public void execute() {
        String path = solver.solveMaze();
        System.out.println(path);
    }
}

