package edu.bjtu.sse.treegraph;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * ����һ��������������sum�� �ҳ����дӸ��ڵ㵽Ҷ�ڵ��·������Щ·���ϵĽڵ�ֵ�ۼӺ�Ϊsum
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSwumTwo {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	Integer pathValue = 0;
	List<Integer> path = new ArrayList<>();
	
	/**
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	preLastOrder(root,pathValue,sum,path);
    	return result;
    }	
	/**
	 * �ȸ�������������ͬʱʹ��
	 * @param root
	 * @param pathValue
	 * @param sum
	 * @param path
	 */
	public void preLastOrder(TreeNode root, Integer pathValue, int sum, List<Integer> path){
		if(root==null){
			return ;
		}
		pathValue += root.val;
		path.add(root.val);
		if(root.left==null && root.right==null && pathValue.equals(sum)){
			List<Integer> r1 = new ArrayList<Integer>();
			for (Integer integer : path) {
				r1.add(integer);
			}
			result.add(r1);
			
		}
		this.preLastOrder(root.left, pathValue, sum, path);
		this.preLastOrder(root.right, pathValue, sum, path);
		
		pathValue -= root.val;
		path.remove(path.size()-1);
		
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(11);
		TreeNode e = new TreeNode(13);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(7);
		TreeNode h = new TreeNode(2);
		TreeNode i = new TreeNode(5);
		TreeNode j = new TreeNode(1);
		
		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;
		d.left = g;
		d.right = h;
		f.left = i;
		f.right = j;
		
		PathSwumTwo pst = new PathSwumTwo();
		
		List<List<Integer>> result = pst.pathSum(a, 22);
		System.out.println(result);
		
	}

}
