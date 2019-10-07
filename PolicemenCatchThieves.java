import java.util.ArrayList;
class PolicemenCatchThieves{

	static int numberofThievesCaught(char[] c,int n,int k){

		int count=0;
		ArrayList<Integer> police=new ArrayList<Integer>();
		ArrayList<Integer> thieves=new ArrayList<Integer>();

		for(int i=0;i<n;i++){
			if(c[i]=='P')
				police.add(i);
			if(c[i]=='T')
				thieves.add(i);
		}

		int p=0,t=0;
		while(p<police.size() && t<thieves.size()){
			if((Math.abs(police.get(p)-thieves.get(t)))<=k){
				count++;
				p++;
				t++;
			}
			else if(police.get(p)<thieves.get(t))
				p++;
			else
				t++;
			
		}
		return count;

	}

	public static void main(String args[]){

		int n=6;
		char[] c={'P','T','P','T','T','P'}; 
		int k=3;
		int result=numberofThievesCaught(c,n,k);
		System.out.println("Number of thieves caught = "+result);

	}
}