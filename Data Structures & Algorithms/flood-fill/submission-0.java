class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
      int ori = image[sr][sc];
      if(ori == color)
        return image;

        int m = image.length, n = image[0].length;

        floodFillUtil(image, sr, sc, ori, color, m, n);

        return image;
    }

    public void floodFillUtil(int [][]image, int r, int c, int ori, int color, int m, int n)
    {
        if(r<0 || r>=m || c<0 || c>=n || image[r][c]!=ori)
        return;

        image[r][c] = color;

        floodFillUtil(image, r+1, c, ori, color, m, n);
        floodFillUtil(image, r-1, c, ori, color, m, n);
        floodFillUtil(image, r, c+1, ori, color, m, n);
        floodFillUtil(image, r, c-1, ori, color, m, n);
    }
}