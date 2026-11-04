class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            int n=i;
           boolean flag=true;
            while(n>0){
                int digit=n%10;
                if(digit==0 || i%digit!=0){
                    flag=false;
                    break;
                }
                n=n/10;
            }
            if(flag){
                list.add(i);
            }
        }
        return list;
    }
}