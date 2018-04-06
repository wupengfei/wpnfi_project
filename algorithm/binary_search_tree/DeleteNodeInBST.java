package edu.bjtu.binarysearchtree;

/**
 * ����һ��BST�͹ؼ��ĸ��ڵ�ο���ɾ���ڵ�������Ĺؼ���BST���ظ��ڵ�Ĳο������£���BST.
	�����ϣ�ɾ�����Է�Ϊ�����׶Σ�
	����Ҫɾ���Ľڵ㡣
	����ҵ��ڵ㣬��ɾ���ڵ㡣
	ע�⣺ʱ�临�Ӷ�Ӧ����O�����ĸ߶ȣ���
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
    	//������������ 
    	if(node.right != null && node.left != null){
    		TreeNode successor = this.findSuccessor(node);
    		this.deleteOneNode(parent, successor);
    		node.val = successor.val;
    		return root;
    	}
    	
    	//ֻ��һ������
    	if(this.parent != null){
    		this.deleteOneNode(parent, node);
    		return root;
    	}
    	
    	//���û���ҵ��� ���Ǹ��ڵ�
    	if(node.left!=null){
    		root = node.left ;
    	} else {
    		root = node.right;
    	}
    	return root;
    }
    
    /**
     * �ҵ���̽�㣬 �������������С���ĸ��ڵ�(node�ĺ�̽��)
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
     * ɾ��ֻ��һ����������Ҷ�ڵ�����
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
    		this.parent = node;//��¼���ڵ�
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
