package ca.mcmaster.se2aa4.mazerunner;

public class TimingDecorator extends SolutionDecorator {

    public TimingDecorator(SolvingInterface decorated) {
        super(decorated);
    }

    @Override
    public String solveMaze() {
        long start = System.nanoTime();
        String result = decorated.solveMaze();
        long end = System.nanoTime();
        long duration = (end - start);
        System.out.println("Time taken to solve maze: " + duration + " ns");
        return result;
    }

    @Override
    public String factorizePath(String path) {
        return decorated.factorizePath(path);
    }
}

