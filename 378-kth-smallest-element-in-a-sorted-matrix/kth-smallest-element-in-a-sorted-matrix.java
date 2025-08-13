class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n =matrix.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(matrix[i][j],map.getOrDefault(matrix[i][j],0)+1);
            }
        }
        int count=k;
        for(int key : map.keySet()){
            int ele = key;
            int val = map.get(key);
            k-=val;
            if(k<=0){
                return ele;
            }
        }
        return 0;
    }
}