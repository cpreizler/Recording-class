package spring2019;

/** this class creates a record of each recording that a radio station plays **/

public class Recording {
	private String title; 
	private String artist;
	private double playingTime; 
	
	public Recording () { 
		
		this (null, null, 0); 	
	}
	
	public Recording (String title) { 
		this (title, null, 0); 
	}
	
	public Recording (String title, String artist) { 
		this (title, artist, 0);
	}
	
	public Recording (String title, String artist, double playingTime) { 
		if (playingTime<0)
			throw new IllegalArgumentException("Playing time must be atleast 0 seconds");
		this.title=title;
		this.artist=artist;
		this.playingTime=playingTime;
	}
	
	public Recording (Recording rec) {
		this(rec.getTitle(), rec.getArtist(),rec.getTime());
	}

	public void setAll (String title, String artist, double playingTime) {
		if (playingTime<0)
			throw new IllegalArgumentException("Playing time must be atleast 0 seconds");
		this.title=title;
		this.artist=artist;
		this.playingTime=playingTime;
	}
	
	public void setTitleAndArtist(String title, String artist) {
		this.title=title;
		this.artist=artist;
	}
	
	public void setTitle  (String title) {
		this.title=title; 
	}
	
	public void setArtist (String artist) {
		this.artist=artist;
	}
	
	public void setTime(double playingTime) {
		if (playingTime<0)
			throw new IllegalArgumentException("Playing time must be atleast 0 seconds");
		this.playingTime=playingTime;
	}
	
	public String getTitle() {
		return title; 
	}
	
	public String getArtist() {
		return artist;
	}
	
	public double getTime() {
		return playingTime;
	}
	

	@Override
	public String toString() {
		StringBuilder record=new StringBuilder();
		record.append("Title: "+ title + "\n Artist: "+ artist + "\n Playing Time: "+ String.format("%.2f", playingTime) );
		return record.toString(); 
	}
	
	@Override
	public boolean equals (Object rec) { 
		if (this==rec)
			return true;
		if (rec==null)
			return false;
		if (this.getClass() != rec.getClass() )
			return false;
		Recording second= (Recording) rec;
		if (!this.getTitle().equals(second.getTitle()))
			return false; 
		if (!this.getArtist().equals(second.getArtist()))
			return false;
		if (playingTime!=second.getTime())
			return false;
		return true; 
	}
	
	
}
