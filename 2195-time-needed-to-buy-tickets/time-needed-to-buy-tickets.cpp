class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int count=1;
        int len=tickets.size();
        for(int i=0;i<k;i++){
            count+=min(tickets[i],tickets[k]);
        }
        for(int i=k;i<len;i++)
        {
            count+=min(tickets[k]-1,tickets[i]);
        }
        return count;
    }
};