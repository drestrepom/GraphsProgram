package GraphsProgram;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    int nroNodes = 9;
    int array[][] = { { 1, 3 }, { 1, 2 }, { 3, 7 }, { 1, 5 }, { 2, 9 }, { 2, 4 }, { 2, 5 }, { 5, 8 }, { 9, 4 },
            { 4, 8 }, { 4, 0 }, { 0, 7 }, { 8, 7 }, { 8, 6 }, { 6, 3 } };

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testBfsMatrix() {
        GraphMatrix matrix = new GraphMatrix(this.nroNodes, this.array, false);

        Object[] expected = new Object[] { 1, 2, 3, 5, 4, 9, 6, 7, 8, 0 };
        Object[] result = matrix.bfs(1).toArray();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testBfsList() {
        GraphList matrix = new GraphList(this.nroNodes, this.array, false);

        Object[] expected = new Object[] { 1, 3, 2, 5, 7, 6, 9, 4, 8, 0 };
        Object[] result = matrix.bfs(1).toArray();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testDfsMatrix() {
        GraphMatrix matrix = new GraphMatrix(this.nroNodes, this.array, false);

        Object[] expected = new Object[] { 1, 2, 4, 0, 7, 3, 6, 8, 5, 9 };
        boolean[] visited = new boolean[this.nroNodes + 1];
        Object[] result = matrix.dfs(1, visited).toArray();

        assertArrayEquals(expected, result);
    }

    @Test
    public void testDfsList() {
        GraphList matrix = new GraphList(this.nroNodes, this.array, false);

        Object[] expected = new Object[] { 1, 3, 7, 0, 4, 2, 9, 5, 8, 6 };
        boolean[] visited = new boolean[this.nroNodes + 1];
        Object[] result = matrix.dfs(1, visited).toArray();

        assertArrayEquals(expected, result);
    }
}
