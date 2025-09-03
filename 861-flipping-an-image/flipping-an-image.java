class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
                int k=0;
                int l = image[i].length-1;
                while(k<=l){
                    int temp = image[i][k]^1;
                    image[i][k] = image[i][l]^1;
                    image[i][l] = temp;
                    k++;
                    l--;
                }
        }
        return image;
    }
}