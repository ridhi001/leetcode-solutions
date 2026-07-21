class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ans = 0;
        int preZero = Integer.MIN_VALUE;
        int maxZero = 0;

        int i = 0;
        while (i < s.length()) {
            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ans += len;
            } else {
                maxZero = Math.max(maxZero, preZero + len);
                preZero = len;
            }

            i = j;
        }

        return ans + maxZero;
    }
}