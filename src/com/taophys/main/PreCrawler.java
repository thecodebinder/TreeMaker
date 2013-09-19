package com.taophys.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * This crawler functions in a pre-order iterative mode.
 *						1
 *					   /  \
 *                    2     5
 *                   / \   / \ 
 *                  3   4 6   7
 * @author Andrew Binder
 *
 */
public class PreCrawler implements Crawler {
	Tree tree;
	Node root;
	Node currentNode;
	Stack<Node> stack;
	List<Node> children;

	public PreCrawler(Tree tree) {
		stack = new Stack<Node>();
		root = tree.getRoot();
		currentNode = root;
		stack = new Stack<Node>();
		children = new ArrayList<Node>();
	}
	/**
	 * Returns true if true if there is a next node available.
	 */
	@Override
	public boolean hasNext() {
		if(stack.isEmpty() && currentNode == null) return false;
		else return true;
	}

	/**
	 * Returns the next node according to pre-order iteration.
	 * 
	 * Works by moving down the "left" side of the tree and 
	 * sequentially added any sibling nodes to a stack which it
	 * then pops off to jump to when it hits the a dead-end.
	 */
	@Override
	public Node next() {
		if(currentNode.hasChildren()){
			children = currentNode.getChildren();
			if(currentNode == root && stack.isEmpty()){
				for(Node child : root.getChildren()){
					stack.push(child);
				}
				return root;
			}
			if(children.size() > 1) {
				for(int i = 1; i < children.size(); i++){
					stack.push(children.get(i));
				}
			}
			currentNode = children.get(0);
			return currentNode;
		} else {
			currentNode = stack.pop();
			return currentNode;
		}
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
