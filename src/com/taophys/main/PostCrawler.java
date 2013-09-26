package com.taophys.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * This crawler functions in a post-order iterative mode.
 *						 7
 *					   /   \
 *                    3     6
 *                   / \   / \ 
 *                  1   2 4   5
 * @author Andrew Binder
 *
 */
public class PostCrawler implements Crawler {
	
	private Tree tree;
	private Node root;
	private Node currentNode;
	private Stack<Node> stack;
	private List<Node> visited;
	private List<Node> children;
	/**
	 * Returns true if there is a next node to go to.
	 */
	@Override
	public boolean hasNext() {
		if(stack.isEmpty()) return false;
		else return true;
	}
	/**
	 * Returns the next node according to the post-order iteration.
	 * 
	 * Works by adding nodes to a stack and only removing/returning them when..
	 * 		a. The node is a leaf.
	 * 		b. All children of a node has been visited already
	 */
	@Override
	public Node next() {
		currentNode = stack.peek();
		if(currentNode.hasChildren()){
			children = currentNode.getChildren();
			if(visited.containsAll(children)){
				visited.add(currentNode);
				stack.pop();
				return currentNode;
			}
			for(int i = children.size()-1; i >= 0; i--){
				stack.push(children.get(i));
			}
			next();
		} else {
			visited.add(currentNode);
			stack.pop();
			return currentNode;
		}
		return currentNode;
	}
	public PostCrawler(Tree tree){
		this.tree = tree;
		this.root = tree.getRoot();
		this.currentNode = root;
		this.stack = new Stack<Node>();
		stack.push(root);
		this.visited = new ArrayList<Node>();
		this.children = new ArrayList<Node>();
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
