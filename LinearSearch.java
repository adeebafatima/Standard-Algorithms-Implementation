import java.util.Scanner;
class LinearSearch{ 

	int linearSearch(int A[],int n,int item){
		for(int i=0;i<n;i++){
			if(A[i]==item)
				return i;
		}
		return -1;
	}

	public static void main(String args[]){

	Scanner scan=new Scanner(System.in);
	System.out.println("Enter number of elements in the array");
	int N=scan.nextInt();
	int inputedArray[]=new int[N];
	System.out.println("Enter elements in the array");
	for(int i=0;i<N;i++)
		inputedArray[i]=scan.nextInt();
	System.out.println("Enter item to be searched");
	int itemTobeSearched=scan.nextInt();
	
	LinearSearch isearch=new LinearSearch();
	int result=isearch.linearSearch(inputedArray,N,itemTobeSearched);
	if(result==-1)
		System.out.println("Searched item is not present");
	else
		System.out.println("Item found at "+result);	

	}

	
}