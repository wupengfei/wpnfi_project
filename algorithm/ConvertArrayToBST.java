package edu.bjtu.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，其中的元素按升序排序，将它转换成一个高度平衡的成就。
	对于这个问题，一个高度平衡二叉树定义为一个二叉树，其深度两子树节点不会相差超过1。
 * @author wupengfei
 *
 */
public class ConvertArrayToBST {
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
    	List<TreeNode> tns = new ArrayList<TreeNode>();
    	if(nums.length <= 0){
    		return null;
    	}
    	this.binaryInsert(nums,tns,0,nums.length -1);
    	if(tns.size() == 1){ //需要考虑到数组只有一个或大于两个的情况下， 不然数组下标越界错误
    		return tns.get(0);
    	} else {
    		for (int i = 1; i < tns.size(); i++) {
    			this.BSTInsert(tns.get(0), tns.get(i));
    		}
            return tns.get(0);
    	}
    	
    }
    
    public void binaryInsert(int[] nums, List<TreeNode> tns, int begin, int end){
    	if(begin > end) {
    		return ;
    	}
    	int mid = (int) Math.ceil((begin+end)/2.0);
    	tns.add(new TreeNode(nums[mid]));
    	
    	this.binaryInsert(nums, tns, begin, mid-1);
    	this.binaryInsert(nums, tns, mid+1, end);
    	
    	
    }
    
	/**
	 *
	 * @param node
	 * @param insertNode
	 */
	public void BSTInsert(TreeNode node,TreeNode insertNode){
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
	 * 0*-3*-10*9*5*
	 * [0,-3,9,-10,null,5]
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {
				-10,-3,0,5,9
		};
		ConvertArrayToBST cat = new ConvertArrayToBST();
		TreeNode root = cat.sortedArrayToBST(nums);
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.preOrderPrint(root, 0);


	}

}
