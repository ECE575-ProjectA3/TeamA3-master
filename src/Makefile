# dep: openjdk-7-jre
#      maven

SHELL = /bin/sh

.PHONY : ALL, clean, clean-dataServer, clean-mobileDisplay, 
	clean-mobileCollector, dataServer, mobileDisplay, mobileCollector

ALL : dataServer 

# compile and package dataServer
dataServer : dataServer/target/dataServer-*.jar clean-dataServer
dataServer/target/dataServer-*.jar : dataServer/src/main/java/updatePackage/*.java
	cd dataServer && mvn package
	cp dataServer/target/dataServer-0.1.0.jar ../bin/
	
# compile and package mobileDisplay
mobileDisplay : 
	#add build commands here

# compile and package mobileCollector
mobileCollector : 
	#add build commands here

# clean binaries from system
clean : clean-dataServer
	rm -vrf ../bin/dataServer-0.1.0.jar
	#rm -vrf ../bin/mobileDisplayApp.apk
	#rm -vrf ../bin/mobileCollectorApp.apk

clean-dataServer : 
	rm -vrf dataServer/target
clean-mobileDisplay : 
	#clean build output from src directory
clean-mobileCollector : 
	#clean build output from src directory
