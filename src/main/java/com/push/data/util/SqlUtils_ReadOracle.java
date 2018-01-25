package com.push.data.util;


public class SqlUtils_ReadOracle {

	/**
	 * @describe 广州告警推送-用户指标数据
	 * @author cym
	 * @date 2017-11-14
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static String getReadUserQuotafromOracle(String sTime, String eTime) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("q1.R_STATTIME ");
		sb.append(",q1.DEVICE_TYPE ");
		sb.append(",q1.SERVICE_ACCOUNT ");
		sb.append(",SUM(TRAFFIC_UP) AS TRAFFIC_UP ");
		sb.append(",SUM(TRAFFIC_DN) AS TRAFFIC_DN ");
		sb.append(",SUM(TRAFFIC_UP+TRAFFIC_DN) AS TRAFFIC_TOTAL ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,-999900,SUM(SHAKEHANDS_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SHAKEHANDS_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,-999900,SUM(CLIENT_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS CLIENT_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,-999900,SUM(SERVER_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SERVER_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNS_SESSION_SUC_COUNT),0),0,-999900,SUM(DNS_DELAY) / SUM(DNS_SESSION_SUC_COUNT)), 4) AS DNS_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,-9999,SUM(DNSANALYSUCTIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSANALY_RATE ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,-9999,SUM(DNSRESPONSETIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSRESPONSE_RATE ");
		sb.append(",SUM(TCPCONNECT_COUNT) AS TCPCONNECT_COUNT ");
		sb.append(",SUM(TCPSUCCESSCONNECT_COUNT) AS TCPSUCCESSCONNECT_COUNT ");
		sb.append(",TRUNC(DECODE(SUM(TCPCONNECT_COUNT),0,-9999,SUM(TCPSUCCESSCONNECT_COUNT) / SUM(TCPCONNECT_COUNT)), 4)*100 AS TCPSUCCESSCONNECT_RATE ");
		sb.append(",SUM(TCPUPRECON+TCPDOWNRECON) AS TCPDATARECON ");
		sb.append(",SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS) AS TCPDATAPKGS ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS),0,-9999,SUM(TCPUPRECON+TCPDOWNRECON) / SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS)), 4)*100 AS TCP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS),0,-9999,SUM(TCPUPRECON) / SUM(TCPUPDATAPKGS)), 4)*100 AS TCP_UP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPDOWNDATAPKGS),0,-9999,SUM(TCPDOWNRECON) / SUM(TCPDOWNDATAPKGS)), 4)*100 AS TCP_DN_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(FIRSTHANDSHAKESYN_COUNT),0,-9999,SUM(SECONDHANDSHAKESYNACK_COUNT) / SUM(FIRSTHANDSHAKESYN_COUNT)), 4)*100 AS TCP_FIRST_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(SECONDHANDSHAKESYNACK_COUNT),0,-9999,SUM(THIRDHANDSHAKEACK_COUNT) / SUM(SECONDHANDSHAKESYNACK_COUNT)), 4)*100 AS TCP_SECOND_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,-999900,SUM(HTTP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,-999900,SUM(HTTPREQUEST_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPREQUEST_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,-999900,SUM(HTTPRESP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPRESP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,-999900,SUM(HTTPLOAD_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPLOAD_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,-999900,SUM(FIRSTBYTE_LOADINGTIME) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS FIRSTBYTE_LOADINGTIME ");
		sb.append(",SUM(HTTPGETTIMES) AS HTTPGETTIMES ");
		sb.append(",SUM(HTTPGETSUCTIMES) AS HTTPGETSUCTIMES ");
		sb.append(",SUM(HTTPPOSTTIMES) AS HTTPPOSTTIMES ");
		sb.append(",SUM(HTTPPOSTSUCTIMES) AS HTTPPOSTSUCTIMES ");
		sb.append(",SUM(RESPONSETIMES) AS RESPONSETIMES ");
		sb.append(",SUM(RESPONSESUCTIMES) AS RESPONSESUCTIMES ");
		sb.append(",SUM(RESPONSEERRORTIMES) AS RESPONSEERRORTIMES ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,-9999,SUM(RESPONSESUCTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_NORMAL_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,-9999,SUM(RESPONSESUCTIMES+RESPONSEREDIRECTTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_SUC_RATE ");
		sb.append(",SUM(RESPONSEREDIRECTTIMES) AS RESPONSEREDIRECTTIMES ");
		sb.append(",TRUNC(DECODE(SUM(RESPONSETIMES),0,-9999,SUM(RESPONSEREDIRECTTIMES) / SUM(RESPONSETIMES)), 4)*100 AS REDIRECT_RATE ");
		sb.append("from  ");
		sb.append("(select * from REPORT_FLOW_USERQUOTA t ");
		sb.append("where R_STATTIME >=to_date('"+sTime+"','yyyy-mm-dd hh24:mi:ss')  ");
		sb.append("AND R_STATTIME < to_date('"+eTime+"','yyyy-mm-dd hh24:mi:ss'))q1 ");
		sb.append("JOIN REPORT_FLOW_USERDNS q2 ");
		sb.append("on q1.DEVICE_TYPE=q2.DEVICE_TYPE AND q1.SERVICE_ACCOUNT=q2.SERVICE_ACCOUNT ");
		sb.append("GROUP BY q1.R_STATTIME,q1.DEVICE_TYPE,q1.SERVICE_ACCOUNT ");
		return sb.toString();
	}


	/**
	 * @describe 广州告警推送-用户组指标数据
	 * @author kuangb
	 * @date 2017-11-22
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static String getReadUserGroupQuotafromOracle(String sTime, String eTime) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("q1.R_STATTIME ");
		sb.append(",q1.DEVICE_TYPE ");
		sb.append(",(select ipgroup_name from cfg_direction_ipgroup where ipgroup_id=q1.DEVICE_ID) as usergroup ");
		sb.append(",SUM(TRAFFIC_UP) AS TRAFFIC_UP ");
		sb.append(",SUM(TRAFFIC_DN) AS TRAFFIC_DN ");
		sb.append(",SUM(TRAFFIC_UP+TRAFFIC_DN) AS TRAFFIC_TOTAL ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SHAKEHANDS_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SHAKEHANDS_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(CLIENT_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS CLIENT_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SERVER_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SERVER_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNS_SESSION_SUC_COUNT),0),0,0,SUM(DNS_DELAY) / SUM(DNS_SESSION_SUC_COUNT)), 4) AS DNS_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSANALYSUCTIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSANALY_RATE ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSRESPONSETIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSRESPONSE_RATE ");
		sb.append(",SUM(TCPCONNECT_COUNT) AS TCPCONNECT_COUNT ");
		sb.append(",SUM(TCPSUCCESSCONNECT_COUNT) AS TCPSUCCESSCONNECT_COUNT ");
		sb.append(",TRUNC(DECODE(SUM(TCPCONNECT_COUNT),0,0,SUM(TCPSUCCESSCONNECT_COUNT) / SUM(TCPCONNECT_COUNT)), 4)*100 AS TCPSUCCESSCONNECT_RATE ");
		sb.append(",SUM(TCPUPRECON+TCPDOWNRECON) AS TCPDATARECON ");
		sb.append(",SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS) AS TCPDATAPKGS ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS),0,0,SUM(TCPUPRECON+TCPDOWNRECON) / SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS)), 4)*100 AS TCP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS),0,0,SUM(TCPUPRECON) / SUM(TCPUPDATAPKGS)), 4)*100 AS TCP_UP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPDOWNDATAPKGS),0,0,SUM(TCPDOWNRECON) / SUM(TCPDOWNDATAPKGS)), 4)*100 AS TCP_DN_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(FIRSTHANDSHAKESYN_COUNT),0,0,SUM(SECONDHANDSHAKESYNACK_COUNT) / SUM(FIRSTHANDSHAKESYN_COUNT)), 4)*100 AS TCP_FIRST_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(SECONDHANDSHAKESYNACK_COUNT),0,0,SUM(THIRDHANDSHAKEACK_COUNT) / SUM(SECONDHANDSHAKESYNACK_COUNT)), 4)*100 AS TCP_SECOND_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPREQUEST_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPREQUEST_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPRESP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPRESP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPLOAD_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPLOAD_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(FIRSTBYTE_LOADINGTIME) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS FIRSTBYTE_LOADINGTIME ");
		sb.append(",SUM(HTTPGETTIMES) AS HTTPGETTIMES ");
		sb.append(",SUM(HTTPGETSUCTIMES) AS HTTPGETSUCTIMES ");
		sb.append(",SUM(HTTPPOSTTIMES) AS HTTPPOSTTIMES ");
		sb.append(",SUM(HTTPPOSTSUCTIMES) AS HTTPPOSTSUCTIMES ");
		sb.append(",SUM(RESPONSETIMES) AS RESPONSETIMES ");
		sb.append(",SUM(RESPONSESUCTIMES) AS RESPONSESUCTIMES ");
		sb.append(",SUM(RESPONSEERRORTIMES) AS RESPONSEERRORTIMES ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_NORMAL_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES+RESPONSEREDIRECTTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_SUC_RATE ");
		sb.append(",SUM(RESPONSEREDIRECTTIMES) AS RESPONSEREDIRECTTIMES ");
		sb.append(",TRUNC(DECODE(SUM(RESPONSETIMES),0,0,SUM(RESPONSEREDIRECTTIMES) / SUM(RESPONSETIMES)), 4)*100 AS REDIRECT_RATE ");
		sb.append("from  ");
		sb.append("(select * from REPORT_FLOW_USERGROUPQUOTA t ");
		sb.append("where R_STATTIME >=to_date('"+sTime+"','yyyy-mm-dd hh24:mi:ss')  ");
		sb.append("AND R_STATTIME < to_date('"+eTime+"','yyyy-mm-dd hh24:mi:ss'))q1 ");
		sb.append("JOIN REPORT_FLOW_USERGROUPDNS q2 ");
		sb.append("on q1.DEVICE_TYPE=q2.DEVICE_TYPE AND q1.DEVICE_ID=q2.DEVICE_ID ");
		sb.append("GROUP BY q1.R_STATTIME,q1.DEVICE_TYPE,q1.DEVICE_ID ");
		return sb.toString();
	}

	/**
	 * @describe 广州告警推送-ICPweb指标数据
	 * @author kuangb
	 * @date 2017-11-22
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static String getReadIcpWebQuotafromOracle(String sTime, String eTime) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("q1.R_STATTIME ");
		sb.append(",q1.DEVICE_TYPE ");
		sb.append(",q1.DOMAIN ");
		sb.append(",SUM(TRAFFIC_UP) AS TRAFFIC_UP ");
		sb.append(",SUM(TRAFFIC_DN) AS TRAFFIC_DN ");
		sb.append(",SUM(TRAFFIC_UP+TRAFFIC_DN) AS TRAFFIC_TOTAL ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SHAKEHANDS_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SHAKEHANDS_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(CLIENT_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS CLIENT_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SERVER_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SERVER_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNS_SESSION_SUC_COUNT),0),0,0,SUM(DNS_DELAY) / SUM(DNS_SESSION_SUC_COUNT)), 4) AS DNS_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSANALYSUCTIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSANALY_RATE ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSRESPONSETIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSRESPONSE_RATE ");
		sb.append(",SUM(TCPCONNECT_COUNT) AS TCPCONNECT_COUNT ");
		sb.append(",SUM(TCPSUCCESSCONNECT_COUNT) AS TCPSUCCESSCONNECT_COUNT ");
		sb.append(",TRUNC(DECODE(SUM(TCPCONNECT_COUNT),0,0,SUM(TCPSUCCESSCONNECT_COUNT) / SUM(TCPCONNECT_COUNT)), 4)*100 AS TCPSUCCESSCONNECT_RATE ");
		sb.append(",SUM(TCPUPRECON+TCPDOWNRECON) AS TCPDATARECON ");
		sb.append(",SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS) AS TCPDATAPKGS ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS),0,0,SUM(TCPUPRECON+TCPDOWNRECON) / SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS)), 4)*100 AS TCP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS),0,0,SUM(TCPUPRECON) / SUM(TCPUPDATAPKGS)), 4)*100 AS TCP_UP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPDOWNDATAPKGS),0,0,SUM(TCPDOWNRECON) / SUM(TCPDOWNDATAPKGS)), 4)*100 AS TCP_DN_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(FIRSTHANDSHAKESYN_COUNT),0,0,SUM(SECONDHANDSHAKESYNACK_COUNT) / SUM(FIRSTHANDSHAKESYN_COUNT)), 4)*100 AS TCP_FIRST_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(SECONDHANDSHAKESYNACK_COUNT),0,0,SUM(THIRDHANDSHAKEACK_COUNT) / SUM(SECONDHANDSHAKESYNACK_COUNT)), 4)*100 AS TCP_SECOND_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPREQUEST_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPREQUEST_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPRESP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPRESP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPLOAD_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPLOAD_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(FIRSTBYTE_LOADINGTIME) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS FIRSTBYTE_LOADINGTIME ");
		sb.append(",SUM(HTTPGETTIMES) AS HTTPGETTIMES ");
		sb.append(",SUM(HTTPGETSUCTIMES) AS HTTPGETSUCTIMES ");
		sb.append(",SUM(HTTPPOSTTIMES) AS HTTPPOSTTIMES ");
		sb.append(",SUM(HTTPPOSTSUCTIMES) AS HTTPPOSTSUCTIMES ");
		sb.append(",SUM(RESPONSETIMES) AS RESPONSETIMES ");
		sb.append(",SUM(RESPONSESUCTIMES) AS RESPONSESUCTIMES ");
		sb.append(",SUM(RESPONSEERRORTIMES) AS RESPONSEERRORTIMES ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_NORMAL_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES+RESPONSEREDIRECTTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_SUC_RATE ");
		sb.append(",SUM(RESPONSEREDIRECTTIMES) AS RESPONSEREDIRECTTIMES ");
		sb.append(",TRUNC(DECODE(SUM(RESPONSETIMES),0,0,SUM(RESPONSEREDIRECTTIMES) / SUM(RESPONSETIMES)), 4)*100 AS REDIRECT_RATE ");
		sb.append("from  ");
		sb.append("(select * from REPORT_FLOW_ICPWEBQUOTA t ");
		sb.append("where R_STATTIME >=to_date('"+sTime+"','yyyy-mm-dd hh24:mi:ss')  ");
		sb.append("AND R_STATTIME < to_date('"+eTime+"','yyyy-mm-dd hh24:mi:ss'))q1 ");
		sb.append("JOIN REPORT_FLOW_ICPWEBDNS q2 ");
		sb.append("on q1.DEVICE_TYPE=q2.DEVICE_TYPE AND q1.DOMAIN=q2.DOMAIN ");
		sb.append("GROUP BY q1.R_STATTIME,q1.DEVICE_TYPE,q1.DOMAIN ");
		return sb.toString();
	}

	/**
	 * @describe 广州告警推送-指定应用指标数据
	 * @author kuangb
	 * @date 2017-11-22
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static String getReadAppQuotafromOracle(String sTime, String eTime) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("q1.R_STATTIME ");
		sb.append(",q1.APP_TYPE ");
		sb.append(",(select name from dic_proto_class where classid=q1.app_id and catalogid = q1.app_type) as app_name ");
		sb.append(",SUM(TRAFFIC_UP) AS TRAFFIC_UP ");
		sb.append(",SUM(TRAFFIC_DN) AS TRAFFIC_DN ");
		sb.append(",SUM(TRAFFIC_UP+TRAFFIC_DN) AS TRAFFIC_TOTAL ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SHAKEHANDS_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SHAKEHANDS_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(CLIENT_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS CLIENT_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SERVER_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SERVER_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNS_SESSION_SUC_COUNT),0),0,0,SUM(DNS_DELAY) / SUM(DNS_SESSION_SUC_COUNT)), 4) AS DNS_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSANALYSUCTIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSANALY_RATE ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSRESPONSETIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSRESPONSE_RATE ");
		sb.append(",SUM(TCPCONNECT_COUNT) AS TCPCONNECT_COUNT ");
		sb.append(",SUM(TCPSUCCESSCONNECT_COUNT) AS TCPSUCCESSCONNECT_COUNT ");
		sb.append(",TRUNC(DECODE(SUM(TCPCONNECT_COUNT),0,0,SUM(TCPSUCCESSCONNECT_COUNT) / SUM(TCPCONNECT_COUNT)), 4)*100 AS TCPSUCCESSCONNECT_RATE ");
		sb.append(",SUM(TCPUPRECON+TCPDOWNRECON) AS TCPDATARECON ");
		sb.append(",SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS) AS TCPDATAPKGS ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS),0,0,SUM(TCPUPRECON+TCPDOWNRECON) / SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS)), 4)*100 AS TCP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS),0,0,SUM(TCPUPRECON) / SUM(TCPUPDATAPKGS)), 4)*100 AS TCP_UP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPDOWNDATAPKGS),0,0,SUM(TCPDOWNRECON) / SUM(TCPDOWNDATAPKGS)), 4)*100 AS TCP_DN_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(FIRSTHANDSHAKESYN_COUNT),0,0,SUM(SECONDHANDSHAKESYNACK_COUNT) / SUM(FIRSTHANDSHAKESYN_COUNT)), 4)*100 AS TCP_FIRST_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(SECONDHANDSHAKESYNACK_COUNT),0,0,SUM(THIRDHANDSHAKEACK_COUNT) / SUM(SECONDHANDSHAKESYNACK_COUNT)), 4)*100 AS TCP_SECOND_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPREQUEST_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPREQUEST_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPRESP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPRESP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPLOAD_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPLOAD_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(FIRSTBYTE_LOADINGTIME) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS FIRSTBYTE_LOADINGTIME ");
		sb.append(",SUM(HTTPGETTIMES) AS HTTPGETTIMES ");
		sb.append(",SUM(HTTPGETSUCTIMES) AS HTTPGETSUCTIMES ");
		sb.append(",SUM(HTTPPOSTTIMES) AS HTTPPOSTTIMES ");
		sb.append(",SUM(HTTPPOSTSUCTIMES) AS HTTPPOSTSUCTIMES ");
		sb.append(",SUM(RESPONSETIMES) AS RESPONSETIMES ");
		sb.append(",SUM(RESPONSESUCTIMES) AS RESPONSESUCTIMES ");
		sb.append(",SUM(RESPONSEERRORTIMES) AS RESPONSEERRORTIMES ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_NORMAL_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES+RESPONSEREDIRECTTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_SUC_RATE ");
		sb.append(",SUM(RESPONSEREDIRECTTIMES) AS RESPONSEREDIRECTTIMES ");
		sb.append(",TRUNC(DECODE(SUM(RESPONSETIMES),0,0,SUM(RESPONSEREDIRECTTIMES) / SUM(RESPONSETIMES)), 4)*100 AS REDIRECT_RATE ");
		sb.append("from  ");
		sb.append("(select * from REPORT_FLOW_APPQUOTA t ");
		sb.append("where R_STATTIME >=to_date('"+sTime+"','yyyy-mm-dd hh24:mi:ss')  ");
		sb.append("AND R_STATTIME < to_date('"+eTime+"','yyyy-mm-dd hh24:mi:ss'))q1 ");
		sb.append("JOIN REPORT_FLOW_APPDNS q2 ");
		sb.append("on q1.app_type=q2.app_type AND q1.app_id=q2.app_id ");
		sb.append("GROUP BY q1.R_STATTIME,q1.APP_TYPE,q1.APP_ID ");
		return sb.toString();
	}
	/**
	 * @describe 广州告警推送-指定设备[BRAS&&OLT]指标数据
	 * @author cym
	 * @date 2017-11-23
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static String getReadBrasOltQuotafromOracle(String sTime, String eTime) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("q1.R_STATTIME ");
		sb.append(",DEVICE_TYPE");
		sb.append(",DEVICE_ID");
		sb.append(",SUM(TRAFFIC_UP) AS TRAFFIC_UP ");
		sb.append(",SUM(TRAFFIC_DN) AS TRAFFIC_DN ");
		sb.append(",SUM(TRAFFIC_UP+TRAFFIC_DN) AS TRAFFIC_TOTAL ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SHAKEHANDS_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SHAKEHANDS_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(CLIENT_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS CLIENT_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SERVER_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SERVER_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNS_SESSION_SUC_COUNT),0),0,0,SUM(DNS_DELAY) / SUM(DNS_SESSION_SUC_COUNT)), 4) AS DNS_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSANALYSUCTIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSANALY_RATE ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSRESPONSETIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSRESPONSE_RATE ");
		sb.append(",SUM(TCPCONNECT_COUNT) AS TCPCONNECT_COUNT ");
		sb.append(",SUM(TCPSUCCESSCONNECT_COUNT) AS TCPSUCCESSCONNECT_COUNT ");
		sb.append(",TRUNC(DECODE(SUM(TCPCONNECT_COUNT),0,0,SUM(TCPSUCCESSCONNECT_COUNT) / SUM(TCPCONNECT_COUNT)), 4)*100 AS TCPSUCCESSCONNECT_RATE ");
		sb.append(",SUM(TCPUPRECON+TCPDOWNRECON) AS TCPDATARECON ");
		sb.append(",SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS) AS TCPDATAPKGS ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS),0,0,SUM(TCPUPRECON+TCPDOWNRECON) / SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS)), 4)*100 AS TCP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS),0,0,SUM(TCPUPRECON) / SUM(TCPUPDATAPKGS)), 4)*100 AS TCP_UP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPDOWNDATAPKGS),0,0,SUM(TCPDOWNRECON) / SUM(TCPDOWNDATAPKGS)), 4)*100 AS TCP_DN_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(FIRSTHANDSHAKESYN_COUNT),0,0,SUM(SECONDHANDSHAKESYNACK_COUNT) / SUM(FIRSTHANDSHAKESYN_COUNT)), 4)*100 AS TCP_FIRST_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(SECONDHANDSHAKESYNACK_COUNT),0,0,SUM(THIRDHANDSHAKEACK_COUNT) / SUM(SECONDHANDSHAKESYNACK_COUNT)), 4)*100 AS TCP_SECOND_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPREQUEST_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPREQUEST_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPRESP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPRESP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPLOAD_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPLOAD_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(FIRSTBYTE_LOADINGTIME) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS FIRSTBYTE_LOADINGTIME ");
		sb.append(",SUM(HTTPGETTIMES) AS HTTPGETTIMES ");
		sb.append(",SUM(HTTPGETSUCTIMES) AS HTTPGETSUCTIMES ");
		sb.append(",SUM(HTTPPOSTTIMES) AS HTTPPOSTTIMES ");
		sb.append(",SUM(HTTPPOSTSUCTIMES) AS HTTPPOSTSUCTIMES ");
		sb.append(",SUM(RESPONSETIMES) AS RESPONSETIMES ");
		sb.append(",SUM(RESPONSESUCTIMES) AS RESPONSESUCTIMES ");
		sb.append(",SUM(RESPONSEERRORTIMES) AS RESPONSEERRORTIMES ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_NORMAL_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES+RESPONSEREDIRECTTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_SUC_RATE ");
		sb.append(",SUM(RESPONSEREDIRECTTIMES) AS RESPONSEREDIRECTTIMES ");
		sb.append(",TRUNC(DECODE(SUM(RESPONSETIMES),0,0,SUM(RESPONSEREDIRECTTIMES) / SUM(RESPONSETIMES)), 4)*100 AS REDIRECT_RATE ");

		sb.append(",SUM(ABNORMALOFFLINECOUNT) as ABNORMALOFFLINECOUNT ");
		sb.append(",SUM(USERLOSECONNECTCOUNT) as USERLOSECONNECTCOUNT ");
		sb.append(",SUM(USERACCESSFAILCOUNT) as USERACCESSFAILCOUNT  ");
		sb.append(",SUM(USERACCESSALLCOUNT) as USERACCESSALLCOUNT ");
		sb.append(",SUM(USERONLINECOUNT) as USERONLINECOUNT ");
		sb.append("from  ");
		sb.append("REPORT_FLOW_DEVICEQUOTA q1 ");
		sb.append("where R_STATTIME >=to_date('"+sTime+"','yyyy-mm-dd hh24:mi:ss')  ");
		sb.append("AND R_STATTIME < to_date('"+eTime+"','yyyy-mm-dd hh24:mi:ss') ");
		sb.append("GROUP BY q1.R_STATTIME,q1.DEVICE_TYPE,q1.DEVICE_ID ");
		return sb.toString();
	}
	/**
	 * @describe 广州告警推送-指定设备[Bng&&SR]指标数据
	 * @author cym
	 * @date 2017-11-23
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static String getReadBngSrSwQuotafromOracle(String sTime, String eTime) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("q1.R_STATTIME ");
		sb.append(",DEVICE_TYPE");
		sb.append(",DEVICE_ID");
		sb.append(",SUM(TRAFFIC_UP) AS TRAFFIC_UP ");
		sb.append(",SUM(TRAFFIC_DN) AS TRAFFIC_DN ");
		sb.append(",SUM(TRAFFIC_UP+TRAFFIC_DN) AS TRAFFIC_TOTAL ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SHAKEHANDS_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SHAKEHANDS_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(CLIENT_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS CLIENT_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(TCP_CONNECT_SUC_COUNT),0,0,SUM(SERVER_DELAY) / SUM(TCP_CONNECT_SUC_COUNT)), 4) AS SERVER_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNS_SESSION_SUC_COUNT),0),0,0,SUM(DNS_DELAY) / SUM(DNS_SESSION_SUC_COUNT)), 4) AS DNS_DELAY ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSANALYSUCTIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSANALY_RATE ");
		sb.append(",TRUNC(DECODE(nvl(SUM(DNSANALYTIMES),0),0,0,SUM(DNSRESPONSETIMES) / SUM(DNSANALYTIMES)),4)*100 AS DNSRESPONSE_RATE ");
		sb.append(",SUM(TCPCONNECT_COUNT) AS TCPCONNECT_COUNT ");
		sb.append(",SUM(TCPSUCCESSCONNECT_COUNT) AS TCPSUCCESSCONNECT_COUNT ");
		sb.append(",TRUNC(DECODE(SUM(TCPCONNECT_COUNT),0,0,SUM(TCPSUCCESSCONNECT_COUNT) / SUM(TCPCONNECT_COUNT)), 4)*100 AS TCPSUCCESSCONNECT_RATE ");
		sb.append(",SUM(TCPUPRECON+TCPDOWNRECON) AS TCPDATARECON ");
		sb.append(",SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS) AS TCPDATAPKGS ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS),0,0,SUM(TCPUPRECON+TCPDOWNRECON) / SUM(TCPUPDATAPKGS+TCPDOWNDATAPKGS)), 4)*100 AS TCP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPUPDATAPKGS),0,0,SUM(TCPUPRECON) / SUM(TCPUPDATAPKGS)), 4)*100 AS TCP_UP_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(TCPDOWNDATAPKGS),0,0,SUM(TCPDOWNRECON) / SUM(TCPDOWNDATAPKGS)), 4)*100 AS TCP_DN_RETRANSMIT_RATE ");
		sb.append(",TRUNC(DECODE(SUM(FIRSTHANDSHAKESYN_COUNT),0,0,SUM(SECONDHANDSHAKESYNACK_COUNT) / SUM(FIRSTHANDSHAKESYN_COUNT)), 4)*100 AS TCP_FIRST_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(SECONDHANDSHAKESYNACK_COUNT),0,0,SUM(THIRDHANDSHAKEACK_COUNT) / SUM(SECONDHANDSHAKESYNACK_COUNT)), 4)*100 AS TCP_SECOND_HANDSHAKE_SUC_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPREQUEST_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPREQUEST_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPRESP_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPRESP_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(HTTPLOAD_DELAY) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS HTTPLOAD_DELAY ");
		sb.append(",TRUNC(DECODE(SUM(HTTP_SESSION_SUC_COUNT),0,0,SUM(FIRSTBYTE_LOADINGTIME) / SUM(HTTP_SESSION_SUC_COUNT)), 4) AS FIRSTBYTE_LOADINGTIME ");
		sb.append(",SUM(HTTPGETTIMES) AS HTTPGETTIMES ");
		sb.append(",SUM(HTTPGETSUCTIMES) AS HTTPGETSUCTIMES ");
		sb.append(",SUM(HTTPPOSTTIMES) AS HTTPPOSTTIMES ");
		sb.append(",SUM(HTTPPOSTSUCTIMES) AS HTTPPOSTSUCTIMES ");
		sb.append(",SUM(RESPONSETIMES) AS RESPONSETIMES ");
		sb.append(",SUM(RESPONSESUCTIMES) AS RESPONSESUCTIMES ");
		sb.append(",SUM(RESPONSEERRORTIMES) AS RESPONSEERRORTIMES ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_NORMAL_RATE ");
		sb.append(",TRUNC(DECODE(SUM(HTTPREQCOUNT),0,0,SUM(RESPONSESUCTIMES+RESPONSEREDIRECTTIMES) / SUM(HTTPREQCOUNT)), 4)*100 AS HTTP_RESP_SUC_RATE ");
		sb.append(",SUM(RESPONSEREDIRECTTIMES) AS RESPONSEREDIRECTTIMES ");
		sb.append(",TRUNC(DECODE(SUM(RESPONSETIMES),0,0,SUM(RESPONSEREDIRECTTIMES) / SUM(RESPONSETIMES)), 4)*100 AS REDIRECT_RATE ");

		sb.append(",SUM(ABNORMALOFFLINECOUNT) as ABNORMALOFFLINECOUNT ");
		sb.append(",SUM(USERLOSECONNECTCOUNT) as USERLOSECONNECTCOUNT ");
		sb.append(",SUM(USERACCESSFAILCOUNT) as USERACCESSFAILCOUNT  ");
		sb.append(",SUM(USERACCESSALLCOUNT) as USERACCESSALLCOUNT ");
		sb.append(",SUM(USERONLINECOUNT) as USERONLINECOUNT ");
		sb.append(" from REPORT_FLOW_BNGQUOTA q1 ");
		sb.append("where R_STATTIME >=to_date('"+sTime+"','yyyy-mm-dd hh24:mi:ss')  ");
		sb.append("AND R_STATTIME < to_date('"+eTime+"','yyyy-mm-dd hh24:mi:ss') ");
		sb.append("GROUP BY q1.R_STATTIME,q1.DEVICE_TYPE,q1.DEVICE_ID ");
		return sb.toString();
	}
	public static void main(String[] args) {
	 //   System.out.println(SqlUtils_ReadOracle.getReadUserGroupQuotafromOracle("2017-08-24 16:00", "2017-08-24 16:05"));

		String sTime="2017-08-24 16:00";
		String eTime="2017-08-24 16:05";
		String sql=SqlUtils_ReadOracle.getReadBngSrSwQuotafromOracle(sTime, eTime);
	    System.out.println(sql);
	}
}