package updatePackage;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreData {
	
	//MySQL database field names
	public static final String LATITUDE				= "latitude";
	public static final String LONGITUDE			= "longitude";
	public static final String DATETIME				= "dateTime";
	public static final String SIGNALSTRENGTH		= "signalStrength";
	public static final String DOWNLOADSPEED		= "downloadSpeed";
	public static final String UPLOADSPEED			= "uploadSpeed";
	
	private static final String URL = 
			"jdbc:mysql://localhost:3306/ece575";
    private static final String USER = "mysql";
    private static final String PASSWORD = "ece575";
    
    private static double[] testLatitude = 
    	   {35.770820237954545,	35.770402398496785,	35.77799280632021,
    		35.78084772632129,	35.78565211633479,	35.781961813633245,
    		35.77792317284434,	35.7794550952256,	35.78154403272092,
    		35.80437950161731,	35.79129168191281};
	
	private static double[] testLongitude = 
		   {-78.67554187774658,	-78.67991924285889,	-78.6754560470581,
			-78.66953372955322,	-78.66635799407959,	-78.66146564483643,
			-78.67056369781494,	-78.68086338043213,	-78.70824337005615,
			-78.72395038604736,	-78.73201847076416};
	
	private int[] testSignalStrength = {3,2,1,0,3,2,1,0,3,2,1};
	
	private String[] testDateTime = 
		   {"01/01/2014 03:35","02/02/2014 13:52","03/03/2014 21:21",
			"04/04/2014 23:59","05/05/2014 00:01","06/06/2014 14:59",
			"07/07/2014 07:23","08/08/2014 04:42","09/09/2014 17:24",
			"10/10/2014 22:08","11/11/2014 19:39"};
    
	StoreData() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	System.out.println("Where is your MySQL JDBC Driver?");
        	e.printStackTrace();
        }
		System.out.println("Loaded JDBC driver");
	}
	
	private String getDatabaseCarrierName(String carrierName) {
		//strip special characters from carrierName
	    String dbCarrierName = carrierName;
	    if (carrierName.equals("T-Mobile")==true) {
	    	dbCarrierName = "TMobile";
	    }
	    if (carrierName.equals("US Cellular")==true) {
	    	dbCarrierName = "USCellular";
	    }
	    if (carrierName.equals("AT&T")==true) {
	    	dbCarrierName = "ATT";
	    }	    
	    return dbCarrierName;
	}
	
	/*
	 * Store data in the corresponding table
	 */
	public void storeSensorData(CoverageParams input) {
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		    Statement statement = connection.createStatement();
		    
		    String carrierName = getDatabaseCarrierName(input.getCarrierName());
			
		    //populate SQL insert statement from given data
			String insert = "INSERT INTO "+ carrierName
					+ " ("+LATITUDE+","+LONGITUDE+","+SIGNALSTRENGTH+","
					+ DOWNLOADSPEED+","+UPLOADSPEED+","+DATETIME+") VALUES ("
					+ input.getLatitude() +","+ input.getLongitude() +","+ input.getSignalStrength() +","
					+ input.getDownloadSpeed() +","+ input.getUploadSpeed() +",'"+ input.getDateTime() +"')";
			
			System.out.println(insert);
		    statement.execute(insert);	//execute data insertion operation
		    
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
			System.out.println("Unable to perform insert operation (cellular)");
		}
		
		//separate insert operation for WiFi
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		    Statement statement = connection.createStatement();
			
		    //populate SQL insert statement from given data
			String insert = "INSERT INTO WiFi"
					+ " ("+LATITUDE+","+LONGITUDE+","+SIGNALSTRENGTH+","
					+ DOWNLOADSPEED+","+UPLOADSPEED+","+DATETIME+") VALUES ("
					+ input.getLatitude() +","+ input.getLongitude() +","+ input.getWifiSignalStrength() +","
					+ input.getWifiDownloadSpeed() +","+ input.getWifiUploadSpeed() +",'"+ input.getDateTime() +"')";
			
			System.out.println(insert);
		    statement.execute(insert);	//execute data insertion operation
		    
		    statement.close();
		    connection.close();
		} catch (SQLException e) {
			System.out.println("Unable to perform insert operation (wifi)");
		}
	}	
	
	/*
	 * Fetch filtered data from the specified table
	 */
	public ArrayList<VisualParams> getData(String carrierName, String dataType, 
			String minDate, String maxDate, String minTime, String maxTime) {
		
		ArrayList<VisualParams> output = new ArrayList<VisualParams>(); 
		
		//bypass SQL query and output hard-coded test values
		//note: does not respect filtering
		if(carrierName.matches("testRequest")) {
			for(int i=0; i < testSignalStrength.length; i++) {
				output.add(new VisualParams(testLatitude[i],testLongitude[i],testSignalStrength[i],"signalStrength",testDateTime[i]));
			}
			System.out.println("Returned test values");
		} else
		
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		    Statement statement = connection.createStatement();
		    
			carrierName = getDatabaseCarrierName(carrierName);
		    
		    //populate SQL query filtered by date and time range
		    String query = "SELECT * FROM "+ carrierName
		    		+ " WHERE DATE("+DATETIME+") >= "+ "DATE('" + minDate + "')" 
		    		+" AND DATE("+DATETIME+") <= DATE('"+ maxDate + "')" 
		    		+ " AND HOUR("+DATETIME+") >= "+ minTime
		    		+ " AND HOUR("+DATETIME+") < "+ maxTime;
		    
		    System.out.println(query);
		    ResultSet result = statement.executeQuery(query);	//execute data query
		    
		    //iterate through result set
		    while (result.next()) {
		    	Number dataValue;
		    	if(dataType.equals(SIGNALSTRENGTH)) {
		    		dataValue = result.getInt(dataType);
		    	} else {
		    		dataValue = result.getDouble(dataType);
		    	}
		    	//add results as a new VisualParams object
		    	output.add(new VisualParams(result.getDouble(LATITUDE),result.getDouble(LONGITUDE),
		    			dataValue, dataType, result.getString(DATETIME)));
		    }
		} catch (SQLException e) {
			System.out.println("Unable to perform query operation");
			e.printStackTrace();
		}
		return output;
	}
}
