package edu.bjtu.sse.thread;

/**
 * 
 * @author pengfei.wu
 *
 */
public class TestRunnableThread implements Runnable {

	private int i;
	
	@Override
	public void run() {
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName() + ":::" + i);
		}
	}
	
	/**
	 * ����Runnable�ӿڵķ�ʽ�����Ķ���߳̿��Թ����߳����ʵ�������� ����һ���߳���(target)����������������
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			System.out.println(Thread.currentThread().getName() + "==="+i) ;
			if(i==20){
				TestRunnableThread rt = new TestRunnableThread();
				//creat the first thread
				new Thread(rt,"New Thread1").start();;
				//
				new Thread(rt,"New Thread2").start();
			}
		}
	}

}
