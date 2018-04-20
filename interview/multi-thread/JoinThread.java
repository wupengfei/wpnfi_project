package edu.bjtu.sse.thread;

/**
 * 
 * @author pengfei.wu
 *
 */
public class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(this.getName() + ":::" + i);
		}
	}
	
	/**
	 * join之后， 实际上只有两个线程在并发执行，而主线程处于等待状态
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		JoinThread jtOuter = new JoinThread("New Thread");
		//jtOuter.sleep(1000);
		jtOuter.start();
		for(int i=0; i<100; i++){
			if(i==20){
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + "===" + i);
		}

		
	}

}
