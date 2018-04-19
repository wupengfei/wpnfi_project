package edu.bjtu.sse.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable 与 Future 类实现多线程
 * @author pengfei.wu
 *
 */
public class TestCallableTwo {

	public static void main(String[] args) {
		CallableImpl ci = new CallableImpl();
		FutureTask<Integer> ft = new FutureTask<>(ci);
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值为:" + i);
			if(i == 20){
				new Thread(ft,"有返回值线程").start();
			}
		}
		try {
			System.out.println(ft.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}



class CallableImpl implements Callable<Integer>{
	
	private int i;
	
	@Override
	public Integer call() throws Exception {
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值为:" + i);
		}
		//call 方法的返回值
		return i;
	}
	
}