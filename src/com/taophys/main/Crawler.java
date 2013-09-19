package com.taophys.main;

/**
 * This interface governs iterator style "crawlers"
 * which can be used to easily traverse the tree.
 * @author Andrew Binder
 *
 */
public interface Crawler {
	/**
	 * Method for determining if the crawler has anywhere to go.
	 * @return
	 */
	public boolean hasNext();
	/**
	 * Method for returning the next Node in the crawlers path.
	 * @return
	 */
	public Node next();
	/**
	 * Method for removing a node from the tree.  
	 * TODO Possibly have multiple version of this method to enable different kinds of tree trimming.
	 */
	public void remove();
	
}
