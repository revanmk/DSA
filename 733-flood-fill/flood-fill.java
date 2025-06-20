class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<>();
        int rows = image.length;
        int cols = image[0].length;
        int c=image[sr][sc];
        if (c == color) return image;

        image[sr][sc]=color;
        q.offer(new Pair(sr,sc));
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!q.isEmpty()){
            int len=q.size();
            while(len-->0){
                Pair p= q.poll();
                for (int[] dir : dirs) {
                int newX = p.x + dir[0];
                int newY = p.y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && image[newX][newY] == c) {
                    image[newX][newY] = color;
                    q.offer(new Pair(newX, newY));
                }
                
                }
            }
        }
        return image;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}