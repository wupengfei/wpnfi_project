package edu.bjtu.sse.thread;

/**
 * ���ȼ�����һ���� 1-10�� �����յ�����ϵͳ�����ƣ� һ������������ʱ������
 * ����һ��Ĭ��ʹ��Thread��Ĭ�ϵ��������ȼ�
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
			System.out.println(this.getName() + ", ���ȼ�Ϊ��" + this.getPriority() + " , ѭ������ֵΪ��" + i);
		}
	}

	public static void main(String[] args) {
		Thread.currentThread().setPriority(6);
		for (int i = 0; i < 30; i++) {
			if(i==10){
				PriorityThread low = new PriorityThread("�ͼ�");
				low.start();
				System.out.println(low.getName() + " ����֮�������ȼ�Ϊ:" + low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if(i==20){
				PriorityThread high = new PriorityThread("�߼�");
				high.start();
				System.out.println(high.getName() + " ����֮�������ȼ�Ϊ:" + high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}

}
