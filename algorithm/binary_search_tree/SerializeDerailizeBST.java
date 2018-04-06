package edu.bjtu.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * 串行化是将数据结构或对象转换成字节序列的过程，以便将其存储在文件或内存缓冲区中，或通过网络连接链接在相同或另一个计算机环境中进行重构。

	设计一种将二叉搜索树序列化和反序列化的算法。
	对于序列化/反序列化算法应该如何工作没有限制。
	您只需要确保一个二叉搜索树可以被序列化为一个字符串，并且这个字符串可以被反序列化到原始的树结构中。
	
	编码后的字符串应该尽可能紧凑。
	
	注意:不要使用类成员/全局/静态变量来存储状态。
	您的序列化和反序列化算法应该是无状态的。
 * @author wupengfei
 * 
 *
 */
public class SerializeDerailizeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null){
    		return null;
    	}
    	StringBuffer sb = new StringBuffer();
    	List<String> nodes = new ArrayList<String>();
    	this.preorderBST(root,nodes);
    	int size = nodes.size();
    	for (int i = 0; i < size; i++) {
			sb.append(nodes.get(i));
		}
    	return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null){
    		return null;
    	}
    	System.out.println("data=" + data);
        String[] nodes = data.substring(0, data.length()-1).split("\\*"); //* 星号需要进行转译
    	
        TreeNode root = null;
        if(nodes.length>0){
        	root = new TreeNode(Integer.parseInt(nodes[0]));
        	for(int i=1; i<nodes.length; i++){
				this.BSTInsert(root, new TreeNode(Integer.parseInt(nodes[i])));
			}
        }
    	return root;
    }
    
	/**
	 *  
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
			} else { // 
				node.right = insertNode;
			}
		}
	}
    
    /**
     * 
     * @param node
     * @param data
     */
    public void preorderBST(TreeNode node,List<String> nodes){
    	if(node == null){
    		return ;
    	}
    	nodes.add(node.val+"*");
    	this.preorderBST(node.left,nodes);
    	this.preorderBST(node.right, nodes);
    	
    }
	
    // Your Codec object will be instantiated and called as such:
 	// Codec codec = new Codec();
 	// codec.deserialize(codec.serialize(root));
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
		BinarySearchTree bst = new BinarySearchTree();
		bst.preOrderPrint(a, 0);
		SerializeDerailizeBST sdb = new SerializeDerailizeBST();
		TreeNode root = sdb.deserialize(sdb.serialize(a));
		bst.preOrderPrint(root, 0);
	}
	

}
