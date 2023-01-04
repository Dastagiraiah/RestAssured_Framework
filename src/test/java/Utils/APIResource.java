package Utils;

public enum APIResource {
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePalceAPI("/maps/api/place/delete/json");
	private String resource;
	
	APIResource(String re){
		this.resource = re;
	}
	
	public String getResource() {
		return resource;
	}
}
