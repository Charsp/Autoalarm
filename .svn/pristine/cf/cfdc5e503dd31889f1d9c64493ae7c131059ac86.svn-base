package com.swz.voice.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServlet {
	private static Logger log = LoggerFactory.getLogger(HttpServlet.class);

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url;
			if (param != null)
				urlNameString = url + "?" + param;
			// System.out.println(urlNameString);
			URL realUrl = new URL(urlNameString); 
			URLConnection connection = realUrl.openConnection(); 
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000); 
			connection.connect(); 
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} 
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		//log.info("SendGet返回的代码为：" + result);
		return result;
	}

	/**
	 * ��ָ�� URL ����POST����������
	 * 
	 * @param url
	 *            ��������� URL
	 * @param param
	 *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
	 * @return ������Զ����Դ����Ӧ���
	 */
	// public static String sendPostmeg(String url, String param) {
	//
	// }
	public static String sendPost(String url, String param) {
		OutputStream out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();
			// // ����ͨ�õ���������
			// conn.setRequestProperty("accept", "*/*");
			// conn.setRequestProperty("connection", "Keep-Alive");
			// conn.setRequestProperty("user-agent",
			// "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// ����POST�������������������
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// ��ȡURLConnection�����Ӧ�������
			// if (!param.equals("")) {
			out = conn.getOutputStream();
			// �����������
			out.write(param.getBytes("GBK"));
			// flush������Ļ���
			out.flush();
			// }
			// ����BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "GBK"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("���� POST ��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�����ر��������������
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
