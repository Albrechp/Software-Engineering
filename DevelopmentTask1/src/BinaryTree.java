public class BinaryTree
{
    private static Node root;

    public BinaryTree(int data){
        
    	root = new Node(data);
    }

    public Node getRoot()
    {
        return root;
    }
    
    public void add(Node parent, Node child, String orientation)
    {
        if (orientation.equals("left"))
        {
           parent.setLeft(child);
        }
        else
        {
            parent.setRight(child);
        }
    }
    
    public Node findParent(Node node)
    {
    	return lookForNode(root, node);
    }
    
    private Node lookForNode(Node node, Node matchNode)
    {
        if ((node.getLeft() != null && node.getLeft() == matchNode) || (node.getRight() != null && node.getRight() == matchNode))
        {
        	return node;
        }
        else
        {
        	if (node.getLeft() != null && lookForNode(node.getLeft(), matchNode) != null)
            {
        		return lookForNode(node.getLeft(), matchNode);
            }
        	else if (node.getRight() != null && lookForNode(node.getRight(), matchNode) != null)
        	{
        		return lookForNode(node.getRight(), matchNode);
        	}
        	else
        	{
        		return null;
        	}
        }
    }
    
    public Node lowestCommonAncestor(Node node1, Node node2)
    {
        if (node1 == node2 || lookForNode(node1, node2) != null)
        {
        	return node1;
        }
        else if (findParent(node1) == null)
        {
        	return null;
        }
        else 
        {
        	return lowestCommonAncestor(findParent(node1), node2);
        }
    }
    
/*    public static void print(Node node, String s)
    {
        
        System.out.print(node.getKey());
        
        if (node.getLeft() != null)
        {
        	System.out.print("---");
        	print(node.getLeft(), "");
        }
        if (node.getRight() != null)
        {
        	System.out.print("\n" + s + " |--");
        	print(node.getRight(), "    ");
        }
        
    }*/
}

class Node {
	
    private int key;
    private Node left;
    private Node right;

    Node (int key) {
        this.key = key;
        right = null;
        left = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right ) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

}