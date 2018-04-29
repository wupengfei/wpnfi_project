package edu.bjtu.sse.thread.task;

public class PrintAZ extends Thread {

	private BusinessTask bt;
	
	public PrintAZ(BusinessTask bt) {
		super();
		this.bt = bt;
	}

	@Override
	public void run() {
		
		for (int i = 1; i <=26; i++) {
			try {
				char c = (char)(64+i);
				bt.printAZ(c);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
}
