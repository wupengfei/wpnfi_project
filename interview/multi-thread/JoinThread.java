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
	 * join֮�� ʵ����ֻ�������߳��ڲ���ִ�У������̴߳��ڵȴ�״̬
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		JoinThread jtOuter = new JoinThread("New Thread");
		//jtOuter.sleep(1000);
		jtOuter.start();
		for(int i=0; i<100; i++){
			if(i==20){
				JoinThread jt = new JoinThread("��Join���߳�");
				jt.start();
				
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + "===" + i);
		}

		
	}

}
