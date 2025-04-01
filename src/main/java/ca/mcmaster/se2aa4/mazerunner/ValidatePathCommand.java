package ca.mcmaster.se2aa4.mazerunner;

public class ValidatePathCommand implements Command {
    private PathValidator validator;
    private String path;

    public ValidatePathCommand(PathValidator validator, String path) {
        this.validator = validator;
        this.path = path;
    }

    @Override
    public void execute() {
        if (validator.validatePath(path)) {
            System.out.println("Correct Path");
        } else {
            System.out.println("Incorrect Path");
        }
    }
}

