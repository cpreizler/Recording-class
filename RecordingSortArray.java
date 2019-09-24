package spring2019;
import java.util.Scanner; 
public class RecordingSortArray {
	
	public static void main (String[] args) {
		Scanner input=new Scanner(System.in); 
		Recording[] recArray=new Recording [5]; 
		getUserRecs(input, recArray); 
		int stop=0;
		do { 
			int orderChoice=getUserOrderChoice(input); 
			int sortChoice=getUserSortChoice(input); 
			switch (orderChoice) 
			{
			case 1: ascSort(recArray,sortChoice);
					break;
			case 2: descSort(recArray,sortChoice);		        
			}
			displaySortedArray(recArray);
			System.out.println("To select a different sort enter any number except 1, to stop enter 1: ");
			stop=input.nextInt(); 
		} while(stop!=1);
		input.close();
	}

	
	public static void getUserRecs (Scanner input, Recording [] recArr) {
		System.out.println("This program allows you to keep records of 5 recordings played and will sort them according to your preference.");
		for (int i=0; i<5; i++) { 
			Recording record=new Recording(); 
			System.out.println("Please enter the title of recording #" + (i+1) + ": ");
			String title=input.nextLine(); 
			System.out.println("Please enter the artist of recording #" + (i+1) + ": ");
			String artist=input.nextLine();
			boolean flag;
			do {
				try
				{
					System.out.println("Please enter the playing time (in seconds) of recording #" + (i+1) + ": ");
					double time=input.nextDouble();
					record.setTime(time);
					flag=false;
				}
				catch (IllegalArgumentException e)
				{
					System.out.printf("Exception: %s%n%n", e.getMessage());
					flag=true; 
				}
			} while (flag==true);
			
			record.setTitleAndArtist(title,artist);
			recArr[i]=record; 
			input.nextLine(); 
			System.out.println();
		}	
	}
	
	public static int getUserOrderChoice(Scanner input) {
		int pick;
		System.out.println("How would you like your records sorted? \n Enter 1 for ascending or 2 for descending: ");
		pick=input.nextInt(); 
		while (pick!=1 && pick!=2) { 
			System.out.println("Please enter either 1 or 2: ");
			pick=input.nextInt(); 
		}
		System.out.println();
		return pick;
	}
	
	
	public static int getUserSortChoice(Scanner input) {
		int pick;
		System.out.println("Which field would you like them sorted by? \n 1. Title \n 2. Artist \n 3. Playing Time \n Enter 1, 2, or 3: ");
		pick=input.nextInt();
		while (pick!=1 && pick!=2 && pick!=3) { 
			System.out.println("Please enter only 1,2, or 3: ");
			pick=input.nextInt();
		}
		return pick;
	}
	

	public static void ascSort(Recording [] recArr, int fieldChoice) {
		switch (fieldChoice)
		{
		case 1: titleAscSort(recArr); 
				break;
		case 2: artistAscSort(recArr);
				break;
		case 3: timeAscSort(recArr);
		}
		
	}
	
	public static void descSort(Recording [] recArr, int fieldChoice) {
		switch (fieldChoice)
		{
		case 1: titleDescSort(recArr);
				break;
		case 2: artistDescSort(recArr);
				break;
		case 3: timeDescSort(recArr);
		}
	}
	
	public static void titleAscSort(Recording [] recArr) {
		int start, i, minI;
		Recording minVal;
		for (start=0; start<4; start++) { 
			minI=start; 
			minVal=recArr[start]; 
			for (i=start+1; i<5; i++) {
				if (recArr[i].getTitle().compareToIgnoreCase(minVal.getTitle())<0) {
					minI=i;
					minVal=recArr[i];
				}
			}
		recArr[minI]=recArr[start];
		recArr[start]=minVal;
		}
		
	}
	
	public static void artistAscSort(Recording [] recArr) {
		int start, i, minI;
		Recording minVal;
		for (start=0; start<4; start++) { 
			minI=start;
			minVal=recArr[start]; 
			for (i=start+1; i<5; i++) { 
				if (recArr[i].getArtist().compareToIgnoreCase(minVal.getArtist())<0) {
					minI=i;
					minVal=recArr[i];
				}
			}
		recArr[minI]=recArr[start];
		recArr[start]=minVal;
		}
	}
	
	public static void timeAscSort(Recording [] recArr) {
		int start, i, minI;
		Recording minVal;
		for (start=0; start<4; start++) { 
			minI=start;
			minVal=recArr[start]; 
			for (i=start+1; i<5; i++) {  
				if (recArr[i].getTime()<minVal.getTime()) {
					minI=i;
					minVal=recArr[i];
				}
			}
		recArr[minI]=recArr[start];
		recArr[start]=minVal;
		}		
	}
	
	public static void  titleDescSort(Recording [] recArr) {
		int start, i, highI;
		Recording highVal;
		for (start=0; start<4; start++) { 
			highI=start;
			highVal=recArr[start]; 
			for (i=start+1; i<5; i++) {  
				if (recArr[i].getTitle().compareToIgnoreCase(highVal.getTitle())>0) {
					highI=i;
					highVal=recArr[i];
				}
			}
		recArr[highI]=recArr[start];
		recArr[start]=highVal;
		}		
	}
	
	public static void artistDescSort(Recording [] recArr) {
		int start, i, highI;
		Recording highVal;
		for (start=0; start<4; start++) { 
			highI=start;
			highVal=recArr[start]; 
			for (i=start+1; i<5; i++) { 
				if (recArr[i].getArtist().compareToIgnoreCase(highVal.getArtist())>0) {
					highI=i;
					highVal=recArr[i];
				}
			}
		recArr[highI]=recArr[start];
		recArr[start]=highVal;
		}		
	}
	
	public static void  timeDescSort(Recording [] recArr) {
		int start, i, highI;
		Recording highVal;
		for (start=0; start<4; start++) { 
			highI=start;
			highVal=recArr[start]; 
			for (i=start+1; i<5; i++) {  
				if (recArr[i].getTime()>highVal.getTime()) {
					highI=i;
					highVal=recArr[i];
				}
			}
		recArr[highI]=recArr[start];
		recArr[start]=highVal;
		}		
	}
	
	public static void displaySortedArray(Recording[] recArr) {
		System.out.println("Recordings have been sorted. \n");
		for(int i=0; i<5; i++) {
			System.out.println("Recording "+(i+1)+ ": \n " + recArr[i].toString());
			System.out.println();
		}
	}
}
