class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[]=new int[k];
        PriorityQueue<Pair> heap=new PriorityQueue<>((a,b)-> a.freq-b.freq);
        int len=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int ket:map.keySet()){
            heap.add(new Pair(ket,map.get(ket)));
            if (heap.size() > k) {
                heap.poll(); // remove least frequent element
            }
        }
        int i=0;
        while(k-->0){
            ans[i++]=heap.poll().key;
        }
        return ans;
        }
}
class Pair{
    int key;
    int freq;
    Pair(int key,int freq){
        this.key=key;
        this.freq=freq;
    }
}