
public class LowestCommonAncestor {

	public static void main(String[] args) {
		
		Node n1 = new Node(1);
	    Node n2 = new Node(4);
	    Node n3 = new Node(2);
	    Node n4 = new Node(5);

	    BinaryTree tree = new BinaryTree(3);  
	    tree.add(tree.getRoot(), n1, "left");  
	    tree.add(tree.getRoot(), n2, "right");  
	    tree.add(n2, n3, "left");  
	    tree.add(n2, n4, "right");  
	        
	    //tree.print(tree.getRoot(), "");
	    
	    System.out.println(tree.lowestCommonAncestor(n4, n1).getKey());
	}
}
