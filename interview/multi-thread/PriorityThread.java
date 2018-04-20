package edu.bjtu.sse.thread;

/**
 * 优先级设置一般是 1-10， 由于收到操作系统的限制， 一般很难满足这个时隔级别
 * 所以一般默认使用Thread类默认的三个优先级
 * @author pengfei.wu
 *
 */
public class PriorityThread extends Thread {

	
	public PriorityThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(this.getName() + ", 优先级为：" + this.getPriority() + " , 循环变量值为：" + i);
		}
	}

	public static void main(String[] args) {
		Thread.currentThread().setPriority(6);
		for (int i = 0; i < 30; i++) {
			if(i==10){
				PriorityThread low = new PriorityThread("低级");
				low.start();
				System.out.println(low.getName() + " 创建之初的优先级为:" + low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if(i==20){
				PriorityThread high = new PriorityThread("高级");
				high.start();
				System.out.println(high.getName() + " 创建之初的优先级为:" + high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}

}
