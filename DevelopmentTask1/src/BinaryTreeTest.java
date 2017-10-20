import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class BinaryTreeTest{
		 
	Node n1 = new Node(1);
	Node n2 = new Node(4);
	Node n3 = new Node(2);
	Node n4 = new Node(5);
	Node n5 = new Node(6);
	Node n6 = new Node(7);
	Node n7 = new Node(8);

	BinaryTree tree = new BinaryTree(3); 
	
	public BinaryTreeTest(){
	
		tree.add(tree.getRoot(), n1, "left"); 
		tree.add(tree.getRoot(), n2, "right"); 
		tree.add(n2, n3, "left"); 
		tree.add(n2, n4, "right"); 
		tree.add(n3, n5, "left"); 
		tree.add(n3, n6, "right"); 
		tree.add(n6, n7, "right"); 
		
		//			3
		//		   / \
		//		  1   4
		//           / \
		//          2   5
		//         / \
		//        6   7
		//             \
		//              8
	}
	
	@Test
	public void testTree() {

	     Assert.assertEquals(tree.getRoot().getKey(), 3);
	     Assert.assertEquals(tree.getRoot().getLeft(), n1);
	     Assert.assertEquals(tree.getRoot().getLeft().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getLeft().getRight(), null);
	     Assert.assertEquals(tree.getRoot().getRight(), n2);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft(), n3);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getLeft(), n5);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getLeft().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getLeft().getRight(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getRight(), n6);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getRight().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getRight().getRight(), n7);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getRight().getRight().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getRight().getRight().getRight(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getRight(), n4);
	     Assert.assertEquals(tree.getRoot().getRight().getRight().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getRight().getRight(), null);
	}


	@Test
	public void testFindParent() {
		
	     Assert.assertEquals(tree.findParent(n7), n6);
	     Assert.assertEquals(tree.findParent(n6), n3);
	     Assert.assertEquals(tree.findParent(n5), n3);
	     Assert.assertEquals(tree.findParent(n3), n2);
	     Assert.assertEquals(tree.findParent(n4), n2);
	     Assert.assertEquals(tree.findParent(n2), tree.getRoot());
	     Assert.assertEquals(tree.findParent(n1), tree.getRoot());
	     Assert.assertEquals(tree.findParent(tree.getRoot()), null);
	}
	
	@Test
	public void testLowestCommonAncestor() {

		
		Assert.assertEquals(tree.lowestCommonAncestor(n7, n7), n7);
		Assert.assertEquals(tree.lowestCommonAncestor(n6, n7), n6);
		Assert.assertEquals(tree.lowestCommonAncestor(n5, n7), n3);
		Assert.assertEquals(tree.lowestCommonAncestor(n3, n7), n3);
		Assert.assertEquals(tree.lowestCommonAncestor(n4, n7), n2);
		Assert.assertEquals(tree.lowestCommonAncestor(n2, n7), n2);
		Assert.assertEquals(tree.lowestCommonAncestor(n1, n7), tree.getRoot());
		Assert.assertEquals(tree.lowestCommonAncestor(tree.getRoot(), n7), tree.getRoot());
		
		Node n8 = new Node(9);
		
		Assert.assertEquals(tree.lowestCommonAncestor(n8, n7), null);

	}

}
