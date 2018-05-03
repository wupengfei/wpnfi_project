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
 * @date 2018年5月3日
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
			// 建立实际的连接
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
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，格式应该满足name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String sendPost(String url, String param) {
		String result = "";
		URL realRUrl;
		try {
			realRUrl = new URL(url);
			URLConnection conn = realRUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);

			try (
					// 获取URLConnection对象对应的输出流
					PrintWriter out = new PrintWriter(conn.getOutputStream());) {
				out.println(param);
				out.flush();
			}
			try (
					// 定义BufferedReader输入流来读取URL的响应
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
		// 发送GET请求
		String s = GetPostTest.sendGet("http://localhost:8080/abc/a.jsp", null);
		System.out.println(s);

		// 发送POST请求
		String s1 = GetPostTest.sendPost("http://localhost:8080/abc/login.jsp", "name=xxx&pass=xxx");
		System.out.println(s1);
	}

}
