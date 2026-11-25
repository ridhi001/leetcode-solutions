
import java.util.*;

class Solution {

    long mod1 = 1000000007;
    long mod2 = 998244353;

    long base1 = 31;
    long base2 = 37;

    long[] hash1;
    long[] hash2;
    long[] pow1;
    long[] pow2;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        hash1 = new long[n + 1];
        hash2 = new long[n + 1];

        pow1 = new long[n + 1];
        pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 0; i < n; i++) {

            pow1[i + 1] = (pow1[i] * base1) % mod1;
            pow2[i + 1] = (pow2[i] * base2) % mod2;

            hash1[i + 1] = (hash1[i] * base1 + nums[i]) % mod1;
            hash2[i + 1] = (hash2[i] * base2 + nums[i]) % mod2;
        }

        int left = 1;
        int right = n;
        int ans = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (check(mid, n)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean check(int len, int n) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {

            long h1 = (hash1[i + len]
                    - hash1[i] * pow1[len] % mod1 + mod1) % mod1;

            long h2 = (hash2[i + len]
                    - hash2[i] * pow2[len] % mod2 + mod2) % mod2;

            long key = (h1 << 32) | h2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
