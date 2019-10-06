import java.util.Scanner;
class LongestCommonSubsequenceTabulation{

	static int lcs(String X,String Y){
		int m=X.length();
		int n=Y.length();

		int[][] dp=new int[m+1][n+1];

		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(X.charAt(i-1)==Y.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp[m][n];
	}

	public static void main(String args[]){

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter first string X");
		String X=scan.nextLine();
		System.out.println("Enter second string Y");
		String Y=scan.nextLine();

		int result=lcs(X,Y);
		System.out.println("Length of LCS ="+result);
		
		}

}