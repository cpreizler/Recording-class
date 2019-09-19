package spring2019;
import java.util.Scanner; 
public class RecordingSortArray {
	
	public static void main (String[] args) {
		Scanner input=new Scanner(System.in); 
		Recording[] recArray=new Recording [5]; //values will be added to it in the next method instead of creating two arrays and returning one
		getUserRecs(input, recArray); //call method that gets recording input from user and puts it in the array
		int stop=0;
		do { //run this until the user wishes to stop
			int orderChoice=getUserOrderChoice(input); 
			int sortChoice=getUserSortChoice(input); 
			switch (orderChoice) //call the appropriate sort methods based on which one the user chose
			{
			case 1: ascSort(recArray,sortChoice);
					break;
			case 2: descSort(recArray,sortChoice);		        
			}
			displaySortedArray(recArray);
			System.out.println("To select a different sort enter any number except 1, to stop enter 1: ");
			stop=input.nextInt(); //allow user to stop
		} while(stop!=1);
		input.close();
	}

	
	public static void getUserRecs (Scanner input, Recording [] recArr) { //puts user input in the recording array
		System.out.println("This program allows you to keep records of 5 recordings played and will sort them according to your preference.");
		for (int i=0; i<5; i++) { //set a for loop to input the values for the 5 recordings
			Recording record=new Recording(); //create new Recording object
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
			input.nextLine(); //clear the buffer
			System.out.println();
		}	
	}
	
	//this method gets and returns the users sort selection for ascending or descending order
	public static int getUserOrderChoice(Scanner input) {
		int pick;
		System.out.println("How would you like your records sorted? \n Enter 1 for ascending or 2 for descending: ");
		pick=input.nextInt(); 
		while (pick!=1 && pick!=2) {  //input validation
			System.out.println("Please enter either 1 or 2: ");
			pick=input.nextInt(); 
		}
		System.out.println();
		return pick;
	}
	
	//this method gets and returns user choice for which field the data will be sorted by
	public static int getUserSortChoice(Scanner input) {
		int pick;
		System.out.println("Which field would you like them sorted by? \n 1. Title \n 2. Artist \n 3. Playing Time \n Enter 1, 2, or 3: ");
		pick=input.nextInt();
		while (pick!=1 && pick!=2 && pick!=3) { //input validation
			System.out.println("Please enter only 1,2, or 3: ");
			pick=input.nextInt();
		}
		return pick;
	}
	
	//this method calls the appropriate method based on what field the user chose to sort by
	public static void ascSort(Recording [] recArr, int fieldChoice) {
		switch (fieldChoice)
		{
		case 1: titleAscSort(recArr); //I know I could have bundled title with artist sort method using an if 
									 //fieldChoice==1 or switch statement but I felt separate methods were much neater and clearer
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
		for (start=0; start<4; start++) { //this will iterate through all elements except the last one which will already have the right value by the time we get up to it
			minI=start; 
			minVal=recArr[start]; //variable to hold the object with lowest title value
			for (i=start+1; i<5; i++) {  //iterates through all elements following the one we are setting
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
		for (start=0; start<4; start++) { //this will iterate through all elements except the last one which will already have the right value by the time we get up to it
			minI=start;
			minVal=recArr[start]; //variable to hold the object with lowest artist value
			for (i=start+1; i<5; i++) {  //iterates through all elements following the one we are setting
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
		for (start=0; start<4; start++) { //this will iterate through all elements except the last one which will already have the right value by the time we get up to it
			minI=start;
			minVal=recArr[start]; //variable to hold the object with lowest playing time value
			for (i=start+1; i<5; i++) {  //iterates through all elements following the one we are setting
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
		for (start=0; start<4; start++) { //this will iterate through all elements except the last one which will already have the right value by the time we get up to it
			highI=start;
			highVal=recArr[start]; //variable to hold the object with highest title value
			for (i=start+1; i<5; i++) {  //iterates through all elements following the one we are setting
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
		for (start=0; start<4; start++) { //this will iterate through all elements except the last one which will already have the right value by the time we get up to it
			highI=start;
			highVal=recArr[start]; //variable to hold the object with highest artist value
			for (i=start+1; i<5; i++) {  //iterates through all elements following the one we are setting
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
		for (start=0; start<4; start++) { //this will iterate through all elements except the last one which will already have the right value by the time we get up to it
			highI=start;
			highVal=recArr[start]; //variable to hold the object with highest playing time value
			for (i=start+1; i<5; i++) {  //iterates through all elements following the one we are setting
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
