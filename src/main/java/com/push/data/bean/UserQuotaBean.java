package com.push.data.bean;

import com.push.data.config.Config;

/**
 *
 * @describe 推送告警数据，对象为 用户
 *
 * @author cym
 *
 */
public class UserQuotaBean {

	/**
	 * 时间
	 */
	private String r_stattime;
	/**
	 * 类型
	 */
	private long device_type;
	/**
	 * 账号
	 */
	private String service_account;
	/**
	 * 上行流量
	 */
	private long traffic_up;
	/**
	 * 下行流量
	 */
	private long traffic_dn;
	/**
	 * 总流量
	 */
	private long traffic_total;
	/**
	 * 握手延时
	 */
	private long shakehands_delay;
	/**
	 * 客户端延时
	 */
	private long client_delay;
	/**
	 * 服务端延时
	 */
	private long server_delay;
	/**
	 * dns延时
	 */
	private long dns_delay;
	/**
	 * dns解析成功率
	 */
	private double dnsanaly_rate;
	/**
	 * dns响应成功率
	 */
	private double dnsresponse_rate;
	/**
	 * TCP链接次数
	 */
	private long tcpconnect_count;
	/**
	 * TCP链接成功次数
	 */
	private long tcpsuccessconnect_count;
	/**
	 * TCP链接成功率
	 */
	private double tcpsuccessconnect_rate;
	/**
	 * TCP重传包数
	 */
	private long tcpdatarecon;
	/**
	 * TCP数据包数
	 */
	private long tcpdatapkgs;
	/**
	 * TCP重传率
	 */
	private double tcp_retransmit_rate;
	/**
	 * TCP上次重传率
	 */
	private double tcp_up_retransmit_rate;
	/**
	 *
	 */
	private double tcp_dn_retransmit_rate;
	/**
	 *
	 */
	private double tcp_first_handshake_suc_rate;
	/**
	 *
	 */
	private double tcp_second_handshake_suc_rate;
	/**
	 *
	 */
	private long http_delay;
	/**
	 *
	 */
	private long httprequest_delay;
	/**
	 *
	 */
	private long httpresp_delay;
	/**
	 *
	 */
	private long httpload_delay;
	/**
	 *
	 */
	private long firstbyte_loadingtime;
	/**
	 *
	 */
	private long httpgettimes;
	/**
	 *
	 */
	private long httpgetsuctimes;
	/**
	 *
	 */
	private long httpposttimes;
	/**
	 *
	 */
	private long httppostsuctimes;
	/**
	 *
	 */
	private long responsetimes;
	/**
	 *
	 */
	private long responsesuctimes;
	/**
	 *
	 */
	private long responseerrortimes;
	/**
	 *
	 */
	private double http_resp_normal_rate;
	/**
	 *
	 */
	private double http_resp_suc_rate;
	/**
	 *
	 */
	private long responseredirecttimes;
	/**
	 * 重定向率
	 */
	private double redirect_rate;

