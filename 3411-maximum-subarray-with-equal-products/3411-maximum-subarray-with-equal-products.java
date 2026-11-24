class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int prod = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];

                int gcd = 0;
                for (int k = i; k <= j; k++) {
                    gcd = findGCD(gcd, nums[k]);
                }

                int lcm = 1;
                for (int k = i; k <= j; k++) {
                    lcm = (lcm * nums[k]) / findGCD(lcm, nums[k]);
                }

                if (prod == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}