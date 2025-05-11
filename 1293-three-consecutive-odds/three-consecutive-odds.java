class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=0;
        for(int num:arr)
        {
            if(isOdd(num)){
                count++;
                if(count==3)
                    return true;
            }
            else{
                count=0;
            }
        }
        return false;
    }
    public boolean isOdd(int num){
        return (num%2)!=0;
    }
}