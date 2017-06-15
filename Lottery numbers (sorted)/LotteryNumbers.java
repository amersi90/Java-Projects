import java.util.Scanner;
 
public class Oblig_3 {
    public static void main(String[] args)
    {   
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        int []x= new int [7];
        System.out.print("Vil du trekke ut for 1)LOTTO eller 2)VIKINGLOTTO ?: ");
        int valg = input.nextInt();
        int rekker =lesInn();
        
        for(int i=0;i<rekker;i++){
            trekk(x,valg);
            sorter(x,valg);
            skrivUt(x,valg);
        }
    }//main
    static int lesInn(){   
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        System.out.print("Hvor mange rekker vil du trekke? :");
        int a = input.nextInt();
        return a;
    }//lesInn
    static void trekk(int []b,int v) 
    {  
       for(int i=0;i<(b.length+1)-v;i++){//generer random tall for posisjon 0,1,2,3,4,5,6 i tabellen
           if(v==1)  //LOTTO  
        	   b[i]= (int)(Math.random()*34.0)+1;//største tallet som kan være med er 34 og minste er 0
           else if(v==2)//VIKING LOTTO
        	   b[i]= (int)(Math.random()*48.0)+1;//største tallet som kan være med er 48 og minste er 0
           for(int j=0;j<=i-1;j++){//Sjekker for samma verdi
      	       if(b[j]==b[i])
      	       i--;
           }
       }
    }//trekkUt
    static void sorter(int[]c, int v)//BubbleSort metoden
    {
        int j,temp,k=0;
        while (k==0){
            k=1;
            for(j=0;j<c.length-v;j++ ){
               if (c[j]>c[j+1]){//Her forrander verdien plass fra minst til størst
                  temp = c[j];  //temp får c[j] verdien              
                  c[j] = c[j+1];//nye c[j] er den neste verdien i rekken
                  c[j+1] = temp; //c[j+1] er nå temp verdien som var tidligere c[j]
                  k=0;//går tilbake i while løkka
               }
            }       
        }
    }
    static void skrivUt(int[]d,int v){
            for(int i =0;i<(d.length+1)-v;i++)
                System.out.print(d[i] + "\t");
            System.out.print("\n");     
    }//skrivUt
}