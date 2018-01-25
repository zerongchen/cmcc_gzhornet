#!/bin/bash
#
#Project  guangzhou  moblie
#Version
#Description:
#ORACLE_TABLE: REPORT_FLOW_USERQUOTA,REPORT_FLOW_USERDNS

bin=`which $0`
bin=`dirname ${bin}`
bin=`cd "$bin"; pwd`
WORKPATH=`cd $bin/..;pwd`
if [ $# -ne 1  -a  $# -ne 3 ]
then
    echo `date +"%Y-%m-%d %H:%M:%S"`  "Usage:[CITYCODE][START_TIME][END_TIME]"
    exit 1
fi

AHEADOFTIME=`awk -F'=' '/config.aheadOfTime/{print $2}' ${WORKPATH}/config/config.properties`
TIMEINTERVAL=`awk -F'=' '/config.timeInterval/{print $2}' ${WORKPATH}/config/config.properties`

START_AHEAD=`expr $AHEADOFTIME + $TIMEINTERVAL`
START_AHEAD_SECONDS=`expr $START_AHEAD \* 60`
END_AHEAD_SECONDS=`expr $AHEADOFTIME \* 60`

echo `date +"%Y-%m-%d %H:%M:%S"`  "------------------------------------"
echo `date +"%Y-%m-%d %H:%M:%S"`  "-doguang mobile ${GUANGZHOU_ICPWEBQUOTA_PUSH}"
echo `date +"%Y-%m-%d %H:%M:%S"`  "Shell Version 1.0 update(2017-11-21)"
echo `date +"%Y-%m-%d %H:%M:%S"`  "------------------------------------"

#--------------------------------------------------
echo "get config.aheadOfTime: ${AHEADOFTIME},config.timeInterval:${TIMEINTERVAL}"

CURRENT_TIME=`date +%s`

START_TIMESTAMP=`expr $CURRENT_TIME - $START_AHEAD_SECONDS`
END_TIMESTAMP=`expr $CURRENT_TIME - $END_AHEAD_SECONDS`


START_TIME=$(date -d @"$START_TIMESTAMP" "+%Y%m%d%H%M")
END_TIME=$(date -d @"$END_TIMESTAMP" "+%Y%m%d%H%M" )

if [ $# -eq 3 ]
then
	START_TIME=$2     #specified START_TIME
	END_TIME=$3       #specified END_TIME
fi
echo  "$1,$2,$3"

echo "get STRAT_TIME: ${START_TIME}, get END_TIME:${END_TIME}"
#--------------------------------------------------

CLASS_PATH=" -classpath "$(echo $WORKPATH/lib/*.jar|sed 's/ /:/g')
MAIN_CLASS=com.push.data.main.IcpwebQuotaMain

java ${CLASS_PATH} ${MAIN_CLASS} ${START_TIME} ${END_TIME}

