package com.push.data.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.push.data.bean.AppQuotaBean;
import com.push.data.bean.DeviceQuotaBean;
import com.push.data.bean.IcpwebQuotaBean;
import com.push.data.bean.UserGroupQuotaBean;
import com.push.data.bean.UserQuotaBean;
import com.push.data.util.DBUtil;
import com.push.data.util.SqlUtils_ReadOracle;

public class ReadOracleDao {

	/**
	 * @describe 获取用户告警指标dao
	 * @author cym
	 * @param sql
	 * @param r_stattime
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<StringBuffer> readUserQuota(String sql, String r_stattime) {
		List<StringBuffer> modelList = new ArrayList<StringBuffer>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn =null;
		System.out.println("["+r_stattime+"]读取用户告警指标数据sql为:"+sql);
		try {
			conn = DBUtil.getOracleConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				UserQuotaBean model = new UserQuotaBean();
				packageBeanWithResult(rs,model);
				modelList.add(model.getBeanString());
			}

			if(modelList.size()==0)
				System.out.println("["+r_stattime+"]读取到数据集合为空,请检查是否有数据入库延时。");
			System.out.println("["+r_stattime+"]读取用户指标数据成功,数据条数为:"+modelList.size());
		} catch (Exception e) {
			System.out.println("["+r_stattime+"]读取用户指标数据抛异常;"+e.getMessage());
			e.printStackTrace();
			System.exit(3);
		}finally{
			DBUtil.closeConnection(conn, pstmt, rs);
		}

		return modelList;
	}

	/**
	 * @describe 获取ICP网站告警指标dao
	 * @author cym
	 * @param sql
	 * @param r_stattime
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<StringBuffer> readIcpwebQuota(String sql, String r_stattime) {
		List<StringBuffer> modelList = new ArrayList<StringBuffer>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn =null;
		System.out.println("["+r_stattime+"]读取ICP网站告警指标数据sql为:"+sql);
		try {
			conn = DBUtil.getOracleConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				IcpwebQuotaBean model = new IcpwebQuotaBean();
				packageBeanWithResult(rs,model);
				modelList.add(model.getBeanString());
			}

			if(modelList.size()==0)
				System.out.println("["+r_stattime+"]读取到数据集合为空,请检查是否有数据入库延时。");
			System.out.println("["+r_stattime+"]读取ICP网站指标数据成功,数据条数为:"+modelList.size());
		} catch (Exception e) {
			System.out.println("["+r_stattime+"]读取ICP网站指标数据抛异常;"+e.getMessage());
			e.printStackTrace();
			System.exit(3);
		}finally{
			DBUtil.closeConnection(conn, pstmt, rs);
		}

		return modelList;
	}

	/**
	 * @describe 获取应用告警指标dao
	 * @author cym
	 * @param sql
	 * @param r_stattime
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<StringBuffer> readAppQuota(String sql, String r_stattime) {
		List<StringBuffer> modelList = new ArrayList<StringBuffer>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn =null;
		System.out.println("["+r_stattime+"]读取应用告警指标数据sql为:"+sql);
		try {
			conn = DBUtil.getOracleConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				AppQuotaBean model = new AppQuotaBean();
				packageBeanWithResult(rs,model);
				modelList.add(model.getBeanString());
			}

			if(modelList.size()==0)
				System.out.println("["+r_stattime+"]读取到数据集合为空,请检查是否有数据入库延时。");
			System.out.println("["+r_stattime+"]读取应用指标数据成功,数据条数为:"+modelList.size());
		} catch (Exception e) {
			System.out.println("["+r_stattime+"]读取应用指标数据抛异常;"+e.getMessage());
			e.printStackTrace();
			System.exit(3);
		}finally{
			DBUtil.closeConnection(conn, pstmt, rs);
		}

		return modelList;
	}

	/**
	 * @describe 获取用户组告警指标dao
	 * @author cym
	 * @param sql
	 * @param r_stattime
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<StringBuffer> readUsergroupQuota(String sql, String r_stattime) {
		List<StringBuffer> modelList = new ArrayList<StringBuffer>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn =null;
		System.out.println("["+r_stattime+"]读取用户组告警指标数据sql为:"+sql);
		try {
			conn = DBUtil.getOracleConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				UserGroupQuotaBean model = new UserGroupQuotaBean();
				packageBeanWithResult(rs,model);
				modelList.add(model.getBeanString());
			}

			if(modelList.size()==0)
				System.out.println("["+r_stattime+"]读取到数据集合为空,请检查是否有数据入库延时。");
			System.out.println("["+r_stattime+"]读取用户组指标数据成功,数据条数为:"+modelList.size());
		} catch (Exception e) {
			System.out.println("["+r_stattime+"]读取用户组指标数据抛异常;"+e.getMessage());
			e.printStackTrace();
			System.exit(3);
		}finally{
			DBUtil.closeConnection(conn, pstmt, rs);
		}

		return modelList;
	}

	/**
	 * @describe 获取设备告警指标dao
	 * @author cym
	 * @param sql
	 * @param r_stattime
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<StringBuffer> readDeviceQuota(String sql, String r_stattime) {
		List<StringBuffer> modelList = new ArrayList<StringBuffer>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn =null;
		System.out.println("["+r_stattime+"]读取设备告警指标数据sql为:"+sql);
		try {
			conn = DBUtil.getOracleConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				DeviceQuotaBean model = new DeviceQuotaBean();
				packageBeanWithResult(rs,model);
				modelList.add(model.getBeanString());
			}

			if(modelList.size()==0)
				System.out.println("["+r_stattime+"]读取到数据集合为空,请检查是否有数据入库延时。");
			System.out.println("["+r_stattime+"]读取设备指标数据成功,数据条数为:"+modelList.size());
		} catch (Exception e) {
			System.out.println("["+r_stattime+"]读取设备指标数据抛异常;"+e.getMessage());
			e.printStackTrace();
			System.exit(3);
		}finally{
			DBUtil.closeConnection(conn, pstmt, rs);
		}

		return modelList;
	}

	/**
	 * @describe 组装 Bean
	 * @author cym
	 * @param rs
	 * @param model
	 * @throws SQLException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void packageBeanWithResult(ResultSet rs, Object model) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Class c = model.getClass();

		Field[] fields = c.getDeclaredFields();

		for(Field d : fields){
			String fieldName = d.getName();
			String methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);

			Object value = null;
			if("class java.lang.String".equals(d.getGenericType().toString())){
				value = rs.getString(fieldName);
				Method m = c.getMethod(methodName, String.class);
				m.invoke(model, value);
			}
			if("long".equals(d.getGenericType().toString())){
				value = rs.getLong(fieldName);
				Method m = c.getMethod(methodName, long.class);
				m.invoke(model, value);
			}
			if("double".equals(d.getGenericType().toString())){
				value = rs.getDouble(fieldName);
				Method m = c.getMethod(methodName, double.class);
				m.invoke(model, value);
			}
		}
	}


	public static void main(String[] args) {

		String sql = SqlUtils_ReadOracle.getReadUserQuotafromOracle("2017-08-02 16:55", "2017-08-02 17:00");
		List<StringBuffer> list = ReadOracleDao.readUserQuota(sql, "2017-08-02 16:55");
		System.out.println(list);
	}

}
