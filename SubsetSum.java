class SubsetSum{

	//Returns true if there is a subset of  
    // set[] with sum equal to given sum 
	static boolean ss(int set[],int sum,int n){

		// The value of dp[i][j] will be 
        // true if there is a subset of  
        // set[0..j-1] with sum equal to i 
		boolean dp[][]=new boolean[sum+1][n+1];

		// If sum is 0, then answer is true 
		for(int i=0;i<n+1;i++)
			dp[0][i]=true;

		// If sum is not 0 and set is empty, 
        // then answer is false 
		for(int i=1;i<sum+1;i++)
			dp[i][0]=false;


		for(int i=1;i<sum+1;i++){
			for(int j=1;j<n+1;j++){
				if (i >= set[j-1])
					dp[i][j] = dp[i][j-1] || dp[i - set[j-1]][j-1]; //If current sum i is greater than current set value
																	// 2 options are there include it or leave it
				else
					dp[i][j]=dp[i][j-1]; //If current sum i is less than current set value dont include it
										// (When sum itself is less than current set value)

			}
		}
		return dp[sum][n];

	}

	public static void main(String args[]){
		int set[]={3, 34, 4, 12, 5, 2};
		int sum=9;
		int n=set.length;
		boolean result=ss(set,sum,n);
		System.out.println(result);

	}
}