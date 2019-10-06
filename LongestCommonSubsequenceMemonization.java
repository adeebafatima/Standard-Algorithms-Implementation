import java.util.Scanner;
class LongestCommonSubsequenceMemonization{

	static int lcs(String X,String Y,int m,int n,int[][] lookup){

		if(lookup[m][n]==-1){
			if(m==0||n==0)
				lookup[m][n]=0;
	        else if(X.charAt(m-1)==Y.charAt(n-1))
	            lookup[m][n]=1+lcs(X,Y,m-1,n-1,lookup);
	        else{
	            int a=lcs(X,Y,m,n-1,lookup);
	            int b=lcs(X,Y,m-1,n,lookup);
	            lookup[m][n]=(a>b)?a:b;
	        }
	    }
	    return lookup[m][n];  
	}

	public static void main(String args[]){

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter first string X");
		String X=scan.nextLine();
		System.out.println("Enter second string Y");
		String Y=scan.nextLine();

		int m=X.length();
		int n=Y.length();

		int[][] lookup=new int[m+1][n+1];

		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				lookup[i][j]=-1;
			}
		}

		int result=lcs(X,Y,m,n,lookup);
		System.out.println("Length of LCS ="+result);
		
		}

}