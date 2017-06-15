import java.util.Arrays;
import java.util.Scanner;


public class Prims_MST {
	public static void main(String[] args)
	{				  //A	B	C	D	E	F	G
		int [][]mst = {{0,	8,	10,	13,	0,	0,	0},	// A
		   		  	   {8,	0,	0,	11,	0,	0,	0},	// B
		   		  	   {10,	0,	0,	13,	0,	12,	0}, // C
		   		  	   {13,	11,	13,	0,	12,	0,	11},// D
		   		  	   {0,	0,	0,	12,	0,	5,	9},	// E
		   		  	   {0,	0,	12,	0,	5,	0,	7},	// F
		   		  	   {0,	0,	0,	11,	9,	7,	0}};// G;
	
		prepareArray(mst);	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Which node do u want to start with, use indexes (0 for A, 1 for B and so on...):");
		try{
			minimumWeight(mst,input.nextInt());
		}catch(IndexOutOfBoundsException a){
			System.out.print("Could not start in the following index, default index [0] was selected\n");
			minimumWeight(mst,0);
		};
		
	
	}
	public static void prepareArray(int a[][])
	{
		for(int i = 0; i <a.length ; i++){
			for(int j = 0; j < a.length; j++)
				if(a[i][j]<=0)//Anything less or equal 0 is changed to MAX_VALUE
					a[i][j] = Integer.MAX_VALUE;		
		}
	}
	public static void minimumWeight(int a[][],int n)//n is the index user want to start in
	{
		boolean visited[] = new boolean[a.length];//Visited array to check if elements in a have been visited
		int iCopy=0,kCopy=0;//Used later to get which index the nodes are in
		String[] nodes = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
		String stored[] = new String[a.length-1];//The cost between nodes are going to be stored here
		int totalWeight = 0;//Set start weight to 0
		
		visited[n]=true;//Set as visited.
		/*Find the minimum weight*/
		for(int edge= 0; edge< a.length-1 ; edge++){//edge = 1 less than the array length
			int min = Integer.MAX_VALUE;//set min to max each time loop enters 
			for(int i = 0; i < a.length; i++){//Rows 
				if(visited[i]==true){//if this row has been visited then enter column for-loop
					for(int k = 0; k < a.length; k++){//Columns
						if(visited[k]==false){//don´t visit allready visited elements
							if(min > a[i][k]){
								min = a[i][k];//Set the new minimum 
								iCopy=i;
								kCopy=k;
							}	
						}
					}//end k-for
				}
			}//end i-for
			visited[kCopy]=true;//Set as visited 
			totalWeight += min;//increase weight with minimum values
			stored[edge]=""+nodes[iCopy]+"--->"+nodes[kCopy]+"="+min+" ";//Store the cost between edges
		}
		System.out.print("Total weight of the edges: "+ totalWeight+"\n");//Print the total weight
		System.out.print(Arrays.toString(stored));//Print the cost between edges
		
	}
}
