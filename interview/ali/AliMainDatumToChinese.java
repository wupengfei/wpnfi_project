package edu.bjtu.sse.bfs;

/**
	同学们，在阿里内部的智能应用里面有一种智能应用叫TTS。就是将文本转成语音输出，在我们的天猫精灵和阿里客服的智能IVR中应用广泛。
	在做朗读的时候经常会碰到文本中有阿拉伯的数字需要转成中文的方式进行朗读。
	比如说 1000，就需要朗读成 一千
	比如说 10002，就需要朗读成 一万零二
	比如说 3001111，需要朗读成 三百万一千一百一十一
	当数字比较大的时候，我们希望能够朗读的更人性化一些，会在中间稍微停顿一下。
	比如说刚才的300 1111，我们希望朗读成 三百万，一千一百一十一
	比如说1682 1234 5678，我们希望朗读成 一千六百八十二亿，一千二百三十四万，五千六百七十八
	通过 中文逗号 来表达一个停顿，根据朗读习惯，一次性朗读的中文数字最好不要大于8个字，否则就建议增加一个停顿。
	所以 10002，就不需要停顿，直接读：一万零二
	但是 11234，就需要停顿一下，变成：一万，一千二百三十四
	希望同学们能实现这样一个转换的方法，将阿拉伯数字转换成中文，同时还能考虑到朗读的停顿体验。
	ps：阿拉伯数字对应的中文参考表为：
	零一二三四五六七八九十
	千百万亿
	ps：假定我们的数字不超过一万亿 
 * @author wupengfei
 *
 */
public class AliMainDatumToChinese {

	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public static String readNum(long number){
	        String data= String.valueOf(number);
	        String[] unitStrings={"","十","百","千","万","十","百","千","亿","十"};
	        String[] nums={"零","一","二","三","四","五","六","七","八","九"};
	        StringBuilder rst=new StringBuilder();
	        int len=data.length();
	        int index=data.length()-1; // 数组下标索引
	        while(index>=0){
	            int newNum=Integer.valueOf(String.valueOf(data.charAt(index)));
	            if(newNum!=0){
	                rst.insert(0, unitStrings[len-index-1]);//5-4-1="" ,5-3-1=十,5-2-1=百
	                rst.insert(0, nums[newNum]);                 
	            }else {//刚开始碰到零不处理，1000 ， 连续两个0，
	            	//1001111，10101111先读万 后读零
	                if(rst.length()!=0&&rst.charAt(0)!='零'&&rst.charAt(0)!='万'&&rst.charAt(0)!='亿'){
	                    rst.insert(0, nums[newNum]);
	                }
	                //处理亿 和万的情况, 注意和题意结合
	                if(unitStrings[len-index-1].equals("万")||unitStrings[len-index-1].equals("亿")){ //7-5-1=1
	                    rst.insert(0, unitStrings[len-index-1]);
	                }
	                System.out.println("unitStrings[len-index-1]=" + unitStrings[len-index-1]);
	                System.out.println("newNum=" + newNum + "    " + len+"-"+index+"-1=" + (len-index-1));
	            }
	            index--;
	        }
	        byte comma=0;
	        for(int i=rst.length()-1; i>0; i--){
	        	comma++;
	            if(comma%7==0){
	                rst.insert(i, ',');
	                comma=0;
	            }
	        } 
	        return rst.toString();
	    }
	
	public static void main(String[] args) {
		System.out.println(AliMainDatumToChinese.readNum(10101111));
	}

}
