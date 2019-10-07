import java.util.ArrayList;
class DFS{


	static void addEdge(ArrayList<ArrayList<Integer>> adjList,int u,int v){
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

	static void dfs(ArrayList<ArrayList<Integer>> adjList,int s,boolean visited[]){
		visited[s]=true;
		System.out.print(s);
		for(int i=0;i<adjList.get(s).size();i++){
			int adj_node=adjList.get(s).get(i);
			if(!visited[adj_node]){
				dfs(adjList,adj_node,visited);
			}
		}

	}

	public static void main(String args[]){

		int V=6;
		ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>(V+1);

		for(int i=0;i<=V;i++)
			adjList.add(new ArrayList<Integer>());

		addEdge(adjList,1,2);
		addEdge(adjList,1,3);
		addEdge(adjList,2,4);
		addEdge(adjList,2,5);
		addEdge(adjList,3,5);
		addEdge(adjList,4,5);
		addEdge(adjList,4,6);
		addEdge(adjList,5,6);

		boolean visited[]=new boolean[V+1];

		for(int i=0;i<=V;i++)
			visited[i]=false;

		dfs(adjList,1,visited);
	}
}