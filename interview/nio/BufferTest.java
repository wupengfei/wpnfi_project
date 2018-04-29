package edu.bjtu.nio;

import java.nio.CharBuffer;

/**  
* <p>Title: BufferTest</p>  
* <p>Description: </p>  
* @author pengfei.wu  
* @date 2018年4月29日  
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
		//准备好取出数据
		buff.flip();
		System.out.println("After executing flip(), limit=" + buff.limit());
		System.out.println("position=" + buff.position());
		
		System.out.println("After get a element: " + buff.get());//从当前位置读取数据，postion 会变化-1
		System.out.println("position=" + buff.position());
		
		buff.clear();
		System.out.println("aftr clear() capacity:" + buff.capacity());
		System.out.println("aftr clear() limit:" + buff.limit());
		System.out.println("aftr clear() position:" + buff.position());
		
		System.out.println("After get a element: " + buff.get(2));//绝对位置读取， 其postion不会变化
		System.out.println("position=" + buff.position());
	}

}
