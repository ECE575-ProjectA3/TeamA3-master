# dep: openjdk-7-jre
#      maven

SHELL = /bin/sh

.PHONY : ALL, clean, install, dataServer, mobileDisplay, mobileCollector

ALL : dataServer mobileCarrier mobileCollector

# compile and package dataServer
dataServer : dataServer/target/dataServer-*.jar
dataServer/target/dataServer-*.jar : dataServer/src/main/java/updatePackage/*.java
	cd dataServer && mvn package
dataServer/target/classes/updatePackage/%.class : dataServer/src/main/java/updatePackage/*.java
	cd dataServer && mvn compile

# compile and package mobileDisplay
mobileDisplay : 
	#add build commands here

# compile and package mobileCollector
mobileCollector : 
	#add build commands here

# should we include this?
install : 
	#does nothing (for now)

# clean binaries from system
clean : 
	rm -rf ../bin/dataServer/*
	rm -rf ../bin/mobileDisplay/*
	rm -rf ../bin/mobileCollector/*

