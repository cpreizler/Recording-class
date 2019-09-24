package spring2019;
import java.util.*; 
public class RecordingSortArrayList {

		public static void main (String[] args) {
			Scanner input=new Scanner(System.in); 
			ArrayList<Recording> recArrList=new ArrayList <Recording>(); 
			getUserRecs(input, recArrList); 
			int stop=0;
			do { 
				int orderChoice=getUserOrderChoice(input); 
				int sortChoice=getUserSortChoice(input); 
				switch (orderChoice) 
				{
				case 1: ascSort(recArrList,sortChoice);
						break;
				case 2: descSort(recArrList,sortChoice);		        
				}
				displaySortedList(recArrList);
				System.out.println("To select a different sort enter any number except 1, to stop enter 1: ");
				stop=input.nextInt(); 
			} while(stop!=1);
			input.close();
		}

		public static void getUserRecs (Scanner input, ArrayList<Recording> recList) { 
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
				recList.add(record); 
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
		public static void ascSort(ArrayList<Recording> recList, int fieldChoice) {
			switch (fieldChoice)
			{
			case 1: titleAscSort(recList); //I know I could have bundled title with artist sort method using an if 
										 //fieldChoice==1 or another switch statement but I felt separate methods were much neater and clearer
					break;
			case 2: artistAscSort(recList);
					break;
			case 3: timeAscSort(recList);
			}
			
		}
		
		public static void descSort(ArrayList<Recording> recList, int fieldChoice) {
			switch (fieldChoice)
			{
			case 1: titleDescSort(recList);
					break;
			case 2: artistDescSort(recList);
					break;
			case 3: timeDescSort(recList);
			}
		}
		
		public static void titleAscSort(ArrayList<Recording> recList) {
			for(int i=0; i<4; i++) {
				Recording lowest=recList.get(i);
				int lowI=i;
				for(int j=i+1; j<5; j++) {
					if (recList.get(j).getTitle().compareToIgnoreCase(lowest.getTitle())<0){  //if current title is less than "lowest" title, reassign the proper values
						lowest=recList.get(j);
						lowI=j;
					}	
				}
				if (lowI!=i) { //if your current list.get(i) is not the lowest, swap it with the lowest value
					recList.set(lowI, recList.get(i));
					recList.set(i, lowest);
				}
		    }	
		}
		
		public static void artistAscSort(ArrayList<Recording> recList) {
			for(int i=0; i<4; i++) {
				Recording lowest=recList.get(i);
				int lowI=i;
				for(int j=i+1; j<5; j++) {
					if (recList.get(j).getArtist().compareToIgnoreCase(lowest.getArtist())<0){  //if current artist is less than "lowest" artist, reassign the proper values
						lowest=recList.get(j);
						lowI=j;
					}	
				}
				if (lowI!=i) { //if your current list.get(i) is not the lowest, swap it with the lowest value
					recList.set(lowI, recList.get(i));
					recList.set(i, lowest);
				}
		    }	
		}
		
		public static void timeAscSort(ArrayList<Recording> recList) {
			for(int i=0; i<4; i++) {
				Recording lowest=recList.get(i);
				int lowI=i;
				for(int j=i+1; j<5; j++) {
					if (recList.get(j).getTime()<lowest.getTime()){  //if current time is less than "lowest" time, reassign the proper values
						lowest=recList.get(j);
						lowI=j;
					}	
				}
				if (lowI!=i) { //if your current list.get(i) is not the lowest, swap it with the lowest value
					recList.set(lowI, recList.get(i));
					recList.set(i, lowest);
				}
		    }	
		}
		
		public static void titleDescSort(ArrayList<Recording> recList) {
			for(int i=0; i<4; i++) {
				Recording highest=recList.get(i);
				int highI=i;
				for(int j=i+1; j<5; j++) {
					if (recList.get(j).getTitle().compareToIgnoreCase(highest.getTitle())>0){  //if current title is greater than "highest" title, reassign the proper values
						highest=recList.get(j);
						highI=j;
					}	
				}
				if (highI!=i) { //if your current list.get(i) is not the highest, swap it with the highest value
					recList.set(highI, recList.get(i));
					recList.set(i, highest);
				}
		    }	
		}
		
		public static void artistDescSort(ArrayList<Recording> recList) {
			for(int i=0; i<4; i++) {
				Recording highest=recList.get(i);
				int highI=i;
				for(int j=i+1; j<5; j++) {
					if (recList.get(j).getArtist().compareToIgnoreCase(highest.getArtist())>0){  //if current artist is greater than "highest" artist, reassign the proper values
						highest=recList.get(j);
						highI=j;
					}	
				}
				if (highI!=i) { //if your current list.get(i) is not the highest, swap it with the highest value
					recList.set(highI, recList.get(i));
					recList.set(i, highest);
				}
		    }	
		}

		public static void timeDescSort(ArrayList<Recording> recList) {
			for(int i=0; i<4; i++) {
				Recording highest=recList.get(i);
				int highI=i;
				for(int j=i+1; j<5; j++) {
					if (recList.get(j).getTime()>highest.getTime()){  //if current time is greater than "highest" time, reassign the proper values
						highest=recList.get(j);
						highI=j;
					}	
				}
				if (highI!=i) { //if your current list.get(i) is not the highest, swap it with the highest value
					recList.set(highI, recList.get(i));
					recList.set(i, highest);
				}
		    }	
		}
		
		public static void displaySortedList(ArrayList<Recording> recList) {
			System.out.println("Recordings have been sorted. \n");
			for(int i=0; i<5; i++) {
				System.out.println("Recording "+(i+1)+ ": \n " + recList.get(i).toString());
				System.out.println();
			}
		}

	}

