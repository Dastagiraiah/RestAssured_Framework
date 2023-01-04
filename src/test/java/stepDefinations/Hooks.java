package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void beforescenario() throws IOException {
		
		StepDefination step = new StepDefination();
		if(step.req==null) {
		step.add_place_paylod_with("New_place", "English", "USA");
		step.user_calls_with_https("AddPlaceAPI", "Post");
		step.verify_the_place_id_created_map_to_using("New_place", "GetPlaceAPI");
		}
		
	}
}
