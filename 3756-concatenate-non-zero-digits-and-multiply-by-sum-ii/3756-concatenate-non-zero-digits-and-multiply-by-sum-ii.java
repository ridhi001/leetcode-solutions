class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] before = new int[n + 1];
        int[] first = new int[n + 1];
        int[] idx = new int[n];
        int[] digitPref = new int[n + 1];

        java.util.ArrayList<Integer> digits = new java.util.ArrayList<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            before[i] = cnt;
            if (s.charAt(i) != '0') {
                idx[i] = cnt;
                digits.add(s.charAt(i) - '0');
                cnt++;
            } else {
                idx[i] = -1;
            }
        }
        before[n] = cnt;

        int nxt = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') nxt = i;
            first[i] = nxt;
        }
        first[n] = -1;

        int m = digits.size();

        long[] pow10 = new long[m + 1];
        long[] prefNum = new long[m + 1];
        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            pow10[i + 1] = pow10[i] * 10 % MOD;
            digitPref[i + 1] = digitPref[i] + digits.get(i);
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int p = first[l];
            if (p == -1 || p > r) {
                ans[i] = 0;
                continue;
            }

            int L = idx[p];
            int R = before[r + 1] - 1;
            int len = R - L + 1;

            long x = (prefNum[R + 1] - prefNum[L] * pow10[len]) % MOD;
            if (x < 0) x += MOD;

            long sum = digitPref[R + 1] - digitPref[L];
            ans[i] = (int) (x * sum % MOD);
        }

        return ans;
    }
}