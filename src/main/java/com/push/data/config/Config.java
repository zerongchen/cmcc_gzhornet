package com.push.data.config;

/**
 * @describe 配置文件类(根据注解进行配置,新增配置会更方便)
 * @date 2017-11-14
 * @author cym
 *
 */
@ConfigClassAnnotation("")
public class Config implements BaseConfig{

	/**
	 * oracle驱动
	 */
	@ConfigFieldAnnotation("config.oracle.db.driver")
	private String oracle_db_driver;

	/**
	 * URL
	 */
	@ConfigFieldAnnotation("config.oracle.db.url")
	private String oracle_db_url;

	/**
	 * user
	 */
	@ConfigFieldAnnotation("config.oracle.db.user")
	private String oracle_db_user;

	/** pwd
	 *
	 */
	@ConfigFieldAnnotation("config.oracle.db.pwd")
	private String oracle_db_pwd;

	/**
	 * 推送的延时时间(默认为30分钟)
	 */
	@ConfigFieldAnnotation("config.aheadOfTime")
	private String aheadOfTime;

	/**
	 * 推送的频率(默认为5分钟)
	 */
	@ConfigFieldAnnotation("config.timeInterval")
	private String timeInterval;

	/**
	 * 推送文件中的字段分隔符
	 */
	@ConfigFieldAnnotation("config.data.spilt")
	private String dataSpilt;

	/**
	 * 推送的文件放在服务器目录
	 */
	@ConfigFieldAnnotation("config.data.path")
    private String dataPath;

	/**
	 * 推送的文件[用户]指标文件前缀
	 */
	@ConfigFieldAnnotation("config.file.userQuota.prefix")
    private String userQuotaPrefix;

	/**
	 * 推送的文件[设备{bras,olt,bng,sr}]指标文件前缀
	 */
	@ConfigFieldAnnotation("config.file.deviceQuota.prefix")
    private String deviceQuotaPrefix;

	/**
	 * 推送的[应用app]指标文件前缀
	 */
	@ConfigFieldAnnotation("config.file.appQuota.prefix")
    private String appQuotaPrefix;

	/**
	 * 推送的[ICP网站]指标文件前缀
	 */
	@ConfigFieldAnnotation("config.file.icpQuota.prefix")
    private String icpQuotaPrefix;

	/**
	 * 推送的[用户组]指标文件前缀
	 */
	@ConfigFieldAnnotation("config.file.userGroupQuota.prefix")
    private String userGroupQuotaPrefix;


	private static Config instance;

	public String getOracle_db_driver() {
		return oracle_db_driver;
	}

	public void setOracle_db_driver(String oracle_db_driver) {
		this.oracle_db_driver = oracle_db_driver;
	}

	public String getOracle_db_url() {
		return oracle_db_url;
	}

	public void setOracle_db_url(String oracle_db_url) {
		this.oracle_db_url = oracle_db_url;
	}

	public String getOracle_db_user() {
		return oracle_db_user;
	}

	public void setOracle_db_user(String oracle_db_user) {
		this.oracle_db_user = oracle_db_user;
	}

	public String getOracle_db_pwd() {
		return oracle_db_pwd;
	}

	public void setOracle_db_pwd(String oracle_db_pwd) {
		this.oracle_db_pwd = oracle_db_pwd;
	}

	public String getAheadOfTime() {
		return aheadOfTime;
	}

	public void setAheadOfTime(String aheadOfTime) {
		this.aheadOfTime = aheadOfTime;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getDataSpilt() {
		return dataSpilt;
	}

	public void setDataSpilt(String dataSpilt) {
		this.dataSpilt = dataSpilt;
	}

	public String getDataPath() {
		return dataPath;
	}

	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}

	public String getUserQuotaPrefix() {
		return userQuotaPrefix;
	}

	public void setUserQuotaPrefix(String userQuotaPrefix) {
		this.userQuotaPrefix = userQuotaPrefix;
	}

	public String getDeviceQuotaPrefix() {
		return deviceQuotaPrefix;
	}

	public void setDeviceQuotaPrefix(String deviceQuotaPrefix) {
		this.deviceQuotaPrefix = deviceQuotaPrefix;
	}

	public String getAppQuotaPrefix() {
		return appQuotaPrefix;
	}

	public void setAppQuotaPrefix(String appQuotaPrefix) {
		this.appQuotaPrefix = appQuotaPrefix;
	}

	public String getIcpQuotaPrefix() {
		return icpQuotaPrefix;
	}

	public void setIcpQuotaPrefix(String icpQuotaPrefix) {
		this.icpQuotaPrefix = icpQuotaPrefix;
	}

	public String getUserGroupQuotaPrefix() {
		return userGroupQuotaPrefix;
	}

	public void setUserGroupQuotaPrefix(String userGroupQuotaPrefix) {
		this.userGroupQuotaPrefix = userGroupQuotaPrefix;
	}

	public synchronized static Config getInstance() {
		if (instance == null) {
			instance = new Config();
			try {
				ConfigAnnotationPackage.packageConfig(instance);
			} catch (Exception e) {
                System.out.println("获取配置文件失败"+e);
                e.printStackTrace();
                System.exit(4);
			}
		}
		return instance;
	}

	@Override
	public String toString() {
		return "Config [oracle_db_driver=" + oracle_db_driver + ", oracle_db_url=" + oracle_db_url + ", oracle_db_user=" + oracle_db_user + ", oracle_db_pwd=" + oracle_db_pwd + ", aheadOfTime=" + aheadOfTime + ", timeInterval=" + timeInterval + ", dataSpilt=" + dataSpilt + ", dataPath=" + dataPath + ", userQuotaPrefix=" + userQuotaPrefix + ", deviceQuotaPrefix=" + deviceQuotaPrefix + ", appQuotaPrefix=" + appQuotaPrefix + ", icpQuotaPrefix=" + icpQuotaPrefix + ", userGroupQuotaPrefix=" + userGroupQuotaPrefix + "]";
	}

}
