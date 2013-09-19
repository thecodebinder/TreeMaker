package com.taophys.main;

import java.util.ArrayList;
import java.util.List;
/**
 * This crawler functions in a breadth-first iterative mode.
 * 							 1
 * 						   /   \
 *                        2     3
 *                       / \   / \
 *                      4   5 6   7
 * @author Andrew Binder
 *
 */
public class BreadthCrawler implements Crawler {
	Tree tree;
	Node root;
	Node currentNode;
	List<Node> nodeList;
	/**
	 * Constructor for the crawler.
	 * Sets the tree, root, currentNode, nodeList, and
	 * adds the root to the nodeList.
	 * @param tree
	 */
	public BreadthCrawler(Tree tree){
		this.tree = tree;
		this.root = tree.getRoot();
		this.currentNode = root;
		this.nodeList = new ArrayList<Node>();
		nodeList.add(root);
	}
	/**
	 * Returns false if the nodeList is empty.
	 */
	@Override
	public boolean hasNext() {
		if(nodeList.isEmpty()) return false;
		else return true;
	}

	/**
	 * Returns the next node according to breadth-first order.
	 * 
	 * Works by popping the first node in a First In First Out
	 * style list which it then fills with the children of the node
	 * popped.
	 */
	@Override
	public Node next() {
		currentNode = nodeList.get(0);
		nodeList.remove(currentNode);
		if(currentNode.hasChildren()){
			for(Node child : currentNode.getChildren()){
				nodeList.add(child);
			}
		}
		return currentNode;
	
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}

}
