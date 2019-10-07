class MinimumCoinChange{


	static int minChange(int deno[],int rupee){
		int rupee_array[]=new int[rupee+1];
		rupee_array[0]=0;
		int min=0;
		for(int i=1;i<=rupee;i++){
			
			min=rupee_array[i-deno[0]];

			for(int j=0;j<deno.length;j++){
				if(i-deno[j]>=0){
					if(min>rupee_array[i-deno[j]])
						min=rupee_array[i-deno[j]];
				}
			}
					
			rupee_array[i]=1+min;

		}
		return rupee_array[rupee];
		
	}



	public static void main(String args[]){

		int m=3;
		int denominations[]={4,5};
		int rupee=22;

		int result=minChange(denominations,rupee);
		System.out.println("Minimum number of change coin required = "+result);



	}
}