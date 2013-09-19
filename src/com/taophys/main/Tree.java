package com.taophys.main;

/**
 * This class handles the tree as a whole and functions
 * related to inter-node operations.
 * 
 * The default maximum children per node is 2 for a Binary
 * Tree.
 * @author Andrew Binder
 *
 */
public class Tree {
	private Node root;
	private int defaultMaxChildren = 2;
	/**
	 * This adds a child to a specified node designated "parent" by
	 * setting adding the child to the parent's children list and 
	 * designating the parent in the child Node.
	 * @param parent
	 * @param child
	 */
	public void addChild(Node parent, Node child) {
		child.setParent(parent);
		child.setMaxChildren(defaultMaxChildren);
		parent.addChild(child);
		
	}
	/**
	 * Adds children according to breadth-first rules...
	 * 						1
	 * 					  /   \
	 * 					 2		3
	 * 				    / \	   / \
	 * 				   4  5	  6   7
	 * 
	 * @param child
	 */
	public void addChildByBreadth(Node child) {
		BreadthCrawler crawler = new BreadthCrawler(this);
		Node node;
		
		while(crawler.hasNext()){
			node = crawler.next();
			if(!node.isFull()) {
				addChild(node, child);
				return;
			}
		}
	}
	/**
	 * Finds and returns the designated node.
	 * @param nodeToFind
	 * @return
	 */
	public Node getNode(Node nodeToFind ) {
		BreadthCrawler crawler = new BreadthCrawler(this);
		Node node;
		while(crawler.hasNext()){
			node = crawler.next();
			if(node == nodeToFind) return node;
		}
		return null;
	}
	/**
	 * Finds and returns the first node found by breadth-first
	 * order with the specified data.
	 * Comparison is done by Object.equals() method.
	 * @param data
	 * @return
	 */
	public Node getNodeEquals(Object data) {
		BreadthCrawler crawler = new BreadthCrawler(this);
		Node node;
		while(crawler.hasNext()){
			node = crawler.next();
			if(node.getData().equals(data)) return node;
		}
		return null;
	}
	/**
	 * Finds and returns the first node found by breadth-first
	 * order with specified data.
	 * Comparison is done by "==" method.
	 * @param data
	 * @return
	 */
	public Node getNodeSame(Object data) {
		BreadthCrawler crawler = new BreadthCrawler(this);
		Node node;
		while(crawler.hasNext()){
			node = crawler.next();
			if(node.getData() == data) return node;
		}
		return null;
	}
	/**
	 * Returns the root node.
	 * @return
	 */
	public Node getRoot() { return root; }
	/**
	 * Sets the root node.
	 * @param root
	 */
	public void setRoot(Node root) { this.root = root; }
	/**
	 * Sets the default maximum amount of children per node.
	 * This is important for automatic adding of children without
	 * specified parents.
	 * Individual nodes can have their max changed after construction
	 * and addtion to the tree.
	 * @param max
	 */
	public void setMaxChildren(int max) {
		defaultMaxChildren = max;
	}
	

}
