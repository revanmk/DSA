class Solution 
{   
    public boolean nozero(int n)
    {
        while(n!=0)
        {
            if(n%10 == 0)
                return false;
            n = n/10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) 
    {
        for(int i=1;i<=n/2;i++)
            if( nozero(i) && nozero(n-i) )
                return new int[]{i,n-i};
        return new int[]{n-1,1};
    }
}