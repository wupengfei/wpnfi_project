package edu.bjtu.sse;

import java.util.ArrayList;

/**
 * 生产n组括号所有的可能的结果
 * @author wupengfei
 *
 */
public class Parenthenses {

	
	
	public static void main(String[] args) {
		ArrayList<String> result = new ArrayList<String>();
		generate("",2,result);
		for (String str:result) {
			System.out.println("["+str+"] ");
		}
	}

	/**
	 * 
	 * @param item 用来生成括号的字符串， 
	 * @param  n  n为组数，
	 * @param result result 为最终结果
	 */
	private static void generate(String item, int n, ArrayList<String> result) {
		if(item.length() == 2*n){
			result.add(item);
			return ;
		}
		generate(item+"(", n, result);
		generate(item+")", n, result);
	}

}
