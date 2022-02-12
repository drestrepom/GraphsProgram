package GraphsProgram;

import java.util.ArrayList;

public class GraphMatrix implements Graph {

    private int numVertices;
    private int[][] matrix;
    private boolean directed;

    public GraphMatrix(int numVertices, boolean directed) {
        this.numVertices = numVertices;
        this.directed = directed;
        matrix = new int[this.numVertices + 1][this.numVertices + 1];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public GraphMatrix(int numVertices, int[][] relation, boolean directed) {
        this(numVertices, directed);
        for (int i = 0; i < relation.length; i++) {
            if (relation[i].length > 2) {
                throw new IllegalArgumentException("");
            }
            this.add(relation[i][0], relation[i][1]);
        }
    }

    public void add(int i, int j) {
        matrix[i][j] = 1;
        if (!this.directed) {
            matrix[j][i] = 1;
        }
    }

    public void remove(int i, int j) {
        if (matrix[i][j] > 0) {
            matrix[i][j] = 0;
            if (!this.directed) {
                matrix[j][i] = 0;
            }
        }
    }

    public ArrayList<Integer> dfs(int start, boolean[] visited) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(start);

        visited[start] = true;
        for (int i = 0; i < this.matrix[start].length; i++) {
            if (this.matrix[start][i] == 1 && (!visited[i])) {
                result.addAll(dfs(i, visited));
            }
        }
        return result;
    }

    public ArrayList<Integer> bfs(int start) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[this.matrix.length];
        ArrayList<Integer> q = new ArrayList<Integer>();

        q.add(start);
        visited[start] = true;

        int vis;
        while (!q.isEmpty()) {
            vis = q.get(0);
            result.add(vis);
            q.remove(q.get(0));

            for (int i = 0; i < this.matrix[vis].length; i++) {
                if (this.matrix[vis][i] == 1 && (!visited[i])) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return result;
    }

    public void show() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
