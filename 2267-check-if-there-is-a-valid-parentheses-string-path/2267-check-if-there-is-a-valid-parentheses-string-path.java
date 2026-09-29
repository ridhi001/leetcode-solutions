class Solution {
    int m, n;
    char[][] grid;
    boolean[][][] visited;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        // odd path length can't be valid; wrong start/end can't be valid
        if (((m + n - 1) & 1) == 1 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        visited = new boolean[m][n][m + n];
        return solve(0, 0, 0);
    }

    boolean solve(int i, int j, int open) {
        if (i >= m || j >= n) return false;
        open += grid[i][j] == '(' ? 1 : -1;
        int remaining = (m - 1 - i) + (n - 1 - j);
        if (open < 0 || open > remaining) return false;   // prune
        if (i == m - 1 && j == n - 1) return open == 0;
        if (visited[i][j][open]) return false;            // already explored this state
        visited[i][j][open] = true;
        return solve(i + 1, j, open) || solve(i, j + 1, open);
    }
}