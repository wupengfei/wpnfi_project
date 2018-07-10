package edu.bjtu.sse.proxy.eval;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Eval {

	public static Object eval(String str) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		StringBuffer sb = new StringBuffer();
		sb.append("package edu.bjtu.sse.proxy.eval; \n");
		sb.append("public class Temp { \n ");
		sb.append("public Object getObject(){ \n ");
		sb.append(str + " return new Object(); \n" + "}" + "}");
		System.out.println(sb.toString());
		Class<?> clazz = new MyClassloader().findClass(sb.toString());
		Method method = clazz.getMethod("getObject");
		return method.invoke(clazz.newInstance());
	}

	public static void main(String[] args) {
		Object val;
		try {
			val = eval("System.out.println(\"hello\"); int a=1,b=2; System.out.println(a+b); ");
			System.out.println(val);
			String path = Eval.class.getResource("/").getPath();
			System.out.println("path=" + path); 
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
