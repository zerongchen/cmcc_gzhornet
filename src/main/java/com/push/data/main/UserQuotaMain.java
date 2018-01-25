package com.push.data.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import com.push.data.config.Config;
import com.push.data.dao.ReadOracleDao;
import com.push.data.util.DateUtil;
import com.push.data.util.FileUtil;
import com.push.data.util.SqlUtils_ReadOracle;

/**
 * @describe 用户告警指标推送入口。
 * @date 2017-11-15
 * @author cym
 *
 */
public class UserQuotaMain {

	public static void main(String[] args) {

		try {

			if (args.length != 2) {
				System.out.println("args require [start_time][end_time]");
				System.exit(2);
			}

			String start_time = DateUtil.checkMinutes(args[0]);
			String end_time = DateUtil.checkMinutes(args[1]);

			if (!DateUtil.checkMinutesInterval(start_time, end_time, Config.getInstance().getTimeInterval())) {
				System.out.println(start_time+"-"+end_time+"开始时间和结束时间间隔不是 "+Config.getInstance().getTimeInterval()+"分钟 ");
				System.exit(1);
			}

			String path = Config.getInstance().getDataPath();
			String fileName = Config.getInstance().getUserQuotaPrefix() + "_" + start_time + ".csv";

			System.out.println("args is [" + start_time + "][" + end_time + "][" + path + "][" + fileName + "]");

			String read_sql = SqlUtils_ReadOracle.getReadUserQuotafromOracle(start_time, end_time);

			List<StringBuffer> StringBufferList = ReadOracleDao.readUserQuota(read_sql, start_time);

			File file = new File(path);

			if (!file.exists()) {
				System.out.println(path + "目录不存在,程序将新建该目录。");
				boolean b = file.mkdirs();
				if (b)
					System.out.println(path + "目录新建成功。");
			}

			FileUtil.flushDataToDisk(StringBufferList, path, fileName);

			System.out.println("[" + start_time + "]用户告警指标推送成功。");
		} catch (Exception e) {
			System.out.println("广州用户告警指标数据推送失败;" + e.getMessage());
			e.printStackTrace();
			System.exit(101);
		} finally {

		}
	}

}
