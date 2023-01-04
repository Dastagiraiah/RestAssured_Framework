package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqSepcBulider {
	public static RequestSpecification reqSpc;
	public RequestSpecification requestSpec() throws IOException {
		
		if(reqSpc==null) {
		PrintStream strem = new PrintStream(new FileOutputStream("Logs.txt"));
		 reqSpc =  new RequestSpecBuilder().setBaseUri(getprop("baseuri")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(strem))
				 .addFilter(ResponseLoggingFilter.logResponseTo(strem))
				 .setContentType(ContentType.JSON).build();
		 return reqSpc;
		}
		return reqSpc;
		
	}
	
	public static String getprop(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/java/Utils/Global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	public String getJson(Response response, String key) {
		
		JsonPath js = new JsonPath(response.asString());
		return js.get(key);
		
	}
}
