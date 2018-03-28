package edu.bjtu.sse.treegraph;

/**
 * 
 * @author wupengfei
 *
 */
public class ConstructBinaryTree {

	/**
	 *      1
	 *    2   5
	 *  3  4    6
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(6);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		
		ConstructBinaryTree cbt = new ConstructBinaryTree();
		//cbt.preOrder(a, 0);
		//cbt.midOrder(a, 0);
		cbt.lastOrder(a, 0);
	}
	
	/**
	 * ǰ����� �� ������
	 * @param tree 
	 * @param layer �ڵ����ڲ���
	 */
	public void preOrder(TreeNode tree,int layer){
		if(tree == null){
			return ;
		}
		for(int i=0; i<layer; i++){
			System.out.print("***  ");
		}
		System.out.println(tree.val);
		this.preOrder(tree.left, layer+1);
		this.preOrder(tree.right, layer+1);
	}
	
	/**
	 * ������� �� �����
	 * @param tree 
	 * @param layer �ڵ����ڲ���
	 */
	public void midOrder(TreeNode tree,int layer){
		if(tree == null){
			return ;
		}
		this.midOrder(tree.left, layer+1);
		for(int i=0; i<layer; i++){
			System.out.print("+++  ");
		}
		System.out.println(tree.val);
		this.midOrder(tree.right, layer+1);
	}
	
	/**
	 * ������� �� ���Ҹ�
	 * @param tree 
	 * @param layer �ڵ����ڲ���
	 */
	public void lastOrder(TreeNode tree,int layer){
		if(tree == null){
			return ;
		}
		this.lastOrder(tree.left, layer+1);
		this.lastOrder(tree.right, layer+1);
		for(int i=0; i<layer; i++){
			System.out.print("---  ");
		}
		System.out.println(tree.val);
	}
	
	
	
	
	
	
	

}