	public String getR_stattime() {
		return r_stattime;
	}
	public void setR_stattime(String r_stattime) {
		this.r_stattime = r_stattime;
	}
	public long getDevice_type() {
		return device_type;
	}
	public void setDevice_type(long device_type) {
		this.device_type = device_type;
	}
	public String getService_account() {
		return service_account;
	}
	public void setService_account(String service_account) {
		this.service_account = service_account;
	}
	public long getTraffic_up() {
		return traffic_up;
	}
	public void setTraffic_up(long traffic_up) {
		this.traffic_up = traffic_up;
	}
	public long getTraffic_dn() {
		return traffic_dn;
	}
	public void setTraffic_dn(long traffic_dn) {
		this.traffic_dn = traffic_dn;
	}
	public long getTraffic_total() {
		return traffic_total;
	}
	public void setTraffic_total(long traffic_total) {
		this.traffic_total = traffic_total;
	}
	public long getShakehands_delay() {
		return shakehands_delay;
	}
	public void setShakehands_delay(long shakehands_delay) {
		this.shakehands_delay = shakehands_delay;
	}
	public long getClient_delay() {
		return client_delay;
	}
	public void setClient_delay(long client_delay) {
		this.client_delay = client_delay;
	}
	public long getServer_delay() {
		return server_delay;
	}
	public void setServer_delay(long server_delay) {
		this.server_delay = server_delay;
	}
	public long getDns_delay() {
		return dns_delay;
	}
	public void setDns_delay(long dns_delay) {
		this.dns_delay = dns_delay;
	}
	public double getDnsanaly_rate() {
		return dnsanaly_rate;
	}
	public void setDnsanaly_rate(double dnsanaly_rate) {
		this.dnsanaly_rate = dnsanaly_rate;
	}
	public double getDnsresponse_rate() {
		return dnsresponse_rate;
	}
	public void setDnsresponse_rate(double dnsresponse_rate) {
		this.dnsresponse_rate = dnsresponse_rate;
	}
	public long getTcpconnect_count() {
		return tcpconnect_count;
	}
	public void setTcpconnect_count(long tcpconnect_count) {
		this.tcpconnect_count = tcpconnect_count;
	}
	public long getTcpsuccessconnect_count() {
		return tcpsuccessconnect_count;
	}
	public void setTcpsuccessconnect_count(long tcpsuccessconnect_count) {
		this.tcpsuccessconnect_count = tcpsuccessconnect_count;
	}
	public double getTcpsuccessconnect_rate() {
		return tcpsuccessconnect_rate;
	}
	public void setTcpsuccessconnect_rate(double tcpsuccessconnect_rate) {
		this.tcpsuccessconnect_rate = tcpsuccessconnect_rate;
	}
	public long getTcpdatarecon() {
		return tcpdatarecon;
	}
	public void setTcpdatarecon(long tcpdatarecon) {
		this.tcpdatarecon = tcpdatarecon;
	}
	public long getTcpdatapkgs() {
		return tcpdatapkgs;
	}
	public void setTcpdatapkgs(long tcpdatapkgs) {
		this.tcpdatapkgs = tcpdatapkgs;
	}
	public double getTcp_retransmit_rate() {
		return tcp_retransmit_rate;
	}
	public void setTcp_retransmit_rate(double tcp_retransmit_rate) {
		this.tcp_retransmit_rate = tcp_retransmit_rate;
	}
	public double getTcp_up_retransmit_rate() {
		return tcp_up_retransmit_rate;
	}
	public void setTcp_up_retransmit_rate(double tcp_up_retransmit_rate) {
		this.tcp_up_retransmit_rate = tcp_up_retransmit_rate;
	}
	public double getTcp_dn_retransmit_rate() {
		return tcp_dn_retransmit_rate;
	}
	public void setTcp_dn_retransmit_rate(double tcp_dn_retransmit_rate) {
		this.tcp_dn_retransmit_rate = tcp_dn_retransmit_rate;
	}
	public double getTcp_first_handshake_suc_rate() {
		return tcp_first_handshake_suc_rate;
	}
	public void setTcp_first_handshake_suc_rate(double tcp_first_handshake_suc_rate) {
		this.tcp_first_handshake_suc_rate = tcp_first_handshake_suc_rate;
	}
	public double getTcp_second_handshake_suc_rate() {
		return tcp_second_handshake_suc_rate;
	}
	public void setTcp_second_handshake_suc_rate(double tcp_second_handshake_suc_rate) {
		this.tcp_second_handshake_suc_rate = tcp_second_handshake_suc_rate;
	}
	public long getHttp_delay() {
		return http_delay;
	}
	public void setHttp_delay(long http_delay) {
		this.http_delay = http_delay;
	}
	public long getHttprequest_delay() {
		return httprequest_delay;
	}
	public void setHttprequest_delay(long httprequest_delay) {
		this.httprequest_delay = httprequest_delay;
	}
	public long getHttpresp_delay() {
		return httpresp_delay;
	}
	public void setHttpresp_delay(long httpresp_delay) {
		this.httpresp_delay = httpresp_delay;
	}
	public long getHttpload_delay() {
		return httpload_delay;
	}
	public void setHttpload_delay(long httpload_delay) {
		this.httpload_delay = httpload_delay;
	}
	public long getFirstbyte_loadingtime() {
		return firstbyte_loadingtime;
	}
	public void setFirstbyte_loadingtime(long firstbyte_loadingtime) {
		this.firstbyte_loadingtime = firstbyte_loadingtime;
	}
	public long getHttpgettimes() {
		return httpgettimes;
	}
	public void setHttpgettimes(long httpgettimes) {
		this.httpgettimes = httpgettimes;
	}
	public long getHttpgetsuctimes() {
		return httpgetsuctimes;
	}
	public void setHttpgetsuctimes(long httpgetsuctimes) {
		this.httpgetsuctimes = httpgetsuctimes;
	}
	public long getHttpposttimes() {
		return httpposttimes;
	}
	public void setHttpposttimes(long httpposttimes) {
		this.httpposttimes = httpposttimes;
	}
	public long getHttppostsuctimes() {
		return httppostsuctimes;
	}
	public void setHttppostsuctimes(long httppostsuctimes) {
		this.httppostsuctimes = httppostsuctimes;
	}
	public long getResponsetimes() {
		return responsetimes;
	}
	public void setResponsetimes(long responsetimes) {
		this.responsetimes = responsetimes;
	}
	public long getResponsesuctimes() {
		return responsesuctimes;
	}
	public void setResponsesuctimes(long responsesuctimes) {
		this.responsesuctimes = responsesuctimes;
	}
	public long getResponseerrortimes() {
		return responseerrortimes;
	}
	public void setResponseerrortimes(long responseerrortimes) {
		this.responseerrortimes = responseerrortimes;
	}
	public double getHttp_resp_normal_rate() {
		return http_resp_normal_rate;
	}
	public void setHttp_resp_normal_rate(double http_resp_normal_rate) {
		this.http_resp_normal_rate = http_resp_normal_rate;
	}
	public double getHttp_resp_suc_rate() {
		return http_resp_suc_rate;
	}
	public void setHttp_resp_suc_rate(double http_resp_suc_rate) {
		this.http_resp_suc_rate = http_resp_suc_rate;
	}
	public long getResponseredirecttimes() {
		return responseredirecttimes;
	}
	public void setResponseredirecttimes(long responseredirecttimes) {
		this.responseredirecttimes = responseredirecttimes;
	}
	public double getRedirect_rate() {
		return redirect_rate;
	}
	public void setRedirect_rate(double redirect_rate) {
		this.redirect_rate = redirect_rate;
	}

