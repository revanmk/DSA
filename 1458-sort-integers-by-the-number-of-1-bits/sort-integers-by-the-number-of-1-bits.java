class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(arr);
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();
        for(int num : arr){
            int freq = freqCount(num);
            map.computeIfAbsent(freq, k -> new ArrayList<>()).add(num);
        }
        for(int key : map.keySet()){
            List<Integer> t = map.get(key);
            l.addAll(t);
        }
        int[] ans = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }
    public static int freqCount(int n){
        int a = 0;
        while(n>0){
            a++;
            n=(n&(n-1));
        }
        return a;
    }
}