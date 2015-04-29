dataServer/                         central data server
    build.gradle                        gradle build configuration
    gradle/wrapper/                         ..
        gradle-wrapper.jar                  ..
        gradle-wrapper.properties           ..
    gradlew                                 ..
    gradlew.bat                             ..
    pom.xml                             maven build configuration
    src/main/java/updatePackage/        source package for the server
        Application.java                    main server launch thread
        EnableCORS.java                     enable CORS headers
        StoreData.java                      SQL database handler
        VisualParams.java                   output object
        CoverageParams.java                 input object
        RequestController.java              data request handler
        UpdateController.java               data input handler

webDisplay/                         web visualization scripts
  * gmaps.js                            google maps api extension
  * jquery-1.11.2.min.js                jQuery javascript library
    mapDisplay.html                     map display page with filters
    mapDisplay.js                       javascript function definitions    

mobileDisplay/                      Android data visualization app
    build.gradle                        gradle build configuration
	gradle/wrapper/                         ..
	    gradle-wrapper.jar                  ..
	    gradle-wrapper.properties           ..
	gradle.properties                       ..
    gradlew                                 ..
    gradlew.bat                             ..
    settings.gradle                         ..
	CellularCoverage.iml
	android.jks
    app/
        app.iml
        build.gradle proguard-rules.pro
        src/
		    androidTest/java/com/androidTest/
		       java/com/ncsu/
		            wireless/cellularcoverage/
		                ApplicationTest.java
            main/
                AndroidManifest.xml
                java/com/ncsu/
                    wireless/cellularcoverage/
                        CarrierList.java
                        DateForm.java
                        MainActivity2Activity.java
                        MapDisplay.java
                        SignalParameter.java
                res/
                    layout/
                        activity_carrier_list.xml
                        activity_date_form.xml
                        activity_main_activity2.xml
                        activity_map_display.xml
                        activity_signal_parameter.xml
                    menu/
                        menu_carrier_list.xml
                        menu_date_form.xml
                        menu_main_activity2.xml
                        menu_main.xml
                        menu_map_display.xml
                        menu_signal_parameter.xml
                    mipmap-hdpi/ic_launcher.png
                    mipmap-mdpi/ic_launcher.png
                    mipmap-xhdpi/ic_launcher.png
                    mipmap-xxhdpi/ic_launcher.png
                    values/
                        dimens.xml
                        google_maps_api.xml
                        strings.xml
                        styles.xml
                    values-w820dp/dimens.xml

mobileCollector/                    Android data collection app
    build.gradle                        gradle build configuration
	gradle/wrapper/                         ..
	    gradle-wrapper.jar                  ..
	    gradle-wrapper.properties           ..
	gradle.properties                       ..
    gradlew                                 ..
    gradlew.bat                             ..
    settings.gradle                         ..
    LocationCoverage.iml		configuration record
    mobileCollector.iml				..
    app/
        app.iml
        build.gradle
        proguard-rules.pro
        src/
            androidTest/java/com/example/
                wirelessproj/locationcoverage/
                    ApplicationTest.java	test file
            main/
                AndroidManifest.xml		app Information
                java/com/example/
                    wirelessproj/locationcoverage/	source package
                        CoverageInfo.java		checks for change in signal strength
                        LocationInfo.java		checks for change in location
                        LocationListenerTask.java	sets new location parameters
                        MainActivity.java		main handler thread
                        PhoneStateListenerTask.java	sets new signal strength parameters
                        StateChangeHandler.java		updates data to server
                        StateChangeMsg.java		triggers state change message
                res/
                    layout/activity_main.xml		defines layout of app
                    menu/menu_main.xml			menu page layout
                    mipmap-hdpi/ic_launcher.png		image used in app
                    mipmap-mdpi/ic_launcher.png			..
                    mipmap-xhdpi/ic_launcher.png		..
                    mipmap-xxhdpi/ic_launcher.png		..
                    values/					
                        dimens.xml			dimension values
                        strings.xml			string values
                        styles.xml			style values
                    values-v21/styles.xml
                    values-w820dp/dimens.xml

(items marked with * are external resources not created by this team, and are property of their respective maintainers)
