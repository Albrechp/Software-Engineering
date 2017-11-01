
public class DirectedAcyclicGraph {
	
    public static Node root;

    public DirectedAcyclicGraph(int data){
        
    	root = new Node(data);
    }
    
    public void addConnection(Node parent, Node child)
    {
    	parent.addChildren(child);
    	child.addParent(parent);
    }
    
    public int hasDescendant(Node node, Node matchNode)
    {
    	if (node == matchNode)
    	{
    		return 0;
    	}
    	else
    	{
    		int i = 0 ;
	    	Node [] children = node.getChildren();
	    	int match = -1;
	    	
	    	while (i < children.length && match == -1)
	    	{
	    		if (children[i] == matchNode)
	    		{
	    			match = 1;
	    		}
	    		else
	    		{
	    			match = hasDescendant(children[i], matchNode);
	    			
	    			if (match != -1)
	    	    	{
	    	    		match = match + 1;
	    	    	}
	    		}
	    		
	    		i ++;
	    	}
	    		
	    	return match;	
    	}
    	
    }
    
    public Node lowestCommonAncestor(Node node1, Node node2)
    {
    	if (hasDescendant(node1, node2) >= 0)
    	{
    		return node1;
    	}
    	else if (node1.getParents().length == 0)
    	{
    		return null;
    	}
    	else 
    	{
    	  Node[] parents = node1.getParents();
    	  
    	  Node ancestor = null;
    	  int descendantCount = -1;
    	  
    	  for (int i = 0 ;( i < parents.length ); i ++)
    	  {
    		 Node pNode = lowestCommonAncestor(parents[i], node2);

    		 if (pNode != null && hasDescendant(pNode, node2) != -1)
    		 {
    			 int pCount = hasDescendant(pNode, node1);
    			 
     			 if (pCount < descendantCount || descendantCount == -1)
    			 {
     				ancestor = pNode; 
    				descendantCount = pCount;
    			 } 
    		 }
    	  }

    	  return ancestor;
    	}
    }
}

class Node {
	
    private int key;
    private Node[] parents;
    private Node[] children;

    Node (int key) {
        this.key = key;
        parents = new Node[0];
        children = new Node[0];
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void addParent(Node parent) {
    	
    	Node[] pList = new Node[this.parents.length + 1];
    	
    	for (int i = 0 ;(i < this.parents.length); i ++)
    	{
    		pList[i] = parents[i];
    	}
    	
    	pList[this.parents.length] = parent;
    	parents = pList;   	
    }

    public Node[] getParents() {
        return parents;
    }

    public void addChildren(Node child) {

    	Node[] cList = new Node[this.children.length + 1];
    	
    	for (int i = 0 ;(i < this.children.length); i ++)
    	{
    		cList[i] = children[i];
    	}
    	
    	cList[this.children.length] = child;
    	children = cList;   
    }

    public Node[] getChildren() {
        return children;
    }

}