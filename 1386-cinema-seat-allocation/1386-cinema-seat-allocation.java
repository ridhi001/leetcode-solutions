import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                int mask = map.getOrDefault(row, 0);
                mask |= (1 << (col - 2));
                map.put(row, mask);
            }
        }

        int ans = (n - map.size()) * 2;

        int leftMask = 15;
        int midMask = 60;
        int rightMask = 240;

        for (int reserved : map.values()) {
            boolean left = (reserved & leftMask) == 0;
            boolean mid = (reserved & midMask) == 0;
            boolean right = (reserved & rightMask) == 0;

            if (left && right)
                ans += 2;
            else if (left || mid || right)
                ans++;
        }

        return ans;
    }
}