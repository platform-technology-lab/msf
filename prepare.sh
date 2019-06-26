# Workspace dir
workspace=/home/imich/git-workspace
#workspace=

if [${workspace} == ""]; then
       echo "Please input your workspace directory in prepare.sh"
       echo "exit."
   exit
fi

echo "workspace: "${workspace}

gityes=`git --version`
if [[ $gityes =~ "git version" ]]; then
       echo ${gityes}
   else
       echo "You shoud install git"
       echo " - sudo apt install git" 
       echo "exit."
       exit
fi   

mkdir ${workspace}/config-repository
cp ${workspace}/msf/setting/config_file/* ${workspace}/config-repository

echo "copy properties files to "${workspace}"/config-repository" 

cd ${workspace}/config-repository
git init
cd ${workspace}/msf

CONFIG_BOOT_FILE=${workspace}"/msf/config/src/main/resources/bootstrap.properties"
if [ -e $CONFIG_BOOT_FILE ]; then
   echo "config bootstrap.properties file exists."
   mv ${CONFIG_BOOT_FILE} ${CONFIG_BOOT_FILE}.org
else
   echo "generate configuration file"
fi

echo "server.port=8888" > ${CONFIG_BOOT_FILE}
echo "spring.cloud.config.server.git.uri="${workspace}/config-repository >> ${CONFIG_BOOT_FILE}
echo "# You can use remot git server -" >> ${CONFIG_BOOT_FILE}
echo "# spring.cloud.config.server.git.uri=https://github.com/cholhongim/config-repository.git" >> ${CONFIG_BOOT_FILE}
echo "management.security.enabled=false" >> ${CONFIG_BOOT_FILE}
