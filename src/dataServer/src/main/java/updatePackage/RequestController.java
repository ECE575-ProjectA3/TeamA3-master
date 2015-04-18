package updatePackage;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
	//default values for date/time filtering (should match everything)
	public static final String DEFAULT_MIN_DATE = "0001-01-01";
	public static final String DEFAULT_MAX_DATE = "9999-12-31";
	public static final String DEFAULT_MIN_TIME = "0";
	public static final String DEFAULT_MAX_TIME = "24";
	
	@Autowired 
	private StoreData mStorage;
	
	@RequestMapping(value = "/request", method=RequestMethod.GET)
	public VisualParams[] request(@RequestParam(value="carrier", required=true) String carrierName,
			@RequestParam(value="type", required=false, defaultValue=StoreData.SIGNALSTRENGTH) String dataType,
			@RequestParam(value="minDate", required=false, defaultValue=DEFAULT_MIN_DATE) String minDate,
			@RequestParam(value="maxDate", required=false, defaultValue=DEFAULT_MAX_DATE) String maxDate,
			@RequestParam(value="minTime", required=false, defaultValue=DEFAULT_MIN_TIME) String minTime,
			@RequestParam(value="maxTime", required=false, defaultValue=DEFAULT_MAX_TIME) String maxTime) {
		
		List<VisualParams> result = new ArrayList<VisualParams>();	//initialize results list
		
		//query database with given parameters and fetch matching results
		result = mStorage.getData(carrierName, dataType, minDate, maxDate, minTime, maxTime);
		
		return result.toArray(new VisualParams[result.size()]);		//return results list
	}
}
