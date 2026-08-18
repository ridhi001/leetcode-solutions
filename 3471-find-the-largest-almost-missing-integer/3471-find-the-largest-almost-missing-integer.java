class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            int ans = -1;

            for (int i = 0; i < n; i++) {
                int count = 0;

                for (int j = 0; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }

                if (count == 1) {
                    ans = Math.max(ans, nums[i]);
                }
            }

            return ans;
        }

        if (k == n) {
            int max = nums[0];

            for (int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
            }

            return max;
        }

        int ans = -1;

        // Check first element
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums[0]) {
                count++;
            }
        }

        if (count == 1) {
            ans = Math.max(ans, nums[0]);
        }

        // Check last element
        count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums[n - 1]) {
                count++;
            }
        }

        if (count == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}