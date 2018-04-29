package edu.bjtu.sse.thread.task;

public class PrintDigtalThread extends Thread {
	
	private BusinessTask bt;
	public PrintDigtalThread(BusinessTask bt) {
		super();
		this.bt = bt;
	}

	@Override
	public void run() {
		
		for (int i = 1; i <= 52; i++) {//52
			try {
				bt.printDigtal(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
