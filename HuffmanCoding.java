import java.util.PriorityQueue;
import java.util.Comparator; 
class HuffmanNode{

	char c;
	int data;
	HuffmanNode left;
	HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>{
	public int compare(HuffmanNode x,HuffmanNode y){
		return x.data-y.data;
	}
}

class HuffmanCoding{

	static void printCode(HuffmanNode root,String s){
		 if (root.left == null && root.right == null && Character.isLetter(root.c)) { 
            System.out.println(root.c + ":" + s); 
            return; 
        } 
  
        // if we go to left then add "0" to the code. 
        // if we go to the right add"1" to the code. 
  
        // recursive calls for left and 
        // right sub-tree of the generated tree. 
        printCode(root.left, s + "0"); 
        printCode(root.right, s + "1"); 
    }

	public static void main(String args[]){

		int n = 6; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        //Ste 1:Build min heap
        PriorityQueue<HuffmanNode> q=new PriorityQueue<HuffmanNode>(n,new MyComparator());
        //PriorityQueue(int initialCapacity, Comparator comparator):
        //Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
        for(int i=0;i<n;i++){
        	HuffmanNode node=new HuffmanNode();
        	node.c=charArray[i];
        	node.data=charfreq[i];
        	node.left=null;
        	node.right=null;
        	q.add(node);
        }

        HuffmanNode root = null;

        while(q.size()>1){

        	//Step 2:Extract min 1
        	HuffmanNode x=q.peek();
        	q.poll();

        	//Step 3:Extract min 2
        	HuffmanNode y=q.peek();
        	q.poll();

        	//Step 4:Create new node
     		HuffmanNode new_node=new HuffmanNode();
     		new_node.data=x.data+y.data;
     		new_node.c='-';
     		new_node.left=x;
     		new_node.right=y;

     		root=new_node;

     		//Step 5:Insert new node
     		q.add(new_node);

        }
        printCode(root,""); 
	}
	
}