package edu.bjtu.sse.treegraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 已知二叉树，求给定的二叉树中给定的两个节点的最近公共祖先
 * @author wupengfei
 *
 */
public class LowestCommonAncestorOFBinaryTree {

	List<TreeNode> result = new ArrayList<>(); //最终搜索到的结果的路径
	List<TreeNode> path = new ArrayList<>(); // 遍历时的节点路径
	boolean finished = false;
	/**
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {   	
    	List<TreeNode> nodeP = new ArrayList<>();
    	List<TreeNode> nodeQ = new ArrayList<>();
    	
    	this.initialParameter();
    	treeOrder(root,p);
    	for (TreeNode treeNode : this.result) {
    		System.out.print(treeNode.val + "-");
    		nodeP.add(treeNode);
		}
    	System.out.println();
    	
    	this.initialParameter();
    	this.treeOrder(root, q);
    	for (TreeNode treeNode : this.result) {
    		System.out.print(treeNode.val + "+");
			nodeQ.add(treeNode);
		}
    	System.out.println();
    	
    	int pthLen = 0;
    	if(nodeP.size() < nodeQ.size()){
    		pthLen = nodeP.size();
    	} else {
    		pthLen = nodeQ.size();
    	}
    	TreeNode result = null;
    	boolean flag = false;//考虑一下不同的节点相同值的时候 
    	for (int i = 0; i < pthLen; i++) {//
			if(nodeP.get(i).val == nodeQ.get(i).val ){
				result = nodeP.get(i);
			} else { 
				flag = true;
			}
			if(flag){
				break;
			}
		}
    	return result;
    }
    
    /**
     * 
     * @param node
     * @param search
     */
    public void treeOrder(TreeNode node,TreeNode search){
    	if(node==null || finished == true){
    		return ;
    	}
    	path.add(node);
    	if(node.val == search.val && node == search){//需要考虑到有多个不同节点有相同值的时候
    		finished = true;
    		for (TreeNode treeNode : path) { //将path结果存储到结果路径中
				result.add(treeNode);
			}
    	}
    	this.treeOrder(node.left, search);
    	this.treeOrder(node.right, search);
    	path.remove(path.size()-1);
    }
    
    public void initialParameter(){
    	this.path.clear();
    	this.result.clear();
    	this.finished = false;
    }
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(6);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(0);
		TreeNode x = new TreeNode(8);
		TreeNode y = new TreeNode(7);
		TreeNode z = new TreeNode(4);

		TreeNode w = new TreeNode(4);
		//[37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]
		//node with value -100
		//node with value -71
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = x;
		e.left = y;
		e.right = z;
		
		d.right = w;
		
		
		LowestCommonAncestorOFBinaryTree labt = new LowestCommonAncestorOFBinaryTree();
		//TreeNode result = labt.lowestCommonAncestor(a, b, f);
		//System.out.println(a.val + "  " + b.val + "  " + f.val + "  " +labt.lowestCommonAncestor(a, b, f).val);
		//System.out.println("tn=" + tn);
		//System.out.println(a.val + "  " + d.val + "  " + z.val + "  " +labt.lowestCommonAncestor(a, d, z).val);
		//System.out.println(a.val + "  " + d.val + "  " + w.val + "  " +labt.lowestCommonAncestor(a, d, w).val);
		System.out.println(a.val + "  " + w.val + "  " + z.val + "  " +labt.lowestCommonAncestor(a, w, z).val);

		
	}
	


}
