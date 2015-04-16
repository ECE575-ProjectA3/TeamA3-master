package updatePackage;

public class CoverageParams {
    private double latitude;
    private double longitude;
    private String carrierName;    
    private String dateTime;
    
    private int    signalStrength;
    private double downloadSpeed;
    private double uploadSpeed;
    private int    wifiSignalStrength;
    private double wifiDownloadSpeed;
    private double wifiUploadSpeed;
    
    CoverageParams(double latitude, double longitude, String carrierName, String dateTime, 
    		int signalStrength, double downloadSpeed, double uploadSpeed, 
    		int wifiSignalStrength, double wifiDownloadSpeed, double wifiUploadSpeed) {
    	
    	setLatitude(latitude);
    	setLongitude(longitude);
    	setCarrierName(carrierName);
    	setDateTime(dateTime);
    	
    	setSignalStrength(signalStrength);
    	setDownloadSpeed(downloadSpeed);
    	setUploadSpeed(uploadSpeed);
    	
    	setWifiSignalStrength(wifiSignalStrength);
    	setWifiDownloadSpeed(wifiDownloadSpeed);
    	setWifiUploadSpeed(wifiUploadSpeed);
    }
    CoverageParams(double latitude, double longitude, String carrierName, String dateTime, 
    		int signalStrength, double downloadSpeed, double uploadSpeed) {
    	
    	setLatitude(latitude);
    	setLongitude(longitude);
    	setCarrierName(carrierName);
    	setDateTime(dateTime);
    	
    	setSignalStrength(signalStrength);
    	setDownloadSpeed(downloadSpeed);
    	setUploadSpeed(uploadSpeed);
    }
    CoverageParams(double latitude, double longitude, String carrierName, String dateTime) {
    	setLatitude(latitude);
    	setLongitude(longitude);
    	setCarrierName(carrierName);
    	setDateTime(dateTime);
    }
    CoverageParams() {}
    
    public void setLatitude(double latitude) {
    	this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
    	this.longitude = longitude;
    }
    public void setCarrierName(String carrierName) {
    	this.carrierName = carrierName;
    }
    public void setDateTime(String dateTime) {
    	this.dateTime = dateTime;
    }
    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }
    public void setDownloadSpeed(double downloadSpeed) {
    	this.downloadSpeed = downloadSpeed;
    }
    public void setUploadSpeed(double uploadSpeed) {
    	this.uploadSpeed = uploadSpeed;
    }
    public void setWifiSignalStrength(Integer wifiSignalStrength) {
    	this.wifiSignalStrength = wifiSignalStrength;
    }
    public void setWifiDownloadSpeed(Double wifiDownloadSpeed) {
    	this.wifiDownloadSpeed = wifiDownloadSpeed;
    }
    public void setWifiUploadSpeed(Double wifiUploadSpeed) {
    	this.wifiUploadSpeed = wifiUploadSpeed;
    }

    public double getLongitude() {
        return this.longitude;
    }
    public double getLatitude() {
        return this.latitude;
    }
    public String getCarrierName() {
    	return this.carrierName;
    }
    public String getDateTime() {
    	return this.dateTime;
    }
    public int getSignalStrength() {
        return this.signalStrength;
    }
    public Double getDownloadSpeed() {
    	return this.downloadSpeed;
    }
    public Double getUploadSpeed() {
    	return this.uploadSpeed;
    }
    public Integer getWifiSignalStrength() {
    	return wifiSignalStrength;
    }
    public Double getWifiDownloadSpeed() {
    	return wifiDownloadSpeed;
    }
    public Double getWifiUploadSpeed() {
    	return wifiUploadSpeed;
    }
}
