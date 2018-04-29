package edu.bjtu.nio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 
 * <p>
 * Title: TryResearch
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author pengfei.wu
 * @date 2018年4月29日
 */
public class TryResearch   {

	public void testTryC(String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			System.out.println(line);
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	/**
	 * Java SE 7以及后续版本中，BufferedReader类实现了java.lang.AutoCloseable接口。 因为
	 * BufferedReader 实例是在 try-with-resource 语句中声明的, 所以不管 try 语句正常地完成或是 发生意外
	 * (结果就是 BufferedReader.readLine 方法抛出IOException)，BufferedReader都将会关闭。 如果
	 * readLine 和 close 方法均抛出异常，那么 readFirstLineFromFileWithFinallyBlock 方法将抛出从
	 * finally 块中抛出的异常; try 块中抛出的异常被抑制了。与此相反, 在 readFirstLineFromFile 这个例子中, 如果
	 * try 块和 try-with-resources 语句均抛出异常, 那么 readFirstLineFromFile 将抛出从 try
	 * 块中抛出的异常; try-with-resources 块抛出的异常被抑制了。在Java SE 7 以及后续的版本中, 你可以检索被抑制的异常；
	 * <p>
	 * Title: testTryCTwo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void testTryCTwo(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path));) {
			String line = br.readLine();
			System.out.println(line);
		}
	}
	
	/**
	 * 与 try-with-resources 语句关联的代码块可能会抛出异常。在 writeToFileZipFileContents这个例子中, 
	 *  当试图关闭 ZipFile 和 BufferedWriter 对象时，try 块可能会抛出一个异常，并且 try-with-resources 语句可能抛出多达两个异常 。
	 *  如果 try 块抛出异常并且 try-with-resources 语句抛出一个或多个异常，那么从 try-with-resources 语句中抛出的异常将会被抑制,
	 *   并且块抛出的异常是由 writeToFileZipFileContents 方法抛出的那一个。
	 * 你可以通过调用由 try块抛出的异常的Throwable.getSuppressed 方法检索这些被抑制的异常信息。
	 * <p>Title: writeToFileZipFileContents</p>  
	 * <p>Description: </p>  
	 * @param zipFileName
	 * @param outputFileName
	 * @throws java.io.IOException
	 */
	public static void writeToFileZipFileContents(String zipFileName, String outputFileName)
			throws java.io.IOException {

		java.nio.charset.Charset charset = java.nio.charset.Charset.forName("US-ASCII");
		java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);
		
		try (  
				java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
				java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
			) {

			// Enumerate each entry
			for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				System.out.println("newLine=" + newLine);
				String zipEntryName = ((java.util.zip.ZipEntry) entries.nextElement()).getName() + newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}

	}

	public static void main(String[] args) {
		String path = "H:\\xxxxxxxFileChannelTest.java";
		String zipPath = "F:\\xxxxxxxxxx.zip";
		String outFile = "F:\\xxxxxfilename.txt";
		TryResearch tr = new TryResearch();
		try {
			tr.writeToFileZipFileContents(zipPath, outFile);
			//tr.testTryCTwo(path);
			// tr.testTryC(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
