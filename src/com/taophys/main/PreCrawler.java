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

	/**
	 * Returns true if true if there is a next node available.
	 */
	@Override
	public boolean hasNext() {
		if(stack.isEmpty() && currentNode != root) return false;
		else return true;
	}
	/**
	 * Returns the next node according to pre-order iteration.
	 * 
	 * Works by moving down the "left" side of the tree and 
	 * sequentially pushes any sibling nodes to a stack in reverse
	 * order which it then pops off to jump to when it hits a dead-end.
	 */
	@Override
	public Node next() {
		if(currentNode == root){
			if(root.hasChildren() && stack.isEmpty()){
				children = root.getChildren();
				for(int i = children.size()-1; i >=0; i--){
					stack.push(children.get(i));
				}
				return root;
			}
			else if (!stack.isEmpty()){
				currentNode = stack.pop();
				return currentNode;
			}
		}
		
		if(currentNode.hasChildren()){
			children = currentNode.getChildren();
			if(currentNode != root && children.size() > 1) {
				for(int i = children.size()-1; i > 0; i--){
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
	public PreCrawler(Tree tree) {
		stack = new Stack<Node>();
		this.tree = tree;
		root = tree.getRoot();
		currentNode = root;
		stack = new Stack<Node>();
		children = new ArrayList<Node>();
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
