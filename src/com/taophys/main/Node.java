package com.taophys.main;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the Node class which holds the data on the tree.
 * @author Andrew Binder
 *
 */
public class Node {
	private Node parent;
	private List<Node> children;
	private int maxChildren;
	private Object data;
	/**
	 * Constructor for setting the data easily.
	 * @param data
	 */
	public Node(Object data) {
		initNode();
		this.data = data;
	}
	/**
	 * Basic constructor.
	 */
	public Node(){
		initNode();
	}
	/**
	 * Initializes all of the variables.
	 * Only to be used in constructors.
	 */
	private void initNode(){
		parent = null;
		maxChildren = 2;
		data = new Object();
		children = new ArrayList<Node>();
	}
	/**
	 * Sets the parent of this node.
	 * @param parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	/**
	 * Adds a child to this node.
	 * @param child
	 */
	public void addChild(Node child) {
		child.setParent(this);
		children.add(child);
	}
	/**
	 * Returns the parent Node for this child.
	 * @return
	 */
	public Node getParent() { return parent; }
	/**
	 * Returns the list of all child nodes.
	 * @return
	 */
	public List<Node> getChildren() { return children; }
	/**
	 * Sets the max children per node parameter, which is required
	 * for child addition at the tree level.
	 * @param maxChildrenPerNode
	 */
	public void setMaxChildren(int maxChildrenPerNode) {
		maxChildren = maxChildrenPerNode;
	}
	/**
	 * Returns false if there are no children.
	 * @return
	 */
	public boolean hasChildren() {
		if(children.size() == 0) return false;
		else return true;
	}
	/**
	 * Returns true if this node has the maximum number of children.
	 * @return
	 */
	public boolean isFull() {
		if(children.size() == maxChildren) return true;
		else return false;
	}
	/**
	 * Returns the data stored in this node.
	 * @return
	 */
	public Object getData() { return data; }

}
