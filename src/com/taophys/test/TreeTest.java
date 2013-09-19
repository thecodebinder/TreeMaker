package com.taophys.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import com.taophys.main.Node;
import com.taophys.main.Tree;

public class TreeTest {
	private Tree tree;
	private Node root;
	private Node one;
	private Node two;
	private Node three;
	private Node four;
	private Node five;

	@Before
	public void setUp(){
		tree = new Tree();
		tree.setMaxChildren(2);
		root = new Node();
		tree.setRoot(root);
		
		one = new Node(1);
		two = new Node(2);
		three = new Node(3);
		four = new Node(4);
		five = new Node(5);
	}
	
	@Test
	public void testAddChildToRoot() {
		Node child = new Node();
		tree.addChild(root, child);
		assert(root.getChildren().contains(child));
		assertSame(child.getParent(), root);
	}
	
	@Test
	public void testGetNode(){
		
		root.addChild(one);
		root.addChild(two);
		one.addChild(three);
		
		assertSame(tree.getNode(one), one);
		assertSame(tree.getNode(two), two);
		assertSame(tree.getNode(three), three);
		
	}
	
	@Test
	public void testAddChildByBreadth(){
		tree.addChildByBreadth(one);
		tree.addChildByBreadth(two);
		tree.addChildByBreadth(three);
		tree.addChildByBreadth(four);
		tree.addChildByBreadth(five);
		
		assertTrue(one.getParent() == root);
		assertTrue(two.getParent() == root);
		assertTrue(three.getParent() == one);
		assertTrue(four.getParent() == one);
		assertTrue(five.getParent() == two);
	}
	
	@Test
	public void testGetNodeByDataEquals(){
		root.addChild(one);
		root.addChild(two);
		one.addChild(three);
		
		assertSame(tree.getNodeEquals(1), one);
		assertSame(tree.getNodeEquals(2), two);
		assertSame(tree.getNodeEquals(3), three);
		assertNotSame(tree.getNodeEquals(4), three);
	}
	@Test
	public void testGetNodeByDataSame(){
		Point point1 = new Point(1,0);
		Point point2 = new Point(2,0);
		Point point3 = new Point(3,0);
		Point point32 = new Point(3,0);
		one = new Node(point1);
		two = new Node(point2);
		three = new Node(point3);
		Node three2 = new Node(point32);
		
		root.addChild(one);
		root.addChild(two);
		one.addChild(three2);
		one.addChild(three);
		
		assertSame(tree.getNodeSame(point1), one);
		assertSame(tree.getNodeSame(point2), two);
		assertNotSame(tree.getNodeSame(point3), three2);
		assertSame(tree.getNodeSame(point3), three);
	}
	

}
