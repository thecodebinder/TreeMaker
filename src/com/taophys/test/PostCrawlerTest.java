package com.taophys.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.taophys.main.Crawler;
import com.taophys.main.Node;
import com.taophys.main.PostCrawler;
import com.taophys.main.Tree;

public class PostCrawlerTest {
	Tree tree;
	Node root;
	Node one;
	Node two;
	Node three;
	Node four;
	Node five;
	
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
	public void testNext() {
		tree.addChild(root, one);
		tree.addChild(root, two);
		tree.addChild(one, three);
		tree.addChild(one, four);
		tree.addChild(two, five);
		
		Crawler crawler = new PostCrawler(tree);
		
		assertSame(crawler.next(), three);
		assertSame(crawler.next(), four);
		assertSame(crawler.next(), one);
		assertSame(crawler.next(), five);
		assertSame(crawler.next(), two);
		assertSame(crawler.next(), root);
	}
	
	@Test
	public void testNext2() {
		tree.addChild(root, one);
		tree.addChild(root, two);
		tree.addChild(one, three);
		tree.addChild(one, four);
		tree.addChild(one, five);
		tree.addChild(two, new Node(6));
		tree.addChild(four, new Node(7));
		tree.addChild(four, new Node(8));
		
		Crawler crawler = new PostCrawler(tree);
		
		assertEquals(crawler.next().getData(), 3);
		assertEquals(crawler.next().getData(), 7);
		assertEquals(crawler.next().getData(), 8);
		assertEquals(crawler.next().getData(), 4);
		assertEquals(crawler.next().getData(), 5);
		assertEquals(crawler.next().getData(), 1);
		assertEquals(crawler.next().getData(), 6);
		assertEquals(crawler.next().getData(), 2);
		assertSame(crawler.next(), root);
	}
	
	@Test
	public void testHasNext(){
		tree.addChild(root, one);
		
		Crawler crawler = new PostCrawler(tree);
		
		assertTrue(crawler.hasNext());
		crawler.next();
		assertTrue(crawler.hasNext());
		crawler.next();
		assertFalse(crawler.hasNext());
	}

}
