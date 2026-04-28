class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        boolean frow = false;
        boolean fcol = false;

        for(int i=0;i<m;i++)
        {
           if(matrix[i][0] == 0)
              {
                fcol = true;
                break;
              } 
        }


        for(int i=0;i<n;i++)
        {
            if(matrix[0][i] == 0)
            {
                frow = true;
            }
        }

      for(int i=0;i<m;i++)  
      {
        for(int j=0;j<n;j++)
        {
            if(matrix[i][j] == 0)
            {
                   matrix[0][j] = 0;
                   matrix[i][0] = 0;
            }
        }
      }

      for(int i=1;i<m;i++)
      {
        if(matrix[i][0] == 0)
        {
            Arrays.fill(matrix[i], 0);
        }
      }

      for(int j=1;j<n;j++)
      {
        if(matrix[0][j]==0)
        {
            for(int k=0;k<m;k++)
            {
                matrix[k][j]=0;
            }
        }
      }

      if(frow)
      {
        Arrays.fill(matrix[0], 0);
      }

      if(fcol)
      {
        for(int j=0;j<m;j++)
        {
            matrix[j][0]=0;
        }
      }

    }
}
