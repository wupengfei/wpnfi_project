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
	 * 
	 * @param node
	 * @param value
	 * @return
	 */
	public boolean BStSearchLoop(TreeNode node,int value){
		while(node!=null){
			if(node.val == value){
				return true;
			}
			if(value < node.val){
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return false;
		/*if(node.val == value){
			return true;
		} else if(value > node.val){
			if(node.right != null){
				 return this.BStSearchLoop(node.right, value);
			}
			return false;
		} else if(value < node.val){
			if(node.left != null){
				return  this.BStSearchLoop(node.left, value);
			}
			return false;
		}
		return false;*/
	}
	
	/**
	 * 递归查找某数值
	 * @param node
	 * @param value
	 * @return
	 */
	public boolean BSTSearchRecurision(TreeNode node,int value) {
		System.out.println("node.val=" + node.val);
		if(node.val == value) {
			return true;
		}
		if(node.val < value){
			if(node.right != null){ //右子树不空时， 可以继续搜索右子树
				System.out.println("node_right=" + node.val);
				return this.BSTSearchRecurision(node.right, value);
			}
			return false;
		} else {
			if(node.left != null){
				System.out.println("node_left=" + node.val);
				return this.BSTSearchRecurision(node.left, value);
			}
			return false;
		}
	}
	
	/**
	 * 循环插入二叉排序树
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
	 * 递归插入节点
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
			} else { //当右子树， 为空时， 将node的右指针与待插入的节点相连接
				node.right = insertNode;
			}
		}
	}
	
	/**
	 * 前序遍历
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
