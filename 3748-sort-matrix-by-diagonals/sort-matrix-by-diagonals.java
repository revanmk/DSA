class Solution {
    public int[][] sortMatrix(int[][] grid) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = grid.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int key = i-j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(grid[i][j]);
            }
        }

        for(int key : map.keySet()){
            List<Integer> temp = map.get(key);
            if(key<0){
                temp.sort((a,b)-> b-a);
            }else{
                temp.sort((a,b)->a-b);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int key = i - j;
                List<Integer> diag = map.get(key);
                grid[i][j] = diag.remove(diag.size() - 1); 
            }
        }

        return grid;
    }
}
