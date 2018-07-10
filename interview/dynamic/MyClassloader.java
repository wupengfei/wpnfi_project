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
	// �Զ���JavaSourceFromString����ΪԴ����ĳ����ļ�
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
	// JavaClassFileObject������class���ļ�����
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
	
	// ClassFileManager���޸�JavaFileManager����class��JavaFileObject����Ϊ��
	//���ⷵ��һ���Զ���ClassLoader���ڷ����ڴ��е��ֽ����Ӧ����ģ��
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
		// ������ϱ���Դ�������Ķ���
		DiagnosticCollector diagnosticCollector = new DiagnosticCollector();
		// �ڴ��е�Դ���뱣����һ������ļ̳�����
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
