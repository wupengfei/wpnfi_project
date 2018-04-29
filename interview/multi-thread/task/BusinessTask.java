package edu.bjtu.sse.thread.task;

/**  
* <p>Title: BusinessTask</p>  
* <p>Description: </p>  
* @author pengfei.wu  
* @date 2018��4��28��  
*/  
public class BusinessTask {

	private String name;
	private char j = 'A';
	
	public BusinessTask(String name) {
		super();
		this.name = name;
	}

	/**
	 * ��ӡ�����һ���Ͳ��õȴ���
	 * <p>Title: printDigtal</p>  
	 * <p>Description: </p>  
	 * @param i
	 * @throws InterruptedException
	 */
	public synchronized void printDigtal(int i) throws InterruptedException{
		 System.out.print(i++ + "" + i);
		 notifyAll();
		 if(i!=52){
			 wait();
		 }
	} 
	
	/**
	 * <p>Title: printAZ</p>  
	 * <p>Description: </p>  
	 * @param i
	 * @throws InterruptedException
	 */
	public synchronized void  printAZ(char c) throws InterruptedException{
		
		/*System.out.print(c);
		j++;
		notifyAll();
		if(j <= 'Z'){
			wait();
		}*/
		System.out.print(c);
		notifyAll();
		wait();
		 
	}

	
}