    public StringBuffer getBeanString(){

    	String sp = Config.getInstance().getDataSpilt();
    	StringBuffer sb = new StringBuffer();
    	sb.append(r_stattime.replace("-", "").replace(":", "").replace(" ", "")).append(sp);
    	sb.append(device_type).append(sp);
    	sb.append(service_account).append(sp);
    	sb.append(traffic_up).append(sp);
    	sb.append(traffic_dn).append(sp);
    	sb.append(traffic_total).append(sp);
    	sb.append(shakehands_delay).append(sp);
    	sb.append(client_delay).append(sp);
    	sb.append(server_delay).append(sp);
    	sb.append(dns_delay).append(sp);
    	sb.append(dnsanaly_rate).append(sp);
    	sb.append(dnsresponse_rate).append(sp);
    	sb.append(tcpconnect_count).append(sp);
    	sb.append(tcpsuccessconnect_count).append(sp);
    	sb.append(tcpsuccessconnect_rate).append(sp);
    	sb.append(tcpdatarecon).append(sp);
    	sb.append(tcpdatapkgs).append(sp);
    	sb.append(tcp_retransmit_rate).append(sp);
    	sb.append(tcp_up_retransmit_rate).append(sp);
    	sb.append(tcp_dn_retransmit_rate).append(sp);
    	sb.append(tcp_first_handshake_suc_rate).append(sp);
    	sb.append(tcp_second_handshake_suc_rate).append(sp);
    	sb.append(http_delay).append(sp);
    	sb.append(httprequest_delay).append(sp);
    	sb.append(httpresp_delay).append(sp);
    	sb.append(httpload_delay).append(sp);
    	sb.append(firstbyte_loadingtime).append(sp);
    	sb.append(httpgettimes).append(sp);
    	sb.append(httpgetsuctimes).append(sp);
    	sb.append(httpposttimes).append(sp);
    	sb.append(httppostsuctimes).append(sp);
    	sb.append(responsetimes).append(sp);
    	sb.append(responsesuctimes).append(sp);
    	sb.append(responseerrortimes).append(sp);
    	sb.append(http_resp_normal_rate).append(sp);
    	sb.append(http_resp_suc_rate).append(sp);
    	sb.append(responseredirecttimes).append(sp);
    	sb.append(redirect_rate);
    	return sb;
    }
	@Override
	public String toString() {
		return "UserQuotaBean [r_stattime=" + r_stattime + ", device_type=" + device_type + ", service_account=" + service_account + ", traffic_up=" + traffic_up + ", traffic_dn=" + traffic_dn + ", traffic_total=" + traffic_total + ", shakehands_delay=" + shakehands_delay + ", client_delay=" + client_delay + ", server_delay=" + server_delay + ", dns_delay=" + dns_delay + ", dnsanaly_rate=" + dnsanaly_rate + ", dnsresponse_rate=" + dnsresponse_rate + ", tcpconnect_count=" + tcpconnect_count + ", tcpsuccessconnect_count=" + tcpsuccessconnect_count + ", tcpsuccessconnect_rate=" + tcpsuccessconnect_rate + ", tcpdatarecon=" + tcpdatarecon + ", tcpdatapkgs=" + tcpdatapkgs + ", tcp_retransmit_rate=" + tcp_retransmit_rate + ", tcp_up_retransmit_rate=" + tcp_up_retransmit_rate
				+ ", tcp_dn_retransmit_rate=" + tcp_dn_retransmit_rate + ", tcp_first_handshake_suc_rate=" + tcp_first_handshake_suc_rate + ", tcp_second_handshake_suc_rate=" + tcp_second_handshake_suc_rate + ", http_delay=" + http_delay + ", httprequest_delay=" + httprequest_delay + ", httpresp_delay=" + httpresp_delay + ", httpload_delay=" + httpload_delay + ", firstbyte_loadingtime=" + firstbyte_loadingtime + ", httpgettimes=" + httpgettimes + ", httpgetsuctimes=" + httpgetsuctimes + ", httpposttimes=" + httpposttimes + ", httppostsuctimes=" + httppostsuctimes + ", responsetimes=" + responsetimes + ", responsesuctimes=" + responsesuctimes + ", responseerrortimes=" + responseerrortimes + ", http_resp_normal_rate=" + http_resp_normal_rate + ", http_resp_suc_rate=" + http_resp_suc_rate
				+ ", responseredirecttimes=" + responseredirecttimes + ", redirect_rate=" + redirect_rate + "]";
	}



}
