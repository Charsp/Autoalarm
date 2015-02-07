package org.tool.data.autoclass;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	private static Properties prop = new Properties();
	private static String classPath = "com.swz.data.vo.mysql";
	private static String mavenPath = "\\src\\";
	static {
		ClassLoader loader = DBUtils.class.getClassLoader();
		InputStream in = loader.getResourceAsStream("config.properties");
		try {
			prop.load(in);
			Class.forName(prop.getProperty("driver"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("异常！！");
		}
	}

	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("username"), prop.getProperty("password"));
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String getClassPath() {
		if (prop.containsKey("classpath")) {
			classPath = prop.getProperty("classpath");
		}
		return classPath;
	}

	public static String getMavenPath() {
		if (prop.containsKey("maven")
				&& prop.getProperty("maven").equals("true")) {
			mavenPath = "\\src\\main\\java\\";
		}
		return System.getProperty("user.dir") + mavenPath;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
}
