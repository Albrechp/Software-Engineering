import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class LowestCommonAncestorTest extends LowestCommonAncestor{

	@Test
	public void test() {

		  Assert.assertTrue(true);
		  Assert.assertFalse(false);
		  Assert.assertEquals(false, false);
	}
	
	@Test
	public void testTree() {

		 Node n1 = new Node(1);
	     Node n2 = new Node(4);
	     Node n3 = new Node(2);
	     Node n4 = new Node(5);

	     BinaryTree tree = new BinaryTree(3); 
	     tree.add(tree.getRoot(), n1, "left"); 
	     tree.add(tree.getRoot(), n2, "right"); 
	     tree.add(n2, n3, "left"); 
	     tree.add(n2, n4, "right"); 
	     
	     Assert.assertEquals(tree.getRoot().getKey(), 3);
	     Assert.assertEquals(tree.getRoot().getLeft(), n1);
	     Assert.assertEquals(tree.getRoot().getLeft().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getLeft().getRight(), null);
	     Assert.assertEquals(tree.getRoot().getRight(), n2);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft(), n3);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getLeft().getRight(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getRight(), n4);
	     Assert.assertEquals(tree.getRoot().getRight().getRight().getLeft(), null);
	     Assert.assertEquals(tree.getRoot().getRight().getRight().getRight(), null);
	}


}
