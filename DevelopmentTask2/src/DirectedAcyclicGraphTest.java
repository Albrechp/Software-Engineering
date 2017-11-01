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
}
