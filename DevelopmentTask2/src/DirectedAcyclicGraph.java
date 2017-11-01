
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
    
    public Node lowestCommonAncestor(Node node1, Node node2)
    {
//        if (node1 == node2 || lookForNode(node1, node2) != null)
//        {
//        	return node1;
//        }
//        else if (findParent(node1) == null)
//        {
//        	return null;
//        }
//        else 
//        {
//        	return lowestCommonAncestor(findParent(node1), node2);
//        }
    	return null;
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