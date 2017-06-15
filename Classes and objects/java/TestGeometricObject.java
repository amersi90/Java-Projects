import java.util.Random;

public class TestGeometricObject {
	public static void main(String[] args)
	{					
		GeometricObject boks = new Prism(10.0,10.0,1.0,"tin",.35);
		GeometricObject sylinder = new Cylinder(5.0,3.0,"copper",1.6); 
		GeometricObject kjegle = new Cone(5.0,3.2,"iron",1.3);
		
		System.out.println(boks.toString());
		System.out.println("\n"+sylinder.toString());
		System.out.println("\n"+kjegle.toString());


	}
}