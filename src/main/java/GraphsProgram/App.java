package GraphsProgram;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int nroNodes = 9;
        int array[][] = { { 1, 3 }, { 1, 2 }, { 3, 7 }, { 1, 5 }, { 2, 4 }, { 2, 5 },
                { 4, 0 }, { 4, 8 }, { 0, 7 }, { 8, 7 }, { 6, 3 }, { 8, 6 }, { 2, 9 }, { 9, 4 }, { 5, 8 } };
        GraphList graph = new GraphList(nroNodes, array, false);

        // matrix.show();
        boolean[] visited = new boolean[nroNodes + 1];
        ArrayList<Integer> result = graph.dfs(6, visited);
        System.out.println(result);
    }
}
