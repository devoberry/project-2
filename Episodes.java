/**
 * <p>This class gives the specifics of an episode in a TV series.</p>
 * <p> One thing different than most mediums is that Episodes don't always have a title.
 * So the season number and the episode number are increasingly more important than they would be otherwise.</P>
 * <p>The Episodes class inherits the Title and ReleaseYear methods alongside the comparable methods.</p>
 * @version 1.0
 *
 */
public class Episodes extends Media{
	/** Stores the title of the Series that the Episode is stored in*/
	private String seriesTitle;
	/** Stores the title of the Episodes*/
	//private String title;
	/** Stores the releaseYear of the Episodes*/
	//private Integer releaseYear;
	/** Stores the season of the Episodes*/
	private Integer season;
	/** Stores the episodeNumber of the Episodes*/
	private int episodeNumber;
	/** Stores ???? if the year is unknown*/
	private String unspecified;
	/** Stores a String if the episode was never aired or canceled*/
	private String suspended;
	
	/**
	 * <p>This constructor stores all the information possible in an Episode,
	 * even when that information is unavailable.</p>
	 * 
	 * <p> If any information that is not given must be stored as null or 0, 
	 * and certain methods will allow that (lack thereof) information to be sorted and compared.</p>
	 * <p> For example, if an Episode does not have a title,
	 *  it may be sorted/compared through its season and episodeNum. If an Episode doesn't have a Season,
	 *  it also won't have an episodeNum and can be compared through it's title.</p>
	 *  
	 * @param seriesTitle - the Title of the Series in which the series Aired.
	 * @param title - a String of the title of the Episode or null if unavailable.
	 * @param year - an Integer of the releaseYear or null if unavailable
	 * @param season - an Integer of the season or null if unavailable
	 * @param episodeNumber - an int of the episode number or zero if unavailable
	 * @param unspecified - a String of ???? if the year is unknown, or null if year is known
	 * @param suspended - a String if the show was suspended, or null if unnecessary
	 */
	public Episodes(String seriesTitle, String title, Integer year, Integer season,
			int episodeNumber , String unspecified , String suspended){
		this.seriesTitle = seriesTitle;//assigns Series Title to an episode to add
		this.title = title;//assigns title
		this.releaseYear = year;//assigns year episode aired
		this.season = season;//assigns the season that the episode aired in
		this.episodeNumber = episodeNumber;//the number of the episode in such season
		this.unspecified = unspecified;//???? if the releaseYear is unknown
		this.suspended = suspended;//SUSPENDED if the episode was cancelled or never made.
	}
	
	/** this method will return a String of the Series Title in which the Episode aired
	 *
	 * @return a String of the Series title
	 */
	
	public String getSeriesTitle(){
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * <p>This method will return an Integer object of the Season that the Episode aired in.</p>
	 * @return an Integer of the season the episode aired
	 */
	public Integer getSeason(){
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * <p>This method will return the int value of the Episode number.</p>
	 * 
	 * @return an int of the episode number
	 */
	public int getEpisodeNumber(){
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * <p> This method returns true if the Episode was indeed suspended. False otherwise.</p>
	 * @return boolean true if episode was suspended. False otherwise
	 */
	public boolean isSuspended(){
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * <p>This method returns a String of SUSPENDED if the Episode was indeed suspended.</p>
	 * 
	 * @return a String of SUSPENDED
	 */
	public String getSuspended(){
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * <P> This method will return a string of ???? if the releaseYear is null.
	 * @return a String of ????
	 */
	public String getUnspecified(){
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * <p>This method will set the Integer number of the Season in which the Episode aired.</p>
	 * 
	 * @param season - an Integer number of the season
	 */
	public void setSeason(Integer season){
		// TODO Auto-generated method stub
		this.season = season;
	}
	 /**
	  * This method will set the int value of the episode number within a season
	  * 
	  * @param number - an int value of the episode number
	  */
	public void setEpisodeNumber(int number){
		// TODO Auto-generated method stub
		this.episodeNumber = number;
	}
	
	/**
	 * <p>This method will set a String value of SUSPENDED to the suspended variable.
	 * @param suspended -  a String value of SUSPENDED
	 */
	public void setSuspended(String suspended){
		// TODO Auto-generated method stub
		this.suspended = suspended;
	}
	/**
	 * This method will set a String of ???? if the release Year of an Episode is unknown.
	 * @param unspecified a String of ????
	 */
	public void setUnspecified(String unspecified){
		this.unspecified = unspecified;
	}
	
	/**This method will return a String representation of all relevant information in an Episodes.
	 * 
	 * @return a String of all relevant information in an Episodes
	 */
	public String printAll(){
		// TODO Auto-generated method stub
		return null;
	}
}