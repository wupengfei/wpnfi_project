package edu.bjtu.nio;

import java.nio.CharBuffer;

/**  
* <p>Title: BufferTest</p>  
* <p>Description: </p>  
* @author pengfei.wu  
* @date 2018��4��29��  
*/  
public class BufferTest {

	public static void main(String[] args) {
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());
		
		buff.put('a');
		buff.put('b');
		buff.put('c');
		
		System.out.println("After add elements,postion=" + buff.position());
		//׼����ȡ������
		buff.flip();
		System.out.println("After executing flip(), limit=" + buff.limit());
		System.out.println("position=" + buff.position());
		
		System.out.println("After get a element: " + buff.get());//�ӵ�ǰλ�ö�ȡ���ݣ�postion ��仯-1
		System.out.println("position=" + buff.position());
		
		buff.clear();
		System.out.println("aftr clear() capacity:" + buff.capacity());
		System.out.println("aftr clear() limit:" + buff.limit());
		System.out.println("aftr clear() position:" + buff.position());
		
		System.out.println("After get a element: " + buff.get(2));//����λ�ö�ȡ�� ��postion����仯
		System.out.println("position=" + buff.position());
	}

}
