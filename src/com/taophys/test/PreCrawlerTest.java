package com.taophys.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.taophys.main.Crawler;
import com.taophys.main.Node;
import com.taophys.main.PreCrawler;
import com.taophys.main.Tree;

public class PreCrawlerTest {
	Tree tree;
	Node root;
	Node one;
	Node two;
	Node three;
	Node four;
	Node five;
	@Before
	public void setUp() {
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
	public void testNext() {
		tree.addChild(root, one);
		tree.addChild(root, two);
		tree.addChild(one, three);
		tree.addChild(one, four);
		tree.addChild(four, five);
		
		PreCrawler crawler = new PreCrawler(tree);
		
		assertSame(crawler.next(), root);
		assertSame(crawler.next(), one);
		assertSame(crawler.next(), three);
		assertSame(crawler.next(), four);
		assertSame(crawler.next(), five);
		assertSame(crawler.next(), two);
	}
	
	@Test
	public void testNext2(){
		
		tree.addChild(root, one);
		tree.addChild(one, two);
		tree.addChild(one, three);
		tree.addChild(one, four);
		tree.addChild(three, five);
		
		Crawler crawler = new PreCrawler(tree);
		
		assertSame(crawler.next(), root);
		assertSame(crawler.next(), one);
		assertSame(crawler.next(), two);
		assertSame(crawler.next(), three);
		assertSame(crawler.next(), five);
		assertSame(crawler.next(), four);
	}
	
	@Test
	public void testHasNext(){
		tree.addChild(root, one);
		tree.addChild(root, two);
		
		Crawler crawler = new PreCrawler(tree);
		
		assertTrue(crawler.hasNext());
		assertSame(crawler.next(), root);
		assertTrue(crawler.hasNext());
		assertSame(crawler.next(), one);
		assertTrue(crawler.hasNext());
		assertSame(crawler.next(), two);
		assertFalse(crawler.hasNext());
	}

}
