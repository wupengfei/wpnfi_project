package edu.bjtu.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wupengfei
 *
 */
public class BinarySearchTree {
	
	/**
	 * ѭ���������������
	 * @param node
	 * @param insertNode
	 */
	public void BSTInsertLoop(TreeNode node,TreeNode insertNode){
		while(node != insertNode){
			if(insertNode.val < node.val){
				if(node.left == null){
					node.left = insertNode;
				}
				node = node.left;
			} else {
				if(node.right == null){
					node.right = insertNode;
				}
				node = node.right;
			}
		}
	}
	
	/**
	 * �ݹ����ڵ�
	 * @param node
	 * @param insertNode
	 */
	public void BSTInsert(TreeNode node,TreeNode insertNode){
		if(insertNode.val < node.val){
			if(node.left != null){
				this.BSTInsert(node.left, insertNode);
			} else {
				node.left = insertNode;
			}
		} else {
			if(node.right != null){
				this.BSTInsert(node.right, insertNode);
			} else { //���������� Ϊ��ʱ�� ��node����ָ���������Ľڵ�������
				node.right = insertNode;
			}
		}
	}
	
	/**
	 * ǰ�����
	 * @param node
	 * @param layer
	 */
	public  void preOrderPrint(TreeNode node, int layer){
		if(node ==null){
			return ;
		}
		for(int i=0; i<layer; i++){
			System.out.print("***** ");
		}
		System.out.println(node.val);
		this.preOrderPrint(node.left, layer+1);
		this.preOrderPrint(node.right, layer+1);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode(8);
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		int[] nums = {
				3,10,1,6,15
		};
		for (int i = 0; i < 5; i++) {
			nodes.add(new TreeNode(nums[i]));
		}
		for (TreeNode tn:nodes) {
			//bst.BSTInsert(root, tn);
			bst.BSTInsertLoop(root, tn);
		}
		bst.preOrderPrint(root, 0);
	}
	
	
	
	

}
