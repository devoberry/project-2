import java.util.ArrayList;
/**
 * <p>The Series method contains the general information about a TV series. </p>
 * <p> Outside the general Media Title and ReleaseYear methods, 
 * the Series class details the endYear of a series (if there is one),
 * whether it was canceled before airing, and all of it episodes 
 * (not necessarily sorted).</p>
 * 
 * 
 * @version 1.0
 *
 */
public class Series extends Media{
	
	/** Stores the endYear of the Series*/
	private Integer endYear;
	/**Stores an Array of all Episodes in a Series*/
	private ArrayList<Episodes> allEpisodes;
	/** Stores ???? if the year is unknown*/
	private String unspecified;
	/** Stores a String if the Series never aired or canceled*/
	private String suspended;
	
	/**
	 * <p>This constructor takes all the information possible for a Series and stores it.
	 * For any information not available, the value will be stored as null.</P>
	 * <p> For example, if an endYear is unknown, the endYear will be null,
	 *  and unspecified will store ???? instead, but the value is still available for comparison.</p>
	 *  
	 * @param title- A String of the title of the Series
	 * @param releaseYear - An Integer of the first year the Series aired.
	 * @param endYear - an Integer of the last year a Series aired, if available. Null otherwise
	 * @param allEpisodes- an ArrayList of All episodes in a Series, suspended or otherwise.
	 * @param unspecified- a String of ???? if an endYear is unknown
	 * @param suspended- A string of SUSPENDED if the series was canceled or never made
	 */
	public Series(String title, Integer releaseYear, Integer endYear,
			ArrayList<Episodes> allEpisodes, String unspecified,
			String suspended){
		this.title = title;
		this.releaseYear = releaseYear;
		this.endYear = endYear;
		this.allEpisodes = allEpisodes;
		this.unspecified = unspecified;
		this.suspended = suspended;
	}
	/**
	 * This will return all stored Episodes, sorted or not, into an ArrayList of Episodes
	 * @return an unsorted (most likely) ArrayList of Episodes
	 */
	public ArrayList<Episodes> getAllEpisodes(){
		// TODO Auto-generated method stub
		return this.allEpisodes;
	}
	/**
	 * this method will set an ArrayList of episodes
	 * @param list an arraylist of episodes
	 * 
	 */
	public void setEpisodes(ArrayList<Episodes> list){
		this.allEpisodes = list;
	}
	/**
	 * This method will return the last Year a Series aired on TV
	 * @return an Integer representing the final year of a Series
	 */
	public Integer getEndYear(){
		// TODO Auto-generated method stub
		return this.endYear;
	}
	/**
	 * <P> This method will return a string of ???? if the releaseYear is null.
	 * @return a String of ????
	 */
	public String getUnspecified(){
		// TODO Auto-generated method stub
		return this.unspecified;
	}
	/**
	 * <p>This method returns a String of SUSPENDED if the Series was indeed suspended.</p>
	 * 
	 * @return a String of SUSPENDED
	 */
	public String getSuspended(){
		// TODO Auto-generated method stub
		return this.suspended;
	}
	/**
	 * <p> This method returns true if the Series was indeed suspended. False otherwise.</p>
	 * @return boolean true if Series was suspended. False otherwise
	 */
	public boolean isSuspended(){
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * This method will set the endYear, the last year an episode aired, for a Series.
	 * @param year an Integer value of the final year of a show
	 */
	public void setEndYear(Integer year){
		// TODO Auto-generated method stub
		this.endYear = year;
	}
	/**
	 * This method will set a String of ???? if the end Year of a Series is unknown.
	 * @param unspecified a String of ????
	 */
	public void setUnspecified(String unspecified){
		// TODO Auto-generated method stub
		this.unspecified = unspecified;
	}
	/**
	 * <p>This method will set a String value of SUSPENDED to the suspended variable.
	 * @param suspended -  a String value of SUSPENDED
	 */
	public void setSuspended(String suspended){
		// TODO Auto-generated method stub
		this.suspended = suspended;
	}
	/**This method will return a String representation of all relevant information in a series.
	 * 
	 * @return a String of all relevant information in a Series
	 */
	public String printAll(){
		// TODO Auto-generated method stub
		return null;
	}
}
