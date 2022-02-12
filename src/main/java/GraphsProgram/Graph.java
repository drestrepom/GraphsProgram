package GraphsProgram;

import java.util.ArrayList;

public interface Graph {

  public void add(int i, int j);

  public void remove(int i, int j);

  public ArrayList<Integer> bfs(int start);

  public ArrayList<Integer> dfs(int start, boolean[] visited);
}
