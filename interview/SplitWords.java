package edu.bjtu.interview;

/**
 * 编程：编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"， 6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 * 
 * @author 武鹏飞
 *
 */
public class SplitWords {

	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String test1 = "我ABC";
		String test2 = "我ABC汉DEF";
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
