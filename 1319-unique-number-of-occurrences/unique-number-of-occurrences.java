class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
                hs.put(arr[i],hs.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> hm=new HashSet<>();
        for(int key:hs.keySet()){
            if(hm.contains(hs.get(key)))
                return false;
            else
                hm.add(hs.get(key));
        }
        return true;
    }
}