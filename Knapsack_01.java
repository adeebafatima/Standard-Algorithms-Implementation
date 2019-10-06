class Knapsack_01{

	
	static int knapsack01(int[] profit,int[] weight,int n,int capacity){

		// The value of dp[i][j] will be 
        // max profit if there is a capacity i and number of available is j

		int dp[][]=new int[capacity+1][n+1];

		// If no item is available, then profit is 0 
		for(int i=0;i<n+1;i++)
			dp[0][i]=0;

		// If capacity of knapsack is 0 , then profit is 0
		for(int i=0;i<capacity+1;i++)
			dp[i][0]=0;


		for(int i=1;i<capacity+1;i++){
			for(int j=1;j<n+1;j++){
				if (i >= weight[j-1])
					dp[i][j] = Math.max(dp[i][j-1],profit[j-1]+dp[i - weight[j-1]][j-1]); //If current capacity i is greater than weight of item at j-1
																	// 2 options are there include it and have profit or leave it
				else
					dp[i][j]=dp[i][j-1]; //If current capacity i is less than the weight of item at j-1 dont include it
										// (When capacity itself is less than weight of item at j-1)

			}
		}
		return dp[capacity][n];

	}

	public static void main(String args[]){
		int profit[]={10,12,28};
		int weight[]={1,2,4};
		int n=profit.length;
		int Knapsack_size=6;
		int result=knapsack01(profit,weight,n,Knapsack_size);
		System.out.println("Maximum Profit = "+result);

	}
}