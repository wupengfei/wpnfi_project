package edu.bjtu.sse.bfs;

/**
	ͬѧ�ǣ��ڰ����ڲ�������Ӧ��������һ������Ӧ�ý�TTS�����ǽ��ı�ת����������������ǵ���è����Ͱ���ͷ�������IVR��Ӧ�ù㷺��
	�����ʶ���ʱ�򾭳��������ı����а�������������Ҫת�����ĵķ�ʽ�����ʶ���
	����˵ 1000������Ҫ�ʶ��� һǧ
	����˵ 10002������Ҫ�ʶ��� һ�����
	����˵ 3001111����Ҫ�ʶ��� ������һǧһ��һʮһ
	�����ֱȽϴ��ʱ������ϣ���ܹ��ʶ��ĸ����Ի�һЩ�������м���΢ͣ��һ�¡�
	����˵�ղŵ�300 1111������ϣ���ʶ��� ������һǧһ��һʮһ
	����˵1682 1234 5678������ϣ���ʶ��� һǧ���ٰ�ʮ���ڣ�һǧ������ʮ������ǧ������ʮ��
	ͨ�� ���Ķ��� �����һ��ͣ�٣������ʶ�ϰ�ߣ�һ�����ʶ�������������ò�Ҫ����8���֣�����ͽ�������һ��ͣ�١�
	���� 10002���Ͳ���Ҫͣ�٣�ֱ�Ӷ���һ�����
	���� 11234������Ҫͣ��һ�£���ɣ�һ��һǧ������ʮ��
	ϣ��ͬѧ����ʵ������һ��ת���ķ�����������������ת�������ģ�ͬʱ���ܿ��ǵ��ʶ���ͣ�����顣
	ps�����������ֶ�Ӧ�����Ĳο���Ϊ��
	��һ�����������߰˾�ʮ
	ǧ������
	ps���ٶ����ǵ����ֲ�����һ���� 
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
	        String[] unitStrings={"","ʮ","��","ǧ","��","ʮ","��","ǧ","��","ʮ"};
	        String[] nums={"��","һ","��","��","��","��","��","��","��","��"};
	        StringBuilder rst=new StringBuilder();
	        int len=data.length();
	        int index=data.length()-1; // �����±�����
	        while(index>=0){
	            int newNum=Integer.valueOf(String.valueOf(data.charAt(index)));
	            if(newNum!=0){
	                rst.insert(0, unitStrings[len-index-1]);//5-4-1="" ,5-3-1=ʮ,5-2-1=��
	                rst.insert(0, nums[newNum]);                 
	            }else {//�տ�ʼ�����㲻����1000 �� ��������0��
	            	//1001111��10101111�ȶ��� �����
	                if(rst.length()!=0&&rst.charAt(0)!='��'&&rst.charAt(0)!='��'&&rst.charAt(0)!='��'){
	                    rst.insert(0, nums[newNum]);
	                }
	                //������ ��������, ע���������
	                if(unitStrings[len-index-1].equals("��")||unitStrings[len-index-1].equals("��")){ //7-5-1=1
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
