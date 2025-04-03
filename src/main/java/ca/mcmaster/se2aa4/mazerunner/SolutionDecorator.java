package ca.mcmaster.se2aa4.mazerunner;
abstract class SolutionDecorator implements SolvingInterface {
    protected SolvingInterface decorated;

    public SolutionDecorator (SolvingInterface decorated){
        this.decorated = decorated;
    }

    public abstract String solveMaze();
    public abstract String factorizePath(String path);
}