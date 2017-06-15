import java.util.Random;
import java.util.Scanner;
public class HashTableChaining {
	
	SingleLinkedList[] hashTable;
	static int hashTableSize;
	
	HashTableChaining(int s)//Constructor med størrelse som inngang
	{
		hashTableSize = s;
		hashTable = new SingleLinkedList[hashTableSize];
		for(int i=0;i<hashTableSize;i++)
			hashTable[i] = new SingleLinkedList();
	}
	public void showHashTable(){//For å printe ut indeksene med listene.
		for(int i=0;i<hashTableSize;i++)
		{
			System.out.print("Index "+i+": ");
			System.out.print(hashTable[i].toString());
		}
	}
	public int getKey(int key) //Hashing funksjon som finner "nøkkelen".
	{
		return key%hashTableSize;
	}
	public void insert(int a)//Setter inn verdier inn i en array.
	{	
		int key = getKey(a);
		hashTable[key].addInFront(a);
	}
	public static void main(String[] args)
	{

		Scanner input = new Scanner(System.in);
		System.out.print("Hvor stor tabell �nsker du � lage?");
		HashTableChaining hT = new HashTableChaining(input.nextInt());
		//System.out.print("Hvor mange elementer vil du generere? :"); 
		//int amountOfElements = input.nextInt();
		int elements[]= {2,8,22,44,89,115,7,59,1002,30,66,999,1324,4,777,202,876};
		
		for(int i=0;i<elements.length;i++)
		{
			//Random randomNr = new Random();
			//hT.insert(randomNr);
			hT.insert(elements[i]);
		}
		hT.showHashTable();
		System.out.print("Den totale loadfactoren er: "+(double)elements.length/hashTableSize);
	}
}
