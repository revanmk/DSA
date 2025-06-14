class Solution {
public:
    int minMaxDifference(int num) 
    {
        string s = to_string(num);
        int n = s.size();
        int i=0;
        for(i=0;i<n;i++)
            if(s[i] < '9')
                break;
        if(i==n)
            return num;
        string maxi = s,mini = s;
        for(int j=0;j<n;j++)
        {
            if(maxi[j] == s[i])
                maxi[j] = '9';
            if(mini[j] == s[0])
                mini[j] = '0';
        }
        return stoi(maxi) - stoi(mini);
    }
};