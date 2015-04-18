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
    (put stuff here!!!)

(items marked with * are external resources not created by this team, and are property of their respective maintainers)
