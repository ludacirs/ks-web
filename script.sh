#!/bin/bash

path=/home/j131/backup/
todayYMD=$(date "+%Y%m%d")
todayHM=$(date "+%H%M")

if [ ! -d $path/$todayYMD ]; then
	mkdir $path/$todayYMD
fi

syslogPath=/var/log/syslog
dmesgPath=/var/log/dmesg

zipName=log_$todayYMD-$todayHM.zip

zip $zipName $syslogPath $dmesgPath

mv $zipName $path/$todayYMD
