package com.push.data.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {

	/**
	 * @describe 写文件
	 * @param StringBufferList
	 * @param path
	 * @param fileName
	 * @throws IOException
	 */
	public static void flushDataToDisk(List<StringBuffer> StringBufferList, String path, String fileName) throws IOException {
		FileWriter fw = null;

		path = path.endsWith("/") ? path : (path + "/");

		File file = new File(path + fileName);
		if(!file.exists()){
			boolean b = file.createNewFile();
			if(!b)
			System.out.println("创建文件{"+file.getAbsolutePath()+"}失败！");

			System.out.println("创建文件{"+file.getAbsolutePath()+"}成功！");

		}

		fw = new FileWriter(file);

		for (StringBuffer sb : StringBufferList) {
			fw.write(sb.append("\r\n").toString());
		}

		fw.close();
	}

}
