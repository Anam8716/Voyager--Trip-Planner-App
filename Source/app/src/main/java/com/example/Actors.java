package com.example;

public class Actors {

	private String name;
	private String description;
	private String dob;
	private String country;
	private String height;
	private String spouse;
	private String tname;
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	private String children;
	private String image;
    private String kind;
    private String countryCode;
    private String code;
    private String timeZone;
    private String sName;
    private String tName;
    private String host;
    private String distance;
    private String duration;
    private String price;
	private String position;
public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

private String pos;	
private String vehicle;
	public String getVehicle() {
	return vehicle;
}

public void setVehicle(String vehicle) {
	this.vehicle = vehicle;
}

	public Actors() {
		// TODO Auto-generated constructor stub
	}

	public Actors(String name, String description, String dob, String country,
			String height, String spouse, String children, String image,String kind,String countryCode ,String code ,String timeZone,String sName,String tName,String host,String pos,String vehicle,String distance,String duration,String price,String tname,String position ) {
		super();
		this.name = name;
		this.description = description;
		this.dob = dob;
		this.country = country;
		this.height = height;
		this.spouse = spouse;
		this.children = children;
		this.image = image;
		this.countryCode=countryCode;
		this.kind=kind;
		this.code=code;
		this.timeZone=timeZone;
		this.sName=sName;
		this.tName=tName;
		this.host=host;
		this.pos=pos;
		this.vehicle=vehicle;
		this.distance=distance;
		this.duration=duration;
		this.price=price;
	    this.tname=tname;
		this.position=position;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getSpouse() {
		return spouse;
	}

	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
