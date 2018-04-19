package edu.bjtu.sse.thread;

/**
 * 
 * @author wupengfei
 *
 */
public class StartDead extends Thread {

	private int i;
	
	@Override
	public void run() {
		for(;i<100;i++){
			System.out.println(this.getName() + ":::" + i);
		}
	}

	
	/**
	 * Exception in thread "main" java.lang.IllegalThreadStateException
		at java.lang.Thread.start(Thread.java:708)
		at edu.bjtu.sse.thread.StartDead.main(StartDead.java:29)
	 * @param args
	 */
	public static void main(String[] args) {
		StartDead sd = new StartDead();
		for(int i=0; i<100; i++){
			System.out.println(Thread.currentThread().getName() + "==="+i) ;
			if(i==20){
				sd.start();
				System.out.println(sd.isAlive());
			}
			if(i>20 & !sd.isAlive()){ //当一个线程死亡了， 不要在试图去start了
				sd.start();
			}
		}
		
	}

}
