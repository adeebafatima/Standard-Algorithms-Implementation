import java.util.Scanner;
class LongestIncreasingSubsequence{
	
	static int lis(int arr[],int N){
	    int dp[]=new int[N];
	    	for(int a=0;a<N;a++)
	        	dp[a]=1;

	    for(int i=1;i<N;i++){
	        for(int j=0;j<i;j++){
	            if(arr[j]<arr[i])
	                dp[i]=Math.max(dp[i],1+dp[j]);      
	        }
	    }
	    
	    int answer=dp[0];
	    for(int b=0;b<N;b++){
	        if(dp[b]>answer)
	        	answer=dp[b];
	    }
	    return answer;
	     
	}

	public static void main (String[] args){
	 
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the size of array");
		int N=scan.nextInt();
		int arr[]=new int[N];
		System.out.println("Enter the elements of array");
		for(int i=0;i<N;i++)
			arr[i]=scan.nextInt();
		int result=LongestIncreasingSubsequence.lnds(arr,N);
		System.out.println("Size of LIS: "+result);
	}
}
