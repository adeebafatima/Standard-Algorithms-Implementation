import java.util.Scanner;
class BinarySearchRecursive{
	
	public static int binarySearch(int A[],int l,int u,int item ){
		
		if(l<=u){
			int mid=(l+u)/2;
			if(A[mid]==item)
				return mid+1;
			else if(A[mid]<item)
				return binarySearch(A,mid+1,u,item);
			else if(A[mid]>item)
				return binarySearch(A,l,mid-1,item);
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
		int result=binarySearch(A,0,N-1,item);
		if(result==-1)
			System.out.println("Searched item is not present");
		else
			System.out.println("Item present at "+ result);
	}
	
}