
public abstract class GeometricObject {
	
	private double metalWeight=0.0;
	private String meInfo = "";
	
	public abstract double findArea();
	public abstract double findCircumference();
	public abstract double findSurfaceArea();
	public abstract double findWeight();
	public abstract double findVolume();
	
	protected double metalType(String s){//sjekker hva slags metall det er og setter da metalWeight til tilsvarende metall.
		if(s.equals("iron")){
			metalWeight = 7.8;
			meInfo = " iron ";
		}
		else if(s.equals("aluminium")){
			metalWeight = 2.7;
			meInfo = " aluminum ";
		}
		else if(s.equals("copper")){
			metalWeight = 8.9;
			meInfo = " copper ";
		}
		else if(s.equals("tin")){
			metalWeight = 7.3;
			meInfo = " tin ";
		}
		return metalWeight;		
	}
	public double getMetalWeight(){
		return metalWeight;
	}
	public void setMetalWeight(double w){
		metalWeight = w;
	}
	public String getMetalInfo(){
		return meInfo;
	}
	public void setMetalInfo(String s){
		meInfo = s;
	}
	
	
}

