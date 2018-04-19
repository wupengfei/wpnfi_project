package edu.bjtu.sse.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author pengfei.wu
 *
 */
public class TestCallableThread {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Callable
		//FutureTask
		TestCallableThread ct = new TestCallableThread();
		FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)()->{
			int i = 0;
			for(;i<100;i++){
				System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵΪ:" + i);
			}
			//call �����ķ���ֵ
			return i;
		});
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " ��ѭ������i��ֵΪ:" + i);
			if(i == 20){
				new Thread(task,"�з���ֵ�߳�").start();
			}
		}
		
		try {
			System.out.println("�̵߳ķ���ֵ=" + task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
