package edu.bjtu.binarysearchtree;

/**
 * 给定一个BST和关键的根节点参考，删除节点与给定的关键在BST返回根节点的参考（更新）的BST.
	基本上，删除可以分为两个阶段：
	搜索要删除的节点。
	如果找到节点，则删除节点。
	注意：时间复杂度应该是O（树的高度）。
 * @author wupengfei
 *
 */
public class DeleteNodeInBST {

	public TreeNode parent=null;
	
	/**
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
    public TreeNode deleteNode(TreeNode root, int key) {
    	TreeNode node = this.bstSearch(root, key);
    	if(node==null){
    		return root;
    	}
    	//左右子树不空 
    	if(node.right != null && node.left != null){
    		TreeNode successor = this.findSuccessor(node);
    		this.deleteOneNode(parent, successor);
    		node.val = successor.val;
    		return root;
    	}
    	
    	//只有一个子树
    	if(this.parent != null){
    		this.deleteOneNode(parent, node);
    		return root;
    	}
    	
    	//如果没有找到， 则是根节点
    	if(node.left!=null){
    		root = node.left ;
    	} else {
    		root = node.right;
    	}
    	return root;
    }
    
    /**
     * 找到后继结点， 右子树中左边最小的哪个节点(node的后继结点)
     * @param node
     * @return
     */
    public TreeNode findSuccessor(TreeNode node){
    	this.parent = node;
    	TreeNode preTree = node.right;
    	while(preTree.left != null){
    		this.parent = preTree;
    		preTree = preTree.left;
    	}
    	return preTree;
    }
    
    /**
     * 删除只有一个子树或者叶节点的情况
     * @param parent
     * @param node
     */
    public void deleteOneNode(TreeNode parent,TreeNode node){
    	if(node.val < parent.val){
    		if(node.left!=null && node.right==null){
    			parent.left = node.left;
    		} else if(node.left==null && node.right != null){
    			parent.left = node.right;
    		} else {
    			parent.left = null;
    		}
    	} else if(node.val > parent.val){
    		if(node.left==null && node.right!=null){
    			parent.right = node.right;
    		} else if(node.left!=null && node.right==null){
    			parent.right = node.left;
    		} else {
    			parent.right = null;
    		}
    	}
    }
    
    /**
     * 
     * @param node
     * @param value
     * @return
     */
    public TreeNode bstSearch(TreeNode node,int value){
    	while(node != null){
    		if(node.val == value){
    			break;
    		}
    		this.parent = node;//记录父节点
    		if(value < node.val){
    			node = node.left;
    		} else {
    			node = node.right;
    		}
    	}
    	return node;
    }
	
	public static void main(String[] args) {
		
/*		for(int i=1; i<=7; i++){
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
			DeleteNodeInBST dnb = new DeleteNodeInBST();
			BinarySearchTree bst = new BinarySearchTree();
			System.out.println("key=" + i);
			TreeNode t = dnb.deleteNode(a, i);
			bst.preOrderPrint(t, 0);
			
		}*/
		
		TreeNode a = new TreeNode(5); 
		TreeNode b = new TreeNode(3); 

		a.left = b;
		a.right = null;
		
		
		DeleteNodeInBST dnb = new DeleteNodeInBST();
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("key=" + 3);
		TreeNode t = dnb.deleteNode(a, 3);
		bst.preOrderPrint(t, 0);
		
		
		/*System.out.println(dnb.bstSearch(a, 7).val);
		System.err.println(dnb.parent.val);*/
		
	}

}
