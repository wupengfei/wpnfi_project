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
	 * 采用Runnable接口的方式创建的多个线程可以共享线程类的实例变量， 共享一个线程类(target)，输出结果是连续的
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
