package edu.bjtu.interview;

/**
 * ��̣���дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������ֽ��������Ϊ���ֽڽ�ȡ���ַ�����
 * ����Ҫ��֤���ֲ����ذ������"��ABC"4��Ӧ�ý�Ϊ"��AB"������"��ABC��DEF"�� 6��Ӧ�����Ϊ"��ABC"������"��ABC+���İ��"��
 * 
 * @author ������
 *
 */
public class SplitWords {

	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String test1 = "��ABC";
		String test2 = "��ABC��DEF";
		 SplitWords.split(test1, 4);
		SplitWords.split(test2, 6);
	}

	public static void split(String source, int num) throws Exception {
		int k = 0;
		String temp = "";
		for (int i = 0; i < source.length(); i++) {
			System.out.println("\nsource.charAt("+i+")=" + source.charAt(i));
			byte[] b = (source.charAt(i) + "").getBytes();
			k = k + b.length;
			if (k > num) {
				break;
			}
			temp = temp + source.charAt(i);
		}
		System.out.println(temp);
	}

}
