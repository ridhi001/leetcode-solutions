class Solution {
    public int findGCD(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        return gcd(min,max);
    }
    public int gcd(int a, int b){
        int g=0;
        for(int i=1;i<=Math.min(a,b);i++){
            if(a%i==0&&b%i==0){
                g=i;
            }
        }
        return g;
    }
}