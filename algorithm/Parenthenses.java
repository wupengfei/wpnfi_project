package edu.bjtu.sse;

import java.util.ArrayList;
import java.util.List;

/**
 * ����n���������еĿ��ܵĽ��
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
	 * @param left ��ǰ�����Է��õ������ŵ�����
	 * @param right ��ǰ�����Է��������ŵ�����
	 * @param result 
	 */
	private void generate(String item, int left, int right, ArrayList<String> result) {
		if(left==0 && right == 0){
			result.add(item);
			return ;
		}
		if(left > 0){ //�����Է���n�����ţ� ���ܶ���n���� ����ifΪ��Ҫ����������
			generate(item+"(", left-1, right, result);
		}
		if(left < right){ //���������ŵ��������������ŵ�����ʱ�ſ��Է��������ţ� �����Ų������������ŷ���
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
	 * @param item �����������ŵ��ַ����� 
	 * @param  n  nΪ������
	 * @param result result Ϊ���ս��
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
