package pattern.java;

/*
 * 
 * Builder Pattern is used so that we can re-use same "construction" code
 * to create "similar" type of objects ( or, Objects of same family).
 * 
 */


abstract class ObjectBuilder{
	private String id;
	private String header;
	private String body;
	private String footer;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	void buildId(String Id){
		this.setId(Id);
	}
	void buildHeader(String headerText){
		this.setHeader(headerText);
	}
	void buildBody(String bodyText){
		this.setBody(bodyText);
	}
	void buildFooter(String footerText){
		this.setFooter(footerText);
	}
	void printPageData(){
		System.out.println("Details : " + this.getType() + "|header=" + this.getHeader());
	}
}

class ObjectDirector{
	//it needs a construct() with 
	// an Object builder, a page type parameter, and 
	//[optional second argument/arguments 
	//with parameters] to set various page parameters
	public void construct(ObjectBuilder builder,String typeOfPage, String... parameters){
		buildObjectData(builder,parameters.length,parameters);
		builder.setType(typeOfPage);
		builder.printPageData();
	}
	
	public void buildObjectData(ObjectBuilder builder,int length,String [] parameters){
		if(length==1){
			builder.buildId(parameters[0]);
		}else if(length==2){
			builder.buildId(parameters[0]);
			builder.buildHeader(parameters[1]);
		}else if(length==3){
			builder.buildId(parameters[0]);
			builder.buildHeader(parameters[1]);
			builder.buildFooter(parameters[2]);
		}else if(length==4){
			builder.buildId(parameters[0]);
			builder.buildHeader(parameters[1]);
			builder.buildBody(parameters[2]);
			builder.buildFooter(parameters[3]);
		}else{
			return;
		}
	}
}

class HomePage extends ObjectBuilder{
	HomePage(){
		System.out.println("This is home...init ");
	}
}
class LandingPage extends ObjectBuilder{
	LandingPage(){
		System.out.println("This is landing...init");
	}
}

public class BuilderPattern{
	public static void main(String args[]){
		ObjectDirector director = new ObjectDirector();
		director.construct(new HomePage(), "HomePage", "Home Page","This is Home Page Body","This is Home Page Footer");
		director.construct(new LandingPage(), "LandingPage", "Landing Page","This is Landing Page Body","This is Landing Page Footer");
	}
}