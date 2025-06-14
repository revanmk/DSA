class Solution {
public:
    int minimizeXor(int num1, int num2) 
    {
        int n1 = 0 , n2 = 0;
        for(int i=0;i<31;i++)
        {
            if( (num1 >> i) & 1 )
                n1++;
            if( (num2 >> i) & 1 )
                n2++;
        }
        if(n1 > n2)
        {
            for(int i=0,d = n1 - n2;i<31 && d>0;i++)
                if( (num1>>i) & 1 )
                {
                    num1 = num1 ^ (1<<i);
                    d--;
                }
        }
        else if(n1 == n2)
            return num1;
        else
        {
            int d = n2 - n1;
            for(int i=0; i<31 && d>0 ;i++)
                if(! ( (num1 >> i) & 1 ) )
                {
                    d--;
                    num1 = num1 ^ (1<<i);
                }
        }
        return num1;
        /*
        n1      n2 
            >
            remove left most d bits
            == 
            returnback num1 
            <
            continuous bits of n2
        */
    }
};