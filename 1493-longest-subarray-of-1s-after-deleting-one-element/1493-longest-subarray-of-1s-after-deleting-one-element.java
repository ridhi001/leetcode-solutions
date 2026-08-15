class Solution {
    public int longestSubarray(int[] arr) {
        int n=arr.length, i=0, j=0;
        int z=0;
        for(int ele: arr){
            if(ele==0) z++;
        }
        if(z==0) return n-1;
        int zeroes=0, maxLen=0;
        while(i<n && arr[i]==0) i++;
        if(i==n) return 0;
        j=i;
        while(j<n){
            if(arr[j]==1) j++;
            else{
                if(zeroes==0){
                    j++;
                    zeroes++;
                }
                else{
                    int len=j-i-1;
                    maxLen=Math.max(maxLen,len);
                    j++;
                    while(i<n && arr[i]==1) i++;
                    i++;
                }
            }
            }
            if(zeroes==1){
                int len=j-i-1;
                maxLen=Math.max(maxLen,len);
            }
            if(zeroes==0) return j-i;
            return maxLen;
        }
    }
