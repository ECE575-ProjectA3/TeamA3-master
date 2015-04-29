# dep: openjdk-7-jre
#      gradle
#      Android Studio SDK

SHELL = /bin/sh

ANDROID_SDK_DIR = ${HOME}/Android/Sdk

.PHONY : ALL install clean dataServer mobileDisplay mobileCollector \
	install-dataServer install-mobileDisplay install-mobileCollector \
	clean-dataServer clean-mobileDisplay clean-mobileCollector

ALL : dataServer mobileDisplay mobileCollector

# compile and package dataServer
dataServer : dataServer/build/libs/dataServer-*.jar
dataServer/build/libs/dataServer-*.jar : dataServer/src/main/java/updatePackage/*.java
	cd dataServer && ./gradlew jar

# compile and package mobileDisplay
mobileDisplay : mobileDisplay/app/build/outputs/apk/app-release.apk
mobileDisplay/app/build/outputs/apk/app-release.apk : 
	${ANDROID_HOME} || export ANDROID_HOME = ANDROID_SDK_DIR
	cd mobileDisplay && ./gradlew assemble

# compile and package mobileCollector
mobileCollector : mobileCollector/app/build/outputs/apk/app-release-unsigned.apk
mobileCollector/app/build/outputs/apk/app-release-unsigned.apk : 
	${ANDROID_HOME} || export ANDROID_HOME = ANDROID_SDK_DIR
	cd mobileCollector && ./gradlew assemble

# install packages into bin directory
install : install-dataServer \
		  install-mobileDisplay \
		  install-mobileCollector
install-dataServer : ../bin/dataServer.jar
../bin/dataServer.jar : dataServer
	cp dataServer/build/libs/dataServer-0.1.0.jar ../bin/dataServer.jar
install-mobileDisplay : ../bin/mobileDisplayApp.apk
../bin/mobileDisplayApp.apk : mobileDisplay
	cp mobileDisplay/app/build/outputs/apk/app-release.apk \
		../bin/mobileDisplayApp.apk
install-mobileCollector : ../bin/mobileCollectorApp.apk
../bin/mobileCollectorApp.apk : mobileCollector
	cp mobileCollector/app/build/outputs/apk/app-release-unsigned.apk \
		../bin/mobileCollectorApp.apk

# clean build artifacts from src directory
clean : clean-dataServer \
	    clean-mobileDisplay \
	    clean-mobileCollector
clean-dataServer : 
	rm -vrf dataServer/build
clean-mobileDisplay : 
	rm -vrf mobileDisplay/build mobileDisplay/app/build
clean-mobileCollector : 
	rm -vrf mobileCollector/build mobileCollector/app/build
