#/bin/bash

bin=`which $0`
echo "0:$0"
echo "bin:$bin"
bin=`dirname $bin`
WORKPATH=`cd ../$bin;pwd`

echo "bin:$bin"
echo "WORKPATH:$WORKPATH"

EXPIRE_HOURS=`awk -F'=' '/EXPIRE_HOURS/{print $2}' ${WORKPATH}/config/config.properties`
FILE_PATH=`awk -F'=' '/config.data.path/{print $2}' ${WORKPATH}/config/config.properties`
echo "EXPIRE_HOURS:$EXPIRE_HOURS"
echo "FILE_PATH:$FILE_PATH"
CURRENT_TIMESTAMP=`date +%s`
EXPIRE_SECONDS=`expr $EXPIRE_HOURS \* 3600`
EXPIRE_TIMESTAMP=`expr $CURRENT_TIMESTAMP - $EXPIRE_SECONDS`
EXPIRE_yyyyMMddHHmm=`date -d @$EXPIRE_TIMESTAMP "+%Y%m%d%H%M"`

##---------------------------------------------------------
if [ $# -eq 1 ];then
EXPIRE_yyyyMMddHHmm=$1
fi
##---------------------------------------------------------

echo "get args:$EXPIRE_yyyyMMddHHmm"

DELETE_FILE=$FILE_PATH/*${EXPIRE_yyyyMMddHHmm}*
echo "prepare to delete file "$DELETE_FILE
rm -rf $DELETE_FILE
