class Solution {
    public static boolean checkEqual(int[] a, int[] b) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:a){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(int ele:b){
            if(!map.containsKey(ele)){
                return false;
            }
            map.put(ele,map.get(ele)-1);
            if(map.get(ele)==0){
                map.remove(ele);
            }
        }
        return map.isEmpty();
    }
}