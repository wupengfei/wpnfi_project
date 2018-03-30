package edu.bjtu.sse.treegraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，将二叉树就地(in-place)转换为单链表。单链表中的顺序为二叉树的前序遍历顺序
 * @author wupengfei
 *
 */
public class BinaryTreeTOLinkedListBasedOnVector {
	
	/**
	 * @param root
	 */
    public void flatten(TreeNode root) {
    	List<TreeNode> nodes = new ArrayList<TreeNode>();
    	this.preOrder(root, nodes);
    	for (int i = 1; i < nodes.size(); i++) {
			TreeNode tn =  nodes.get(i);
			TreeNode preTn = nodes.get(i-1);
			preTn.right = null;
			preTn.left = tn;
		}
    	root = nodes.get(0);
    }
	
    /**
     * 二叉树的前序遍历
     * @param node
     * @param nodes
     */
    public void preOrder(TreeNode node,List<TreeNode> nodes){
    	if(node==null){
    		return ;
    	}
    	nodes.add(node);
    	this.preOrder(node.left, nodes);
    	this.preOrder(node.right, nodes);
    }
    
    /**
     * 
     * @param args
     */
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(6);
		
		TreeNode g = new TreeNode(-1);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		f.left = g;
		
		BinaryTreeTOLinkedListBasedOnVector btl = new BinaryTreeTOLinkedListBasedOnVector();
		btl.flatten(a);
		while(a!=null){
			System.out.print(a.val + "->");
			a = a.left;
		}
	}

}
