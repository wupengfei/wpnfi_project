package edu.bjtu.sse.thread;

/**
 * �̳�Thread��ʵ��run()����
 * @author pengfei.wu
 *
 */
public class TestThread extends Thread {

	private int i;
	
	@Override
	public void run() {
		for(;i<100;i++){
			System.out.println(this.getName() + ":::" + i);
		}
	}

	/**
	 * ����߳�֮���޷�����ʵ������
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			System.out.println(Thread.currentThread().getName() + "==="+i) ;
			if(i==20){
				//creat the first thread
				new TestThread().start();
				//
				new TestThread().start();
			}
		}
	}

}
