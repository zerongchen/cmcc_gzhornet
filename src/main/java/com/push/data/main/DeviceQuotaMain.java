package com.push.data.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.push.data.config.Config;
import com.push.data.dao.ReadOracleDao;
import com.push.data.util.DateUtil;
import com.push.data.util.FileUtil;
import com.push.data.util.SqlUtils_ReadOracle;

/**
 * @describe 设备[bras,olt,bng,sr]告警指标推送入口。
 * @date 2017-11-15
 * @author cym
 *
 */
public class DeviceQuotaMain {

	public static void main(String[] args) {

		try {

			if (args.length != 2) {
				System.out.println("args require [start_time][end_time]");
				System.exit(2);
			}

			String start_time = DateUtil.checkMinutes(args[0]);
			String end_time = DateUtil.checkMinutes(args[1]);

			if (!DateUtil.checkMinutesInterval(start_time, end_time, Config.getInstance().getTimeInterval())) {
				System.out.println(start_time + "-" + end_time + "开始时间和结束时间间隔不是 " + Config.getInstance().getTimeInterval() + "分钟 ");
				System.exit(1);
			}

			String path = Config.getInstance().getDataPath();
			String fileName = Config.getInstance().getDeviceQuotaPrefix() + "_" + start_time + ".csv";

			System.out.println("args is [" + start_time + "][" + end_time + "][" + path + "][" + fileName + "]");
			System.out.println(Config.getInstance());
			String read_bras_olt_sql = SqlUtils_ReadOracle.getReadBrasOltQuotafromOracle(start_time, end_time);
			String read_bng_sr_sql = SqlUtils_ReadOracle.getReadBngSrSwQuotafromOracle(start_time, end_time);

			List<StringBuffer> deviceList = new ArrayList<StringBuffer>();
			List<StringBuffer> list1 = ReadOracleDao.readDeviceQuota(read_bras_olt_sql, start_time);
			List<StringBuffer> list2 = ReadOracleDao.readDeviceQuota(read_bng_sr_sql, start_time);

			deviceList.addAll(list1);
			deviceList.addAll(list2);
			File file = new File(path);

			if (!file.exists()) {
				System.out.println(path + "目录不存在,程序将新建该目录。");
				boolean b = file.mkdirs();
				if (b)
					System.out.println(path + "目录新建成功。");
			}

			FileUtil.flushDataToDisk(deviceList, path, fileName);

			System.out.println("[" + start_time + "]设备告警指标推送成功。");
		} catch (Exception e) {
			System.out.println("广州设备告警指标数据推送失败;" + e.getMessage());
			e.printStackTrace();
			System.exit(101);
		} finally {

		}
	}

}
