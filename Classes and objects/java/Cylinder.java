/*Cylinder klassen*/
class Cylinder extends Circle {//sylinder
	private double height;
	private double thickness;
	public Cylinder(){//default constructor
		super();
	}
	public Cylinder(double x,double y,String s,double t){//leser inn radius og lengde som double verdier
		super(x);
		height = y;
		super.metalType(s);
		thickness = t;
	}
	public double getLenght(){
		return height;
	}	
	public void setHeight(double h){
		height = h;
	}
	public double getThickness(){
		return thickness;
	}
	public void setThickness(double t){
		thickness = t;
	}
	public double findSurfaceArea(){
		return 2*super.findArea()+super.findCircumference()*height;
	}	
	public double findVolume(){
		return super.findArea()*height;
	}
	public double findVolumeWithThickness(){//indre volumet n� en tykkelse er satt
		double a = Math.pow(super.getRadius()-thickness, 2)*Math.PI;
		double h = height-(2*thickness);
		return a*h;
	}
	public double findWeight(){
		double weight;
		if(findVolumeWithThickness()<0){//sett vekten til 0, dersom det er umulig � regne ut ( tykkelse er for stor fordi den regnes utenfra og inn)
			weight = 0;
		}
		else
			weight = (findVolume()-findVolumeWithThickness())*getMetalWeight();
		return weight;
	}
	public String toString(){//skriver lendge og radius til string
		String a  = "";
		if(findWeight()==0)//info til bruker, hvorfor vekta ikke kunne regnes ut!
			a = "A cylinder made of"+getMetalInfo()+"with: "+super.toString()+" ,height:"+height+" ,thickness:"+thickness+"\nhas a volume of: "+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is: xxxx. Cant calculate because the thickness is to large!";
		else
			a = "A cylinder made of"+getMetalInfo()+"with: "+super.toString()+" ,height:"+height+" ,thickness:"+thickness+"\nhas a volume of: "+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is: "+findWeight();
		return a;
	}
}
class Cone extends Circle{//kjegle
	private double height;
	private double thickness;

	public Cone(){
		super();
	}
	public Cone(double x,double y,String s,double t){
		super(x);
		height = y;
		super.metalType(s);
		thickness = t;
	}
	public double getHeight(){
		return height;
	}
	public void setHeight(double h){
		height = h;
	}
	public double getThickness(){
		return thickness;
	}
	public void setThickness(double t){
		thickness = t;
	}
	public double findSurfaceArea(){//201 157
		return super.findArea()+Math.PI*super.getRadius()*Math.sqrt(Math.pow(height, 2)+Math.pow(super.getRadius(),2));
	}	
	public double findVolume(){
		return super.findArea()*(height/3);
	}
	public double findVolumeWithThickness(){
		double x = (height*thickness)/super.getRadius();
		double y = Math.sqrt((Math.pow(x, 2)+(Math.pow(thickness, 2))));
		double newHeight = height-thickness-y;
		double newRadius = (newHeight*super.getRadius())/height;
		double nFindArea = Math.pow(newRadius, 2)*Math.PI;
		return nFindArea*(newHeight/3);
	}
	public double findWeight(){
		double weight;
		if(findVolumeWithThickness()<0){
			weight = 0;
		}
		else
			weight = (findVolume()-findVolumeWithThickness())*getMetalWeight();
		return weight;
	
	}
	public String toString(){
		String a = "";
		if(findWeight()==0)
			a="A cone made of"+getMetalInfo()+"with:"+super.toString()+" ,height:"+height+" ,thickness:"+thickness+"\nhas a volume of: "+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is: xxxx. Cant calculate because the thickness is to large!";
		else
			a="A cone made of"+getMetalInfo()+"with:"+super.toString()+" ,height:"+height+" ,thickness:"+thickness+"\nhas a volume of: "+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is: "+findWeight();
		return a;
	}
}
class Sphere extends Circle{//kule
	private double thickness;
	public Sphere(){		
	}
	public Sphere(double x,String s,double t){
		super(x);
		super.metalType(s);
		thickness = t;
	}
	public double getThickness(){
		return thickness;
	}
	public void setThickness(double t){
		thickness = t;
	}
	public double findSurfaceArea(){
		return 4*super.findArea();
	}
	public double findVolume(){
		return (4.0/3.0)*Math.pow(super.getRadius(), 3);
	}
	public double findVolumeWithThickness(){
	
		return (4.0/3.0)*Math.pow(super.getRadius()-thickness, 3);
	}
	public double findWeight(){
		double weight;
		if(findVolumeWithThickness()<0){
			weight = 0;
		}
		else
			weight = (findVolume()-findVolumeWithThickness())*getMetalWeight();
		return weight;
	}
	public String toString(){
		String a  ="";
		if(findWeight()==0)
			a = "A sphere made of"+getMetalInfo()+"with:"+super.toString()+" ,thickness: "+thickness+"\nhas a volume of :"+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is: xxxx. Cant calculate because the thickness is to large!";
		else
			a = "A sphere made of"+getMetalInfo()+"with:"+super.toString()+" ,thickness: "+thickness+"\nhas a volume of :"+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is: "+findWeight();
		return a;
	}
}
