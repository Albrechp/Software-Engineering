import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class DirectedAcyclicGraphTest {

	Node node1 = new Node(1);
	Node node2 = new Node(2);
	Node node3 = new Node(3);
	Node node4 = new Node(4);
	Node node5 = new Node(5);
	Node node6 = new Node(6);
	Node node7 = new Node(7);
	Node node8 = new Node(8);
	Node node9 = new Node(9);

	DirectedAcyclicGraph graph;
	
	public DirectedAcyclicGraphTest(){
	
		graph = new DirectedAcyclicGraph(0);
		
		graph.addConnection(graph.root, node1);
		graph.addConnection(graph.root, node2);
		
		graph.addConnection(node1, node3);
		graph.addConnection(node2, node4);
		graph.addConnection(node2, node5);
		
		graph.addConnection(node3, node6);
		graph.addConnection(node4, node7);
		graph.addConnection(node4, node8);
		graph.addConnection(node5, node8);
		
		graph.addConnection(node6, node9);
		graph.addConnection(node7, node9);
		graph.addConnection(node8, node9);
	
		//		    0
		//		   / \
		//		  1   2
		//       /   / \
		//      3   4   5
		//     /   / \ /
		//    6   7   8
		//     \  |  /  
		//      \ | /
		//	      9    
	}
	
	@Test
	public void testGraph() {

	    Assert.assertEquals(graph.root.getKey(), 0);
	    Assert.assertEquals(graph.root.getParents().length, 0);
	    Assert.assertEquals(graph.root.getChildren().length, 2);
	    Assert.assertEquals(graph.root.getChildren()[0], node1);
	    Assert.assertEquals(graph.root.getChildren()[1], node2);
	    	    
	    Assert.assertEquals(node1.getKey(), 1);
	    Assert.assertEquals(node1.getParents().length, 1);
	    Assert.assertEquals(node1.getParents()[0], graph.root);
	    Assert.assertEquals(node1.getChildren().length, 1);
	    Assert.assertEquals(node1.getChildren()[0], node3);
	    
	    Assert.assertEquals(node2.getKey(), 2);
	    Assert.assertEquals(node2.getParents().length, 1);
	    Assert.assertEquals(node2.getParents()[0], graph.root);
	    Assert.assertEquals(node2.getChildren().length, 2);
	    Assert.assertEquals(node2.getChildren()[0], node4);
	    Assert.assertEquals(node2.getChildren()[1], node5);
	    
	    Assert.assertEquals(node3.getKey(), 3);
	    Assert.assertEquals(node3.getParents().length, 1);
	    Assert.assertEquals(node3.getParents()[0], node1);
	    Assert.assertEquals(node3.getChildren().length, 1);
	    Assert.assertEquals(node3.getChildren()[0], node6);
	    
	    Assert.assertEquals(node4.getKey(), 4);
	    Assert.assertEquals(node4.getParents().length, 1);
	    Assert.assertEquals(node4.getParents()[0], node2);
	    Assert.assertEquals(node4.getChildren().length, 2);
	    Assert.assertEquals(node4.getChildren()[0], node7);
	    Assert.assertEquals(node4.getChildren()[1], node8);
	    
	    Assert.assertEquals(node5.getKey(), 5);
	    Assert.assertEquals(node5.getParents().length, 1);
	    Assert.assertEquals(node5.getParents()[0], node2);
	    Assert.assertEquals(node5.getChildren().length, 1);
	    Assert.assertEquals(node5.getChildren()[0], node8);
	    
	    Assert.assertEquals(node6.getKey(), 6);
	    Assert.assertEquals(node6.getParents().length, 1);
	    Assert.assertEquals(node6.getParents()[0], node3);
	    Assert.assertEquals(node6.getChildren().length, 1);
	    Assert.assertEquals(node6.getChildren()[0], node9);
	    
	    Assert.assertEquals(node7.getKey(), 7);
	    Assert.assertEquals(node7.getParents().length, 1);
	    Assert.assertEquals(node7.getParents()[0], node4);
	    Assert.assertEquals(node7.getChildren().length, 1);
	    Assert.assertEquals(node7.getChildren()[0], node9);
	    
	    Assert.assertEquals(node8.getKey(), 8);
	    Assert.assertEquals(node8.getParents().length, 2);
	    Assert.assertEquals(node8.getParents()[0], node4);
	    Assert.assertEquals(node8.getParents()[1], node5);
	    Assert.assertEquals(node8.getChildren().length, 1);
	    Assert.assertEquals(node8.getChildren()[0], node9);
	    
	    Assert.assertEquals(node9.getKey(), 9);
	    Assert.assertEquals(node9.getParents().length, 3);
	    Assert.assertEquals(node9.getParents()[0], node6);
	    Assert.assertEquals(node9.getParents()[1], node7);
	    Assert.assertEquals(node9.getParents()[2], node8);
	    Assert.assertEquals(node9.getChildren().length, 0);
	}
	
	@Test
	public void testhasDescendant() {
				
		Assert.assertEquals(graph.hasDescendant(graph.root, graph.root), 0);
		Assert.assertEquals(graph.hasDescendant(graph.root, node1), 1);
		Assert.assertEquals(graph.hasDescendant(graph.root, node2), 1);		
		Assert.assertEquals(graph.hasDescendant(graph.root, node3), 2);
		Assert.assertEquals(graph.hasDescendant(graph.root, node4), 2);
		Assert.assertEquals(graph.hasDescendant(graph.root, node5), 2);
		Assert.assertEquals(graph.hasDescendant(graph.root, node6), 3);
		Assert.assertEquals(graph.hasDescendant(graph.root, node7), 3);
		Assert.assertEquals(graph.hasDescendant(graph.root, node8), 3);
		Assert.assertEquals(graph.hasDescendant(graph.root, node9), 4);
		
		Assert.assertEquals(graph.hasDescendant(node1, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node1, node1), 0);
		Assert.assertEquals(graph.hasDescendant(node1, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node1, node3), 1);
		Assert.assertEquals(graph.hasDescendant(node1, node4), -1);
		Assert.assertEquals(graph.hasDescendant(node1, node5), -1);
		Assert.assertEquals(graph.hasDescendant(node1, node6), 2);
		Assert.assertEquals(graph.hasDescendant(node1, node7), -1);
		Assert.assertEquals(graph.hasDescendant(node1, node8), -1);
		Assert.assertEquals(graph.hasDescendant(node1, node9), 3);

  		Assert.assertEquals(graph.hasDescendant(node2, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node2, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node2, node2), 0);
		Assert.assertEquals(graph.hasDescendant(node2, node3), -1);
		Assert.assertEquals(graph.hasDescendant(node2, node4), 1);
		Assert.assertEquals(graph.hasDescendant(node2, node5), 1);
		Assert.assertEquals(graph.hasDescendant(node2, node6), -1);
		Assert.assertEquals(graph.hasDescendant(node2, node7), 2);
		Assert.assertEquals(graph.hasDescendant(node2, node8), 2);
		Assert.assertEquals(graph.hasDescendant(node2, node9), 3);

		Assert.assertEquals(graph.hasDescendant(node3, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node3, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node3, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node3, node3), 0);
		Assert.assertEquals(graph.hasDescendant(node3, node4), -1);
		Assert.assertEquals(graph.hasDescendant(node3, node5), -1);
		Assert.assertEquals(graph.hasDescendant(node3, node6), 1);
		Assert.assertEquals(graph.hasDescendant(node3, node7), -1);
		Assert.assertEquals(graph.hasDescendant(node3, node8), -1);
		Assert.assertEquals(graph.hasDescendant(node3, node9), 2);

		Assert.assertEquals(graph.hasDescendant(node4, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node4, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node4, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node4, node3), -1);
		Assert.assertEquals(graph.hasDescendant(node4, node4), 0);
		Assert.assertEquals(graph.hasDescendant(node4, node5), -1);
		Assert.assertEquals(graph.hasDescendant(node4, node6), -1);
		Assert.assertEquals(graph.hasDescendant(node4, node7), 1);
		Assert.assertEquals(graph.hasDescendant(node4, node8), 1);
		Assert.assertEquals(graph.hasDescendant(node4, node9), 2);

		Assert.assertEquals(graph.hasDescendant(node5, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node5, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node5, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node5, node3), -1);
		Assert.assertEquals(graph.hasDescendant(node5, node4), -1);
		Assert.assertEquals(graph.hasDescendant(node5, node5), 0);
		Assert.assertEquals(graph.hasDescendant(node5, node6), -1);
		Assert.assertEquals(graph.hasDescendant(node5, node7), -1);
		Assert.assertEquals(graph.hasDescendant(node5, node8), 1);
		Assert.assertEquals(graph.hasDescendant(node5, node9), 2);

		Assert.assertEquals(graph.hasDescendant(node6, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node3), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node4), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node5), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node6), 0);
		Assert.assertEquals(graph.hasDescendant(node6, node7), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node8), -1);
		Assert.assertEquals(graph.hasDescendant(node6, node9), 1);

		Assert.assertEquals(graph.hasDescendant(node7, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node3), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node4), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node5), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node6), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node7), 0);
		Assert.assertEquals(graph.hasDescendant(node7, node8), -1);
		Assert.assertEquals(graph.hasDescendant(node7, node9), 1);

		Assert.assertEquals(graph.hasDescendant(node8, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node3), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node4), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node5), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node6), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node7), -1);
		Assert.assertEquals(graph.hasDescendant(node8, node8), 0);
		Assert.assertEquals(graph.hasDescendant(node8, node9), 1);

		Assert.assertEquals(graph.hasDescendant(node9, graph.root), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node1), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node2), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node3), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node4), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node5), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node6), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node7), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node8), -1);
		Assert.assertEquals(graph.hasDescendant(node9, node9), 0);
		
	
	}
	
	@Test
	public void testLCA() {
		
  
		
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node1), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node2), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node3), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node4), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node5), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node6), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node7), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node8), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(graph.root, node9), graph.root);
	
		Assert.assertEquals(graph.lowestCommonAncestor(node1, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node1), node1);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node2), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node3), node1);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node4), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node5), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node6), node1);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node7), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node8), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node1, node9), node1);
		
		Assert.assertEquals(graph.lowestCommonAncestor(node2, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node1), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node2), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node3), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node4), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node5), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node6), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node7), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node8), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node2, node9), node2);
	
		Assert.assertEquals(graph.lowestCommonAncestor(node3, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node1), node1);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node2), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node3), node3);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node4), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node5), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node6), node3);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node7), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node8), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node3, node9), node3);
	
		Assert.assertEquals(graph.lowestCommonAncestor(node4, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node1), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node2), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node3), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node4), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node5), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node6), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node7), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node8), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node4, node9), node4);
	
		Assert.assertEquals(graph.lowestCommonAncestor(node5, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node1), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node2), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node3), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node4), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node5), node5);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node6), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node7), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node8), node5);
		Assert.assertEquals(graph.lowestCommonAncestor(node5, node9), node5);
	
		Assert.assertEquals(graph.lowestCommonAncestor(node6, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node1), node1);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node2), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node3), node3);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node4), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node5), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node6), node6);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node7), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node8), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node6, node9), node6);
		
		Assert.assertEquals(graph.lowestCommonAncestor(node7, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node1), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node2), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node3), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node4), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node5), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node6), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node7), node7);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node8), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node7, node9), node7);

		Assert.assertEquals(graph.lowestCommonAncestor(node8, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node1), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node2), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node3), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node4), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node5), node5);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node6), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node7), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node8), node8);
		Assert.assertEquals(graph.lowestCommonAncestor(node8, node9), node8);
		
		Assert.assertEquals(graph.lowestCommonAncestor(node9, graph.root), graph.root);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node1), node1);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node2), node2);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node3), node3);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node4), node4);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node5), node5);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node6), node6);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node7), node7);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node8), node8);
		Assert.assertEquals(graph.lowestCommonAncestor(node9, node9), node9);	
	}
}
