import java.util.Scanner;
class BinarySearchIterative{
	
	
	public static int binarySearch(int A[],int item){
		int lowerBound=0;
		int upperBound=A.length-1;
		
		while(lowerBound<=upperBound){
			int mid=(lowerBound+upperBound)/2;
			if(A[mid]>item)
				upperBound=mid-1;
			else if(A[mid]<item)
				lowerBound=mid+1;
			else if(A[mid]==item)
				return mid+1;
		}
		return -1;
		
	}
	
	public static void main(String args[]){
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter number of elements in sorted array: ");
		int N=scan.nextInt();
		System.out.println("Enter sorted array");
		int[] A = new int[N];
		for(int i=0;i<N;i++){
			A[i]=scan.nextInt();
		}
		System.out.println("Enter item to be searched");
		int item=scan.nextInt();
		int result=binarySearch(A,item);
		if(result==-1)
			System.out.println("Searched item is not present");
		else
			System.out.println("Item present at "+ result);
	}
	
	
	
}