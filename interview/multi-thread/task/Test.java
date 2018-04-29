package edu.bjtu.sse.thread.task;


/**  
* <p>Title: Test</p>  
* <p>Description:12A34B56C78D910E1112F1314G1516H1718I1920J2122K2324L2526M2728N2930O3132P3334Q3536R3738S3940T4142U4344V4546W4748X4950Y5152Z </p>  
* @author pengfei.wu  
* @date 2018年4月29日  
*/  
public class Test {

	public static void main(String[] args) {

		BusinessTask bt = new BusinessTask("业务1");
		PrintAZ paz = new PrintAZ(bt);
		paz.setName("PrintAZ");
		paz.start();
		
		PrintDigtalThread pdt = new PrintDigtalThread(bt);
		pdt.setName("PrintDigtal");
		pdt.start();
		

		
	/*	System.out.println();
		for (int i = 1; i <=26; i++) {
			System.out.print((char)(64+i));
		}*/
	}

}
