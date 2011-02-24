#!/bin/bash

LOG=/home/ubuntu/install.log

if [ "root" != `whoami` ]; then
  sudo -E $0 >> $LOG 2>&1
  echo "Ran the script as root and now I'm back to `whoami`" >> $LOG 2>&1
  echo "" >> $LOG 2>&1
  echo "" >> $LOG 2>&1
  echo "" >> $LOG 2>&1
  exit 0;
else
  echo "I am `whoami` so I can run the good stuff" >> $LOG 2>&1
fi

echo "" 
echo "********** Running apt-get update **********" 
apt-get update 

echo "" 
echo "********** Installing Java JDK & JRE **********" 
#setup so that the jdk install will not prompt
apt-get -y install openjdk-6-jdk

echo "********** Installing tomcat **********" 
apt-get -y install tomcat6 tomcat6-common
