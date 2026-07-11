import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] res = dfs(i);
                int nodes = res[0];
                int degreeSum = res[1];

                if (degreeSum == nodes * (nodes - 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private int[] dfs(int node) {
        visited[node] = true;

        int nodes = 1;
        int degreeSum = graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next]) {
                int[] res = dfs(next);
                nodes += res[0];
                degreeSum += res[1];
            }
        }

        return new int[]{nodes, degreeSum};
    }
}