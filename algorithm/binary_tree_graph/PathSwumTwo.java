package edu.bjtu.sse.treegraph;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * 给定一个二叉树与整数sum， 找出所有从根节点到叶节点的路径，这些路径上的节点值累加和为sum
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
	 * 先根遍历与后跟遍历同时使用
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
