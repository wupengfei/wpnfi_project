package edu.bjtu.sse.thread;

/**
 * 继承Thread类实现run()方法
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
	 * 多个线程之间无法共享实例变量
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
