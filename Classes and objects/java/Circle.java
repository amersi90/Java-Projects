
abstract class Circle extends GeometricObject {
	private double radius;
	public Circle(){
		//Default constructor
	}
	public Circle(double r){
		radius = r;
	}
	public double getRadius(){
		return radius;
	}
	public void setRadius(double s){
		radius = s;
	}
	
	public double findArea(){
		return Math.pow(radius, 2)*Math.PI;
	}
	public double findCircumference(){
		return 2*Math.PI*radius;
	}
	public String toString(){
		return "\nradius:"+radius;
	}
		
}
abstract class Rectangle extends GeometricObject{
	private double length,width;
	public Rectangle(){		
	}
	public Rectangle(double x,double y){
		length = x;
		width = y;
	}
	public double getLength(){
		return length;
	}
	public void setLength(double r){
		length = r;
	}
	public double getWidth(){
		return width;
	}
	public void setWidth(double s){
		width = s;
	}
	public double findArea(){
		return length*width;
	}
	public double findCircumference(){
		return 2*findArea();
	}
	public String toString(){
		return "A retangual prism made of"+getMetalInfo()+"with: \nlength:"+length+", width:"+width;
	}
}
