import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
class BFS{

	static void addEdge(ArrayList<ArrayList<Integer>> adjList,int u,int v){
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

	static void bfs(ArrayList<ArrayList<Integer>> adjList,int V){

		boolean visited[] = new boolean[V+1];//to keep track of visited vertices

		for(int i=1;i<=V;i++)
			visited[i]=false;

		Queue<Integer> q = new LinkedList<>();
		 
		int s=1;
		visited[s]=true;
		q.add(s);

		while(q.size()!=0){
			s=q.poll();
			System.out.print(s+" ");

			for(int i=0;i<adjList.get(s).size();i++){
				int newNode=adjList.get(s).get(i);
				if(visited[newNode]==false){
					q.add(newNode);
					visited[newNode]=true;
				}
			}
		}

	}

	public static void main(String args[]){
		int V=6;
		ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>(V+1); //Graph having vertex 1,2,3,4,5,6

		for(int i=0;i<V+1;i++)
			adjList.add(new ArrayList<Integer>());

		addEdge(adjList,1,2);
		addEdge(adjList,1,3);
		addEdge(adjList,2,4);
		addEdge(adjList,2,5);
		addEdge(adjList,3,5);
		addEdge(adjList,4,5);
		addEdge(adjList,4,6);
		addEdge(adjList,5,6);

		bfs(adjList,V);
	}
}