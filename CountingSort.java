import java.util.Scanner;
class CountingSort{

	public static int[] countingSort(int A[],int B[],int k){
		int C[]=new int[k];
		for(int i=0;i<k;i++)
			C[i]=0;
		for(int j=0;j<A.length;j++)
			C[A[j]]++;
		for(int i=1;i<k;i++)
			C[i]=C[i]+C[i-1];
		for(int j=A.length-1;j>=0;j--){
			B[C[A[j]]-1]=A[j];
			C[A[j]]=C[A[j]]-1;
		}

		return B;

	}

	public static void main(String args[]){

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the range k ");
		int k=scan.nextInt();
		System.out.println("Enter number of elements of array: ");
		int N=scan.nextInt();
		System.out.println("Enter unsorted array(Each array element should lie between 0 to k)");
		int[] A = new int[N];
		int[] B = new int[N];
		for(int i=0;i<N;i++){
			A[i]=scan.nextInt();
		}
		System.out.println("Unsorted Array ");
		for(int i=0;i<N;i++)
			System.out.print(A[i]+" ");
		System.out.println();
		int result[]=countingSort(A,B,k+1);
		System.out.println("Sorted Array ");
		for(int i=0;i<N;i++){
			System.out.print(result[i]+" ");
		}
	}	
}