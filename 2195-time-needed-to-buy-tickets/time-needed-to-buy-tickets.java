class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int len = tickets.length;
        for(int i=0;i<=k;i++){
            time+=Math.min(tickets[k],tickets[i]);
        }
        for(int i=k+1;i<len;i++){
            time+=Math.min(tickets[k]-1,tickets[i]);
        }
        return time;
    }
}