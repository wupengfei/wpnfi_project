package edu.bjtu.sse;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产n组括号所有的可能的结果
 * @author wupengfei
 *
 */
public class Parenthenses {
	
    public List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
    	generate("", n, n, result);
    	return result;
    }
    
	/**
	 * 
	 * @param item
	 * @param left 当前还可以放置的左括号的数量
	 * @param right 当前还可以放置右括号的数量
	 * @param result 
	 */
	private void generate(String item, int left, int right, ArrayList<String> result) {
		if(left==0 && right == 0){
			result.add(item);
			return ;
		}
		if(left > 0){ //最多可以放置n个括号， 不能多于n个， 两个if为重要的限制条件
			generate(item+"(", left-1, right, result);
		}
		if(left < right){ //代表当左括号的数量大于右括号的数量时才可以放置右括号， 右括号不能先于左括号放置
			generate(item+")", left, right-1, result);
		}
	}

	public static void main(String[] args) {
		ArrayList<String> result = new ArrayList<String>();
		//recurse("",2,result);
		Parenthenses p  = new Parenthenses();
		List<String> list = p.generateParenthesis(2);
		for (String str:list) {
			System.out.println("["+str+"] ");
		}
	}

	/**
	 * 
	 * @param item 用来生成括号的字符串， 
	 * @param  n  n为组数，
	 * @param result result 为最终结果
	 */
	private static void recurse(String item, int n, ArrayList<String> result) {
		if(item.length() == 2*n){
			result.add(item);
			return ;
		}
		recurse(item+"(", n, result);
		recurse(item+")", n, result);
	}

}
