dataServer/                         central data server
    build.gradle                        gradle build files
    gradle/wrapper/*                              
    gradlew                             
    gradlew.bat                         
    pom.xml                             maven build configuration
    target                              symbolic link to bin/dataServer
    src/main/java/updatePackage/        source package for the server
        Application.java                    main server launch thread
        EnableCORS.java                     enable CORS headers
        StoreData.java                      SQL database handler
        VisualParams.java                   output object
        CoverageParams.java                 input object
        RequestController.java              data output request handler
        UpdateController.java               data input handler

webDisplay/                         web visualization scripts
  * gmaps.js                            google maps api extension
  * jquery-1.11.2.min.js                jQuery javascript library
    mapDisplay.js                       javascript function definitions
    mapDisplay.html                     map display page with filters

mobileDisplay/                      Android data visualization app
    (put stuff here!!!)

mobileCollector/                    Android data collection app
    build.gradle			gradle build files
    gradle/wrapper/*
    gradlew
    gradlew.bat
    mobileCollector.iml			configuration record for module
    app/src/androidTest/java/com/example/wirelessproj/locationcoverage/ApplicationTest.java	test file	
    app/src/main/
        AndroidManifest.xml		essential information about app
        res/*			 	specifies layout of app screens
        java/com/example/wirelessproj/locationcoverage	
            CoverageInfo.java			checks for changes in signal strength
	    LocationInfo.java			checks for changes in location
	    LocationListenerTask.java		assigns new location when changed
	    MainActivity.java			main handler thread
	    PhoneStateListener.java		assigns new signal strength when changed
	    StageChangeHandler.java		posts data to server
	    StateChangeMsg.java			triggers message when attribute changes

(items marked with * are external resources not created by this team, and are property of their respective maintainers)
