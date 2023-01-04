package Utils;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataPayload {

	public AddPlace addDataPayload(String name,String language,String address) {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName(name);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		List<String> list1 = new ArrayList<String>();
		list1.add("shoe park");
		list1.add("shop");
		p.setTypes(list1);
		return p;
	}
	
	public String deletePlayload(String place_id) {
		return "{\r\n"
				+ "  \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
	}
}
