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
 * @date 2018��4��29��
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
	 * Java SE 7�Լ������汾�У�BufferedReader��ʵ����java.lang.AutoCloseable�ӿڡ� ��Ϊ
	 * BufferedReader ʵ������ try-with-resource �����������, ���Բ��� try �����������ɻ��� ��������
	 * (������� BufferedReader.readLine �����׳�IOException)��BufferedReader������رա� ���
	 * readLine �� close �������׳��쳣����ô readFirstLineFromFileWithFinallyBlock �������׳���
	 * finally �����׳����쳣; try �����׳����쳣�������ˡ�����෴, �� readFirstLineFromFile ���������, ���
	 * try ��� try-with-resources �����׳��쳣, ��ô readFirstLineFromFile ���׳��� try
	 * �����׳����쳣; try-with-resources ���׳����쳣�������ˡ���Java SE 7 �Լ������İ汾��, ����Լ��������Ƶ��쳣��
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
	 * �� try-with-resources �������Ĵ������ܻ��׳��쳣���� writeToFileZipFileContents���������, 
	 *  ����ͼ�ر� ZipFile �� BufferedWriter ����ʱ��try ����ܻ��׳�һ���쳣������ try-with-resources �������׳���������쳣 ��
	 *  ��� try ���׳��쳣���� try-with-resources ����׳�һ�������쳣����ô�� try-with-resources ������׳����쳣���ᱻ����,
	 *   ���ҿ��׳����쳣���� writeToFileZipFileContents �����׳�����һ����
	 * �����ͨ�������� try���׳����쳣��Throwable.getSuppressed ����������Щ�����Ƶ��쳣��Ϣ��
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
		String path = "H:\\workspace\\algorithm\\src\\edu\\bjtu\\nio\\FileChannelTest.java";
		String zipPath = "F:\\2017-2018�ڶ�ѧ��\\�������������д��_��΢΢(Ӣ��)\\�������������д��_��΢΢(Ӣ��).zip";
		String outFile = "F:\\2017-2018�ڶ�ѧ��\\�������������д��_��΢΢(Ӣ��)\\filename.txt";
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
