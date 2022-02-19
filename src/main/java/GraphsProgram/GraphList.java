package GraphsProgram;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphList implements Graph {
  private int numVertices;
  LinkedList<Integer>[] adjList;
  boolean directed;

  GraphList(int numVertices, boolean directed) {
    this.numVertices = numVertices;
    this.directed = directed;
    this.adjList = new LinkedList[this.numVertices + 1];
    for (int i = 0; i < adjList.length; i++) {
      this.adjList[i] = new LinkedList<Integer>();
    }
  }

  GraphList(int numVertices, int[][] relations, boolean directed) {
    this(numVertices, directed);
    for (int i = 0; i < relations.length; i++) {
      if (relations[i].length > 2) {
        throw new IllegalArgumentException("");
      }
      this.add(relations[i][0], relations[i][1]);
    }
  }

  public void add(int i, int j) {
    for (int node : this.adjList[i]) {
      if (node == j) {
        return;
      }
    }
    if (i == j) {
      throw new IllegalArgumentException("circular reference");
    }
    this.adjList[i].add(j);
    if (!this.directed) {
      this.adjList[j].add(i);
    }
  }

  public void remove(int i, int j) {
    if (i == j) {
      throw new IllegalArgumentException("circular reference");
    }

    this.adjList[i].remove(j);
    if (!this.directed) {
      this.adjList[j].add(i);
    }
  }

  public ArrayList<Integer> dfs(int start, boolean[] visited) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(start);
    visited[start] = true;
    for (Integer i : this.adjList[start]) {
      if (!visited[i]) {
        result.addAll(dfs(i, visited));
      }
    }
    return result;
  }

  public ArrayList<Integer> bfs(int start) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    boolean[] visited = new boolean[this.adjList.length];
    ArrayList<Integer> queue = new ArrayList<Integer>();

    queue.add(start);
    visited[start] = true;

    int vertex;
    while (!queue.isEmpty()) {
      vertex = queue.get(0);
      result.add(vertex);
      queue.remove(queue.get(0));

      for (Integer i : this.adjList[vertex]) {
        if (!visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }

    return result;
  }

}
