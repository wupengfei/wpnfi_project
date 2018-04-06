package edu.bjtu.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * ���л��ǽ����ݽṹ�����ת�����ֽ����еĹ��̣��Ա㽫��洢���ļ����ڴ滺�����У���ͨ������������������ͬ����һ������������н����ع���

	���һ�ֽ��������������л��ͷ����л����㷨��
	�������л�/�����л��㷨Ӧ����ι���û�����ơ�
	��ֻ��Ҫȷ��һ���������������Ա����л�Ϊһ���ַ�������������ַ������Ա������л���ԭʼ�����ṹ�С�
	
	�������ַ���Ӧ�þ����ܽ��ա�
	
	ע��:��Ҫʹ�����Ա/ȫ��/��̬�������洢״̬��
	�������л��ͷ����л��㷨Ӧ������״̬�ġ�
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
        String[] nodes = data.substring(0, data.length()-1).split("\\*"); //* �Ǻ���Ҫ����ת��
    	
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
