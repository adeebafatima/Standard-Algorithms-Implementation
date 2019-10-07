import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Activity{
	int startTime;
	int finishTime;
}

class ActivitySelectionProblem{

	static void activitySelection(Activity A[]){

		Arrays.sort(A, new Comparator<Activity>(){
            	@Override
            		public int compare (Activity a1, Activity a2) {
                		return a1.finishTime < a2.finishTime ? -1 : 1;
            		}
        	});

    		System.out.print("Following activities are selected: "); 
    		int i=0;
    		System.out.print("("+A[i].startTime+","+A[i].finishTime+")");
    		for(int j=1;j<A.length;j++){
    			if(A[j].startTime>=A[i].finishTime){
    				System.out.print(", ("+A[j].startTime+","+A[j].finishTime+") ");
    				i=j;
    			}
    		}
	}

	public static void main(String args[]){

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter number of activities");
		int N=scan.nextInt();
		Activity[] activities=new Activity[N];

		for(int i=0;i<N;i++){
			activities[i]=new Activity();
			System.out.println("Enter start time of Activity "+ i);
			activities[i].startTime=scan.nextInt();
			System.out.println("Enter finish time of Activity "+ i);
			activities[i].finishTime=scan.nextInt();

		}

		activitySelection(activities);
	}
}
