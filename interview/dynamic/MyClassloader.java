package edu.bjtu.sse.proxy.eval;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;

import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaFileObject.Kind;


public class MyClassloader extends ClassLoader {
	// 自定义JavaSourceFromString，作为源代码的抽象文件
	static class JavaSourceFromString extends SimpleJavaFileObject {
		final String code;

		public JavaSourceFromString(String name, String code) {
			super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
			this.code = code;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) {
			return code;
		}

	}
	// JavaClassFileObject，代表class的文件抽象
	static class JavaClassFileObject extends SimpleJavaFileObject {
		ByteArrayOutputStream outputStream = null;

		public JavaClassFileObject(String className, Kind kind) {
			super(URI.create("string:///" + className.replace('.', '/') + kind.extension), kind);
			outputStream = new ByteArrayOutputStream();
		}
		@Override
		public OutputStream openOutputStream() throws IOException {
			return this.outputStream;
		}
		public byte[] getClassBytes() {
			return outputStream.toByteArray();
		}
	}
	
	// ClassFileManager，修改JavaFileManager生成class的JavaFileObject的行为，
	//另外返回一个自定义ClassLoader用于返回内存中的字节码对应的类模板
	static class ClassFileManager extends ForwardingJavaFileManager<JavaFileManager> {
		private JavaClassFileObject classFileObject;
		protected ClassFileManager(JavaFileManager fileManager) {
			super(fileManager);
		}
		@Override
		public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
				throws IOException {
			classFileObject = new JavaClassFileObject(className, kind);
			return classFileObject;
		}
		@Override
		public ClassLoader getClassLoader(Location location) {
			return new ClassLoader() {
				@Override
				protected Class<?> findClass(String name) throws ClassNotFoundException {
					byte[] classBytes = classFileObject.getClassBytes();
					return super.defineClass(name, classBytes, 0, classBytes.length);
				}
			};
		}
	}
	

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// 用于诊断编译源代码错误的对象
		DiagnosticCollector diagnosticCollector = new DiagnosticCollector();
		// 内存中的源代码保存在一个该类的继承类中
		JavaFileObject file = new JavaSourceFromString("edu.bjtu.sse.proxy.eval.Temp", name);

		JavaFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
		Iterable compilationUnits = Arrays.asList(file);
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);
		boolean result = task.call();
		ClassLoader loader = fileManager.getClassLoader(null);
		if (result) {
			Class<?> clazz = loader.loadClass("edu.bjtu.sse.proxy.eval.Temp");
			return clazz;
		}
	
		return null;
	}

}
