class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k %= total;

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIndex = (i * n + j + k) % total;
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                arr[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(arr[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}