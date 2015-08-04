package org.tool.data.autoclass;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class GenEntityTool {
	private String[] colNames;// 列名数组
	private String[] colType;// 列名类型数组
	private int[] colSize;// 列名大小数组
	private boolean f_util = false;// 是否需要导入java.util.*
	private boolean f_sql = false;// 是否需要导入java.sql.*

	public GenEntityTool() {
	}

	public GenEntityTool(String tabName) {

		Connection conn = null;
		String sql = "select * from " + tabName;
		try {
			conn = DBUtils.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSetMetaData rsmd = prep.getMetaData();
			int size = rsmd.getColumnCount();// 共有多少列
			colNames = new String[size];
			colType = new String[size];
			colSize = new int[size];
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				colNames[i] = rsmd.getColumnName(i + 1);
				colType[i] = rsmd.getColumnTypeName(i + 1);
				if (colType[i].equalsIgnoreCase("datetime")
						|| colType[i].equalsIgnoreCase("date")) {
					f_util = true;
				}
				if (colType[i].equalsIgnoreCase("text")
						|| colType[i].equalsIgnoreCase("image")) {
					f_sql = true;
				}
				colSize[i] = rsmd.getColumnDisplaySize(i + 1);
			}
			String content = parse(tabName, colNames, colType, colSize);
			File dir = new File(DBUtils.getMavenPath()
					+ DBUtils.getClassPath().replace(".", "\\") + "\\");
			if (!dir.exists()) {
				dir.mkdirs();
				System.out.println("创建目录" + DBUtils.getMavenPath()
						+ DBUtils.getClassPath().replace(".", "\\") + "\\"
						+ "成功！");
			}

			FileWriter fw = new FileWriter(DBUtils.getMavenPath()
					+ DBUtils.getClassPath().replace(".", "\\") + "\\"
					+ initCap(tabName) + ".java");
			System.out.println("目标文件" + DBUtils.getMavenPath()
					+ DBUtils.getClassPath().replace(".", "\\") + "\\"
					+ initCap(tabName) + ".java" + "生成！");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(content);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
	}

	/**
	 * 解析处理，生成java实体类主体代码
	 * 
	 * @param tabName
	 * @param colNames
	 * @param colType
	 * @param colSize
	 * @return
	 */
	private String parse(String tabName, String[] colNames, String[] colType,
			int[] colSize) {
		StringBuffer sb = new StringBuffer();
		// 所在包名
		sb.append("package " + DBUtils.getClassPath() + ";\r\n\r\n");
		// 引用包
		if (f_util) {
			sb.append("import java.util.Date;\r\n\r\n");
		}
		if (f_sql) {
			sb.append("import java.sql.*;\r\n\r\n\r\n");
		}
		// 类开始
		sb.append("public class " + initCap(tabName) + "{\r\n");
		// 添加所有属性
		processAllAttrs(sb);
		sb.append("\r\n");
		// 添加所有方法
		processAllMethod(sb);
		sb.append("\r\n");
		// 添加重写的toString方法
		processToString(sb);
		sb.append("}\r\n");
		return sb.toString();
	}

	private void processToString(StringBuffer sb) {
		sb.append("\t@Override\t\n");
		sb.append("\tpublic String toString() {\t\n");
		sb.append("\t\treturn \"{\"+");
		sb.append("\"\\\"" + colNames[0] + "\\\":\\\"\"+this." + colNames[0]
				+ "+\"\\\"\"");
		for (int i = 1; i < colNames.length; i++) {
			sb.append("+\",\\\"" + colNames[i] + "\\\":\\\"\"+this."
					+ colNames[i] + "+\"\\\"\"");
		}
		sb.append("+\"}\";");
		sb.append("\t}\r\n");
	}

	/*
	 * 生成所有的方法
	 */
	private void processAllMethod(StringBuffer sb) {
		for (int i = 0; i < colNames.length; i++) {
			sb.append("\tpublic void set" + initCap(colNames[i]) + "("
					+ sqlType2JavaType(colType[i]) + " " + colNames[i]
					+ "){\r\n");
			sb.append("\t\tthis." + colNames[i] + " = " + colNames[i] + ";\r\n");
			sb.append("\t}\r\n");

			sb.append("\tpublic " + sqlType2JavaType(colType[i]) + " get"
					+ initCap(colNames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colNames[i] + ";\r\n");
			sb.append("\t}\r\n");
		}
	}

	/*
	 * 解析输出属性
	 * 
	 * @return
	 */
	private void processAllAttrs(StringBuffer sb) {
		for (int i = 0; i < colNames.length; i++) {
			sb.append("\tprivate " + sqlType2JavaType(colType[i]) + " "
					+ colNames[i] + ";\r\n");
		}
	}

	/*
	 * 把输入字符串的首字母变成大写
	 * 
	 * @param str
	 * 
	 * @return
	 */
	private String initCap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	private String sqlType2JavaType(String sqlType) {
		if (sqlType.equalsIgnoreCase("bit")) {
			// return "boolean";
			return "Boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")
				|| sqlType.equalsIgnoreCase("TINYINT UNSIGNED")) {
			// return "byte";
			return "Byte";
		} else if (sqlType.equalsIgnoreCase("smallint")) {
			// return "short";
			return "Short";
		} else if (sqlType.equalsIgnoreCase("bigint")
				|| sqlType.equalsIgnoreCase("BIGINT UNSIGNED")
				|| sqlType.equalsIgnoreCase("TIMESTAMP")) {
			// return "long";
			return "Long";
		} else if (sqlType.equalsIgnoreCase("integer")
				|| sqlType.equalsIgnoreCase("INTEGER UNSIGNED")
				|| sqlType.equalsIgnoreCase("int")
				|| sqlType.equalsIgnoreCase("INT UNSIGNED")) {
			// return "int";
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("float")) {
			// return "float";
			return "Float";
		} else if (sqlType.equalsIgnoreCase("decimal")
				|| sqlType.equalsIgnoreCase("numeric")
				|| sqlType.equalsIgnoreCase("double")
				|| sqlType.equalsIgnoreCase("real")) {
			return "double";
		} else if (sqlType.equalsIgnoreCase("money")
				|| sqlType.equalsIgnoreCase("smallmoney")) {
			// return "double";
			return "Double";
		} else if (sqlType.equalsIgnoreCase("varchar")
				|| sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar")
				|| sqlType.equalsIgnoreCase("nchar")) {
			return "String";
		} else if (sqlType.equalsIgnoreCase("datetime")
				|| sqlType.equalsIgnoreCase("date")) {
			return "Date";
		}

		else if (sqlType.equalsIgnoreCase("image")) {
			return "Blob";
		} else if (sqlType.equalsIgnoreCase("text")) {
			return "Clob";
		}
		System.err.println("类型未知" + sqlType);
		return null;
	}

	/*
	 * 读取数据库中的表名
	 * 
	 * @return表名的String数组
	 */
	private static String[] getTabNames() {
		Connection conn = null;
		String sql = "show tables";
		String[] tabNames = null;

		try {
			conn = DBUtils.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			rs.last();
			int size = rs.getRow();
			tabNames = new String[size];
			rs.beforeFirst();
			int i = 0;
			while (rs.next() && i < size) {
				tabNames[i] = rs.getString(1);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
		}
		return tabNames;
	}

	public static void main(String[] args) {
		System.out.println("开始生成代码");
		String[] tabNames = getTabNames();
		for (int i = 0; i < tabNames.length; i++) {
			new GenEntityTool(tabNames[i]);
		}
		System.out.println("目标文件生成结束！");
	}
}
