class Prism extends Rectangle{//Rectangual prism 
	private double height;
	private double thickness;
	public Prism(){
	}
	public Prism(double x,double y,double z,String a,double t){
		super.setLength(x);
		super.setWidth(y);
		height = z;	
		super.metalType(a);
		thickness = t;
	}
	public double getHeight(){
		return height;
	}
	public void setHeigth(double h){
		height = h;
	}
	public double getThickness(){
		return thickness;
	}
	public void setThickness(double t){
		thickness = t;
	}
	public double findArea(){
		return super.findArea();
	}
	
	public double findSurfaceArea(){
		return super.findCircumference()+2*(height*super.getLength())+2*(height*super.getWidth());
	}
	public double findVolume(){
		return super.findArea()*height;
	}
	public double findVolumeWithThickness(){
		double l = (super.getLength()-2*thickness);
		double w = (super.getWidth()-2*thickness);
		double h = height-2*thickness;	
		return l*w*h;
	}
	public double findWeight(){
		double weight;
		if(findVolumeWithThickness()<0){//dersom indrevolumet er minde enn 0(større enn det ytre) sett vekt til 0.
			weight = 0.0;
		}
		else
			weight = (findVolume()-findVolumeWithThickness())*getMetalWeight();
		return weight;
	}

	public String toString(){
		String a = "";
		if(findWeight() ==0.0)
			a = super.toString()+" ,height:"+height +" ,thickness:"+thickness+"\nhas a volume of: "+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is xxxx. Cant calculate because the thickness is to large";
		else
			a = super.toString()+" ,height:"+height +" ,thickness:"+thickness+"\nhas a volume of: "+findVolume()+" and inner volume of: "+findVolumeWithThickness()+"\nand the total weight of the object is "+findWeight();
		return  a;
	}
	
	
}
