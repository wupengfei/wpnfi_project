package edu.bjtu.sse;

import java.util.ArrayList;

/**
 * ����n���������еĿ��ܵĽ��
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
	 * @param item �����������ŵ��ַ����� 
	 * @param  n  nΪ������
	 * @param result result Ϊ���ս��
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
