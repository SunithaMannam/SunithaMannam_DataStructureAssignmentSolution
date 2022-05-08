package com.gl.problem.bst;

/* Node Defitniton*/
class Node {
	int val;
	Node left, right;
 
	Node(int item) {
		val = item;
		left = right = null;
	}
}

public class BinaryTreeToSkewedTree {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void covertToSkewedTree(Node root, int order) {
	 
		if (root == null) {
			return;
		}

 
		if (order > 0) {
			covertToSkewedTree(root.right, order);
		} else {
			covertToSkewedTree(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
 
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

 
		if (order > 0) {
			covertToSkewedTree(leftNode, order);
		} else {
			covertToSkewedTree(rightNode, order);
		}
	}

	static void displaySkewedTree(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		displaySkewedTree(root.right);
	}

	public static void main(String[] args) {
 
		BinaryTreeToSkewedTree tree = new BinaryTreeToSkewedTree();
 
 		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(55);
		
		int order = 0;
		covertToSkewedTree(node, order);
		displaySkewedTree(headNode);
	}

}
