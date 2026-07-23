class CountSquares {
  private int[][] pointCount;
  private List<int[]> uniquePoint;

    public CountSquares() {
        pointCount = new int[1001][1001];
        uniquePoint = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        if(pointCount[x][y] == 0)
        {
            uniquePoint.add(point);
        }

        pointCount[x][y]++;
        
    }
    
    public int count(int[] point) {

        int x1 = point[0];
        int y1 = point[1];
        int totSquare = 0;

        for(int p[] : uniquePoint)
        {
            int x2 = p[0];
            int y2 = p[1];

            if(x1==x2 || y1==y2)
            continue;

            if(Math.abs(x1-x2)!=Math.abs(y1-y2))
            continue;

            int ways = pointCount[x2][y2] * pointCount[x1][y2] *
            pointCount[x2][y1];

            totSquare +=ways;

        }

    return totSquare;
        
    }
}
