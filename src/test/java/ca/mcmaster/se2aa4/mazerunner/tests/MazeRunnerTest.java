package ca.mcmaster.se2aa4.mazerunner.tests;

import ca.mcmaster.se2aa4.mazerunner.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MazeRunnerTest {

    private final String tinyMaze = "./examples/tiny.maz.txt";

    // Test 1: MazeReader reads correct dimensions
    @Test
    public void testMazeReaderLoadsMaze() {
        MazeReader reader = new MazeReader(tinyMaze);
        assertEquals(7, reader.getRows()); // adjust based on actual file
        assertEquals(7, reader.getCols()); // adjust based on actual file
        assertEquals('#', reader.getMaze()[0][0]); // check some known value
    }

    // Test 2: Maze detects entry and exit points
    @Test
    public void testMazeEntryAndExitPoints() {
        Maze maze = new Maze(tinyMaze);
        assertNotNull(maze.getEntryPoint());
        assertNotNull(maze.getExitPoint());
    }

    // Test 3: Maze dimensions from Maze object
    @Test
    public void testMazeGridDimensions() {
        Maze maze = new Maze(tinyMaze);
        assertEquals(7, maze.getRows()); 
        assertEquals(7, maze.getCols()); 
    }

    // Test 4: Grid content check
    @Test
    public void testMazeGridContents() {
        Maze maze = new Maze(tinyMaze);
        char[][] grid = maze.getMaze();
        assertEquals('#', grid[0][0]);
    }

    // Test 5: Path factorization - simple input
    @Test
    public void testFactorizePathSimple() {
        Solution solution = new RightHandRule(new Maze(tinyMaze));
        String result = solution.factorizePath("FFFFRRFF");
        assertEquals("4F 2R 2F", result);
    }

    // Test 6: Path factorization - empty input
    @Test
    public void testFactorizePathEmpty() {
        Solution solution = new RightHandRule(new Maze(tinyMaze));
        assertEquals("", solution.factorizePath(""));
    }

    // Test 7: solveMaze() returns a non-empty path
    @Test
    public void testSolveMazeReturnsNonEmptyPath() {
        Solution solution = new RightHandRule(new Maze(tinyMaze));
        String result = solution.solveMaze();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    // Test 8: PathValidator accepts the correct path
    @Test
    public void testPathValidatorCorrectPath() {
        Maze maze = new Maze(tinyMaze);
        Solution solution = new RightHandRule(maze);
        PathValidator validator = new PathValidator(solution);

        String correctPath = solution.solveMaze();
        assertTrue(validator.validatePath(correctPath));
    }

    // Test 9: PathValidator rejects incorrect path
    @Test
    public void testPathValidatorIncorrectPath() {
        Maze maze = new Maze(tinyMaze);
        Solution solution = new RightHandRule(maze);
        PathValidator validator = new PathValidator(solution);

        assertFalse(validator.validatePath("1F 1R 1F"));  // Wrong path
    }

    // Test 10: PathValidator handles empty/null input
    @Test
    public void testInvalidPathFormatReturnsFalse() {
        Maze maze = new Maze(tinyMaze);
        Solution solution = new RightHandRule(maze);
        PathValidator validator = new PathValidator(solution);

        assertFalse(validator.validatePath(""));
        assertFalse(validator.validatePath(null));
    }
}
