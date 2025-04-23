class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int maxi=0;
        for(int i=1;i<=n;i++)
        {
            int sum=digitSum(i);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
            maxi=Math.max(maxi,hm.get(sum));
        }
        int count=0;
        for(int val:hm.values())
        {
            if(val==maxi)
                count++;
        }
        return count;
    }
    public int digitSum(int num)
    {
        int ans=0;
        while(num>0)
        {
            int temp=num%10;
            ans+=temp;
            num=num/10;
        }
        return ans;
    }
}