class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a = count(tops[0], tops, bottoms);
        int b = count(bottoms[0], tops, bottoms);
        if (a == -1 && b == -1)
            return -1;
        else if (a == -1)
            return b;
        else if(b==-1)
            return a;
        return Math.min(a,b);
    }

    public int count(int val,int[] top,int[] bottom){
        int topcount=0;
        int bottomcount=0;
        for(int i=0;i<top.length;i++)
        {
            if(top[i]!=val && bottom[i]!=val)
                return -1;
            else if(bottom[i]!=val){
                bottomcount++;
            }
            else if(top[i]!=val){
                topcount++;
            }
        }
        return Math.min(topcount,bottomcount);
    }
}