package edu.bjtu.binarysearchtree;

/**
 * Given a Binary Search Tree (BST), 
 * convert it to a Greater Tree such that every key of the original BST 
 *   is changed to the original key plus sum of all keys greater than the original key in BST.
 * @author wupengfei
 *
 */
public class ConvertBSToGreater {
	
	Integer sum = 0;
	/**
	 * 
	 * @param root
	 * @return
	 */
    public TreeNode convertBST(TreeNode root) {
    	this.midTravelTree(root);
    	return root;
    }
    
    /**
     * 
     * @param node
     */
    public void midTravelTree(TreeNode node){
    	if(node == null){
    		return ;
    	}
    	this.midTravelTree(node.right);
    	sum += node.val;
    	node.val = sum;
    	this.midTravelTree(node.left);
    }
    
	public static void main(String[] args) {

		TreeNode a = new TreeNode(5); 
		TreeNode b = new TreeNode(3); 
		TreeNode c = new TreeNode(6); 
		TreeNode d = new TreeNode(2); 
		TreeNode e = new TreeNode(4); 
		TreeNode f = new TreeNode(7); 
		a.left = b;
		a.right = c;
		b.left =  d;
		b.right =  e;
		c.right =  f;
		
		ConvertBSToGreater cbg = new ConvertBSToGreater();
		cbg.convertBST(a);
		BinarySearchTree bst = new BinarySearchTree();
		bst.preOrderPrint(a, 0);
	}

}
