import java.lang.Math;
class LongestPalindromicSubsequence{

	static int lps(String str){

		int len=str.length();
		int P[][]=new int[len][len];

		for(int i=0;i<len;i++)
			P[i][i]=1;

		for(int cl=2;cl<=len;cl++){     // runs number of diagonal(above principal daigonal) times
			for(int i=0;i<len-cl+1;i++){ //row number
				int j=i+cl-1;//col number
			    if(str.charAt(i)==str.charAt(j) && cl==2){
			    	P[i][j]=2;
			    }
			    else if(str.charAt(i)==str.charAt(j)){
			    	P[i][j]=2+P[i+1][j-1];
			    }
			    else
			    	P[i][j]=Math.max(P[i+1][j],P[i][j-1]);
			}
		}
		return P[0][len-1];
	}



	public static void main(String args[]){
		String str="GEEKSFORGEEKS";
		int result=lps(str);
		System.out.println(result);
	}
}
