package com.ethfoo.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTest {

	private class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}

	/*
	 *                   8
	 *                  / \
	 *                 5   11
	 *                / \   \
	 *               3   7   13
	 *                  /
	 *                 12                 
	 */
	public TreeNode buildBinaryTree(){
		TreeNode head = new TreeNode(8);
		head.left = new TreeNode(5);
		head.right = new TreeNode(11);
		head.left.left = new TreeNode(3);
		head.left.right = new TreeNode(7);
		head.right.right = new TreeNode(13);
		
		head.left.right.left = new TreeNode(12);
		
		return head;
	}
	
	/*
	 * 由前序遍历和中序遍历的结果，重建出该二叉数
	 */
	
	/*
	 * 输入一个数组，判断是否是某二叉搜索树的后序遍历结果
	 */
	public boolean isBST(int[] array, int len){
		return checkIsBST(array, 0, len-1);
	}
	
	public boolean checkIsBST(int[] array, int left, int right){
		if(array == null || left>right ) return false;
		
		int root = array[right];
		
		int i;
		for( i=left; i<right; i++){
			if( array[i] > root ){
				break;
			}
		}
		
		for( int j=i; j<right; j++){
			if( array[j] < root ){
				return false;
			}
		}
		
		//判断左子树是否是二叉搜索树
		boolean isLeft = true;
		if( i>left ){
			isLeft = checkIsBST(array, left, i-1);
		}
		
		//判断右子树是否是二叉搜索树
		boolean isRight = true;
		if( i<right){
			isRight = checkIsBST(array, i, right-1);
		}
		
		return isLeft&&isRight;
	}
	
	/*
	 * （前序、中序、后序）递归遍历二叉树
	 */
	public void traversal(TreeNode node){
		if( node == null ) return;
		System.out.println(node.value);//Order
		traversal(node.left);
		traversal(node.right);
	}
	
	/*
	 * 层序遍历
	 */
	public void levelTraversal(TreeNode node){
		if( node == null ) throw new RuntimeException("node is null");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		
		while( !queue.isEmpty() ){
			TreeNode nd = queue.poll();
			System.out.println(nd.value);
			
			if(nd.left!=null) queue.offer(nd.left);
			if(nd.right!=null) queue.offer(nd.right);
		}
		
	}
	
	/*
	 * 翻转二叉数（求二叉数的镜像）
	 */
	public void reverseBinTree(TreeNode node){
		if( node == null ) return;
		
		if( node.left != null || node.right != null ){
			TreeNode tmp;
			tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		
		reverseBinTree(node.left);
		reverseBinTree(node.right);
	}
	
	/*
	 * 求一个二叉树的深度:左右子树的节点深度最大者加1
	 */
	public int treeDepth(TreeNode node){
		if( node == null ) return 0;
		
		int leftDepth = treeDepth(node.left);
		int rightDepth = treeDepth(node.right);
		
		return (leftDepth>rightDepth ? leftDepth+1 : rightDepth+1);
	}
	
	/*
	 *二叉树的和为某一值的路径 
	 */
	public void findPath(TreeNode root, int expectSum){
		if( root == null ) throw new RuntimeException("root is null");
		LinkedList<TreeNode> list = new LinkedList<>();
		int currentSum = 0;
		findPath(root, expectSum, list, currentSum);
	}
	private void findPath(TreeNode root, int expectSum, LinkedList<TreeNode> path, int currentSum){
		currentSum += root.value;
		path.push(root);
		
		boolean isLeaf = root.left == null && root.right == null;
		if( currentSum == expectSum && isLeaf ){
			System.out.println("A path is found");
			for(TreeNode node : path){
				System.out.println(node.value);
			}
			System.out.println("****************");
		}
		
		if( root.left != null){
			findPath(root.left, expectSum, path, currentSum);
		}
		if( root.right != null ){
			findPath(root.right, expectSum, path, currentSum);
		}
		
		path.pop();
	}
	
	/*
	 * 判断一颗树是否是平衡二叉树
	 */
	public boolean isBalance(TreeNode root){
		if( checkHeight(root) == -1 ){
			return false;
		}else {
			return true;
		}
	}
	private int checkHeight(TreeNode root){
		if( root == null ) return 0;
		
		int leftHeight = checkHeight(root.left);
		if( leftHeight == -1 ){
			return -1;
		}
		
		int rightHeight = checkHeight(root.right);
		if( rightHeight == -1 ){
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if( Math.abs(heightDiff)>1 ){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	
	public static void main(String[] args) {
		BinaryTreeTest test = new BinaryTreeTest();
		TreeNode root = test.buildBinaryTree();
		//test.traversal(head);
		//test.reverseBinTree(head);
		//test.levelTraversal(head);
		
		//System.out.println(test.treeDepth(root));
		//int a[] = {};
		//System.out.println(test.isBST(a, a.length));
		
		test.findPath(root, 32);
	}
	
}
