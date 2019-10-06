import java.lang.Integer;
class MatrixChainMultiplication{

	static int MatrixChainOrder(int p[]){
		int len=p.length;
		int[][] M=new int[len][len];

		for(int i=1;i<len;i++)
			M[i][i]=0;

		for(int cl=2;cl<len;cl++){     // runs number of diagonal(above principal daigonal) times
			for(int i=1;i<len-cl+1;i++){ //row number
				int j=i+cl-1;//col number
				//if(j == len) continue;
				M[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++){
					int q=M[i][k]+M[k+1][j]+p[i-1]*p[k]*p[j];
					if (q < M[i][j]) 
                        M[i][j] = q; 
				}
			}
		}
		return M[1][len-1];
	}


	public static void main(String args[]) 
    { 
        int[] p = {1,2,1,4,1}; 

        int result=MatrixChainOrder(p);
  
        System.out.println("Minimum number of multiplications is "+ result); 
  
    }	
}
