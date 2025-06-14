class Solution {
public:
    vector<int> vec;
    Solution()
    {
        vec = vector<int>(46,-1);
        vec[0] = vec[1] = 1;
    }
    int climbStairs(int n) 
    {
        if(vec[n] == -1)
            vec[n] = climbStairs(n-1) + climbStairs(n-2);
        return vec[n];
    }
};