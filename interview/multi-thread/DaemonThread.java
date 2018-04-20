package edu.bjtu.sse.thread;

/**
 * ���ú�̨�̣߳� ����������֮ǰ�� ǰ̨�߳̽�����̨�߳�Ҳ��֮����
 * 
 * @author pengfei.wu
 *
 */
public class DaemonThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.getName() + ":::" + i);
		}
	}

	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		dt.setDaemon(true);
		dt.start();
		for(int i=0; i<10; i++){
			System.out.println(Thread.currentThread().getName() + "   " + i);
		}
	}

}
