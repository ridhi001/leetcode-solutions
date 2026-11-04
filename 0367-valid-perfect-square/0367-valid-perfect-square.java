class Solution {
    public boolean isPerfectSquare(int num) {
        int left=1;
        int right=num;
        while(left<=right){
            int mid=left+(right-left)/2;
            long sqaure=(long)mid*mid;
            if(sqaure==num){
                return true;
            }
            else if(sqaure<num){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
}