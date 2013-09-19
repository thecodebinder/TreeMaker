package com.taophys.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.taophys.main.Node;

public class NodeTest {
	
	@Test
	public void testNode(){
		Node node = new Node();
		
		assertNotNull(node.getChildren());
	}

	@Test
	public void testAddChild() {
		Node child = new Node();
		Node parent = new Node();
		
		parent.addChild(child);
		assertTrue(parent.getChildren().contains(child));
	}

}
