package com.push.data.config;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ConfigAnnotationPackage {

	@SuppressWarnings("rawtypes")
	public static void packageConfig(BaseConfig config) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //azkaban zip包中用路径
		String configPath = System.getProperty("user.dir") + "/../config/config.properties";

		if(!(new File(configPath)).exists()){
			//本地测试用路径
			configPath = System.getProperty("user.dir") + "/config/config.properties";
		}

		Properties resource = new Properties();
		try {
			resource.load(new InputStreamReader(new FileInputStream(configPath), "UTF-8"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		Class c = config.getClass();

		@SuppressWarnings("unchecked")
		boolean isExists = c.isAnnotationPresent(ConfigClassAnnotation.class);

		if (isExists) {

			Field[] fArray = c.getDeclaredFields();

			for (Field f : fArray) {
				boolean fieldIsExist = f.isAnnotationPresent(ConfigFieldAnnotation.class);

				if (fieldIsExist) {
					ConfigFieldAnnotation ConfigFieldAnnotation = (ConfigFieldAnnotation) f.getAnnotation(ConfigFieldAnnotation.class);
					String field_properties = ConfigFieldAnnotation.value();
					String field_value = resource.getProperty(field_properties);

					String type = f.getGenericType().toString();
					if (type.equals("class java.lang.String")) {
						// 属性名字
						String fieldName = f.getName();
						// set方法名字
						String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
						@SuppressWarnings("unchecked")
						Method m = c.getMethod(methodName, String.class);
						m.invoke(config, field_value);
					}

				}

			}

		}

	}

}
