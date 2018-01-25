package com.push.data.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.push.data.config.Config;
import com.push.data.config.ConfigAnnotationPackage;



public class DBUtil {

	/**
	 * 获取一个数据库连接
	 * @return
	 */
	public static Connection getOracleConnection(){

		String driver = Config.getInstance().getOracle_db_driver();
		String url = Config.getInstance().getOracle_db_url();
		String user = Config.getInstance().getOracle_db_user();
		String password = Config.getInstance().getOracle_db_pwd();
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("获取数据库conn 出错"+e.getMessage());
			e.printStackTrace();
			System.exit(5);
		} catch (SQLException e) {
			System.out.println("获取数据库conn 出错"+e.getMessage());
			e.printStackTrace();
			System.exit(5);
		}
		return conn;
	}

	/**
	 * 关闭一个数据库连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(""+e);
			//	LogUtil.dgmobile_network.error("",e);
			}
			conn = null;
		}
	}

	// 关闭数据库连接，释放回数据库连接池
	public static void closeConnection(Connection conn, java.sql.Statement st,
			ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			conn = null;

			if (st != null) {
				st.close();
			}
			st = null;
			if (rs != null) {
				rs.close();
			}
			rs = null;
		} catch (Exception ex) {
		}
	}

	// 关闭数据库连接，释放回数据库连接池
	public static void closeConnection(Connection conn, java.sql.Statement st) {
		try {
			if (conn != null) {
				conn.close();
			}
			conn = null;

			if (st != null) {
				st.close();
			}
			st = null;
		} catch (Exception ex) {
			System.out.println(""+ex);
		}
	}
}
