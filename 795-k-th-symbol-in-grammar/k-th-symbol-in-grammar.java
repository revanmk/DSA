//Brute
/*class Solution {
    public int kthGrammar(int n, int k) {
        if(k==1){
            return 0;
        }
        String str="0";
        for(int i=2;i<=n;i++){
            String curr="";
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='0'){
                    curr+="01";
                }else{
                    curr+="10";
                }
            }
            str=curr;
        }
        return str.charAt(k-1)-'0';
    }
}*/
//Optimal
class Solution{
    public int kthGrammar(int n, int k) {
        if(k==1){
            return 0;
        }
        int mid = (int)Math.pow(2,n-1)/2;
        if(k<=mid){
            return kthGrammar(n-1,k);
        }
        else{
            return Math.abs(kthGrammar(n-1,k-mid)-1);
        }
    }
}