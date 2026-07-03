import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxCost = Math.max(maxCost, e[2]);
        }

        int[] topo = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int[] deg = indegree.clone();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.offer(i);
            }
        }

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] e : graph[u]) {
                if (--deg[e[0]] == 0) {
                    q.offer(e[0]);
                }
            }
        }

        int left = 0, right = maxCost, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, graph, topo, online, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit, List<int[]>[] graph, int[] topo, boolean[] online, long k) {
        int n = online.length;
        long inf = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == inf) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                int cost = e[1];

                if (cost < limit) continue;
                if (v != n - 1 && !online[v]) continue;

                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}