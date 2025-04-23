class Solution {
    public boolean exist(char[][] board, String word) {
       int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(board,i, j,0, visited,word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,int i,int j,int index,boolean visited[][],String word){
        if(index==word.length())
            return true;
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length|| board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j]=true;
        boolean found=  search(board,i,j+1,index+1,visited,word)||
                        search(board,i,j-1,index+1,visited,word)||
                        search(board,i+1,j,index+1,visited,word)||
                        search(board,i-1,j,index+1,visited,word);
        visited[i][j]=false;
        return found;

       }
}