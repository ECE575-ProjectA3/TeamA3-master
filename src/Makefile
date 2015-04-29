# dep: openjdk-7-jre
#      maven

SHELL = /bin/sh

.PHONY : ALL install clean dataServer mobileDisplay mobileCollector \
	install-dataServer install-mobileDisplay install-mobileCollector \
	clean-dataServer clean-mobileDisplay clean-mobileCollector

ALL : dataServer mobileDisplay mobileCollector

# compile and package dataServer
dataServer : dataServer/target/dataServer-*.jar
dataServer/target/dataServer-*.jar : dataServer/src/main/java/updatePackage/*.java
	cd dataServer && mvn package

# compile and package mobileDisplay
mobileDisplay : 
	##
	#add build commands here
	##

# compile and package mobileCollector
mobileCollector : 
	##
	#add build commands here
	##

# install packages into bin directory
install : install-dataServer \
		  install-mobileDisplay \
		  install-mobileCollector
install-dataServer : dataServer
	cp dataServer/target/dataServer-0.1.0.jar ../bin/
install-mobileDisplay : mobileDisplay
	##
	#copy apk from build output into ../bin
	##
install-mobileCollector : mobileCollector
	##
	#copy apk from build output into ../bin
	##

# clean build artifacts from src
clean : clean-dataServer \
	    clean-mobileDisplay \
	    clean-mobileCollector
clean-dataServer : 
	rm -vrf dataServer/target
clean-mobileDisplay : 
	##
	#clean build output from src directory
	##
clean-mobileCollector : 
	##
	#clean build output from src directory
	##
