package edu.bjtu.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: GetPostTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author pengfei.wu
 * @date 2018��5��3��
 */
public class GetPostTest {

	public static String sendGet(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// ����ʵ�ʵ�����
			conn.connect();
			Map<String, List<String>> map = conn.getHeaderFields();
			for (String key : map.keySet()) {
				System.out.println(key + "---->" + map.get(key));
			}

			try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {

				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * ��ָ��URL����POST����������
	 * 
	 * @param url
	 *            ���������URL
	 * @param param
	 *            �����������ʽӦ������name1=value1&name2=value2����ʽ��
	 * @return URL������Զ����Դ����Ӧ
	 */
	public static String sendPost(String url, String param) {
		String result = "";
		URL realRUrl;
		try {
			realRUrl = new URL(url);
			URLConnection conn = realRUrl.openConnection();
			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

			// ����POST�������������������
			conn.setDoOutput(true);
			conn.setDoInput(true);

			try (
					// ��ȡURLConnection�����Ӧ�������
					PrintWriter out = new PrintWriter(conn.getOutputStream());) {
				out.println(param);
				out.flush();
			}
			try (
					// ����BufferedReader����������ȡURL����Ӧ
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		// ����GET����
		String s = GetPostTest.sendGet("http://localhost:8080/abc/a.jsp", null);
		System.out.println(s);

		// ����POST����
		String s1 = GetPostTest.sendPost("http://localhost:8080/abc/login.jsp", "name=xxx&pass=xxx");
		System.out.println(s1);
	}

}
