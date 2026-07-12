class Solution {
    public int maxSubArray(int[] nums) {
        long sum=0;
        int ansStart=-1;
        int ansEnd=-1;
        int start=0;
        long maxi=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum<0) sum=0;
            if(sum==0) start=i;
            sum+=nums[i];
            if(sum>maxi){
                maxi=sum;
                ansStart=start;
                ansEnd=i;
            }
        }
        return (int) maxi;
    }
}