import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Driver {
	/**
	 * Film ArrayList allows the List of films to pass through all methods
	 */
	public List films = new List ();
	/** Series ArrayList allows the List of TV series to pass through all methods
	 */
	public List series = new List();
	
	
	/**
	 * <p>This is the Main Method of the program.
	 * The code takes a file in the arguments of the project,
	 * and assigns it to a String fileName. The String is made into a FileReader (file),
	 * then BufferedReader for more reliable reading of lines.</p>
	 * 
	 * <p>Through a loop, the BufferedReader then reads a line of the text,
	 *	makes it into a String, and then is parsed in the Parsing method,
	 * 	returning as a either a Movie or Series object.</p>
	 * 
	 * <p>The Objects are then added into their own ArrayLists, 
	 * with episodes being stored in their own ArrayList in a different method.
	 * After all lines of text have been read and parsed, 
	 * the Search method allows for a user to search through the file for specific Media, 
	 * either by title, year, and/or medium .</p>
	 * 
	 * <p>Users may search multiple times.</p>
	 * 
	 * @param args - arguments of the file
	 * @throws IOException - thrown in case there is an error in the File
	 */
	public static void main (String []args) throws IOException{
		//TODO: create general flow of the program, 
			/*
			 * REQUIRED: File & Buffered Reader
			 * File & Buffered WRITER
			 * Lastly, the Input of User through another Buffered Reader and System.in
			 */

	
		
	}
	/**
	 * This method will read the BufferedReader into one individual line.
	 * 
	 * @param List - a BufferedReader containing all movies to be parsed
	 * @return newLine - a String containing the information of one Movie
	 */
	/**
	 * This method will read the BufferedReader into one individual line.
	 * 
	 * @param movieList - a BufferedReader containing all movies to be parsed
	 * @return newLine - a String containing the information of one Movie
	 * @throws IOException - thrown in case there is an error in the File
	 */
	public static String makeLine(BufferedReader movieList) throws IOException{
		//TODO: method to create a string for Each line!
		String newLine = movieList.readLine();
		return newLine;
	}
	/**
	 * <p>This method will parse through a line of text containing information about movies, 
	 * determining whether there are duplicates, if a line contains a non-theater release
	 * format, along with the title and release year.</p>
	 * 
	 * @param line - a String containing all of the text information of a movie
	 * 
	 * @return Movie - a Movie Object with all information parsed 
	 * into different parameters
	 */
	
	public static Movie parseMovie(String line){
		//TODO: use while and for methods to parse lines of File
		/*
		*Declare all instance variable for use throughout the method.
		*/
		
		Movie film;// readies the Movie object to be returned
		
		String title = "";//an Empty string to be changed later
		
		Integer releaseYear = new Integer(0);// set to zero to be changed later
		
		String format = "";// set to an Empty string to possibly be changed later
		
		int version = 0;// set to zero to possibly be changed later
		
		//StringBuilder takes the given line of String and creates a StringBuilder Object
		//This allows for the String Line to be reversed, making the parsing easier.
		
		StringBuilder reverseLine = new StringBuilder(line);
		
		reverseLine.reverse();//now line is reversed
		
		
		
			//Begin parsing
			
			//The first portion of code starts by asking if the line is an
			//Unknown Release Year movie, which is the easiest to identify
		
			if(reverseLine.substring(0, 4).equalsIgnoreCase("????")){
				
				String unknownYear = reverseLine.substring(0, 4);
				
				
				//Ints of TitleIndexand determine the end and beginning of the Title
				
				int endTitleIndex = reverseLine.length();
				
				int beginTitleIndex = reverseLine.lastIndexOf("(") + 1;
				
				
				/*
				 * Declaring a new StringBuilder to read the title left-to-right.
				 */
				StringBuilder titleReverse = new 
						StringBuilder(reverseLine.substring(beginTitleIndex, endTitleIndex));
				
				title = titleReverse.reverse().toString();//creates title
				
				film = new Movie(title, unknownYear);//creates Movie Object
				
				return film;//returns Movie
			}
			
			/*
			 * Else-if goes into creating the more complicated Movie Objects.
			 * 
			 * First If-statement creates the releaseYear Integer.
			 */
			
			 if(!reverseLine.substring(0, 4).equals("????") && 
					 Integer.valueOf(reverseLine.substring(0, 4)) > 0){
				
				 //First Identifies the release year, as all Movie objects will have
				 StringBuilder reverseReleaseYear = new 
						 StringBuilder(reverseLine.substring(0, 4));
				 
				 //creates left-to-right releaseYear
				String actualYear = reverseReleaseYear.reverse().toString();
				
				releaseYear = Integer.valueOf(actualYear);//converts String to Integer
				
				
				/*
				 * Now that releaseYear has been created,
				 * finding if there is a duplicate and non-theater format is feasible.
				 */
				
				//determines if duplicate is in the line of text
				
				if(reverseLine.indexOf("/") > 0){
					
					//creates reversed duplicate 
					StringBuilder reverseDuplicate = new 
							StringBuilder(reverseLine.substring(reverseLine.lastIndexOf(")")+1,
							reverseLine.indexOf("/")));
					
					reverseDuplicate.reverse();//read left-to-right now
					
					String duplicate = reverseDuplicate.toString();
					
					/*
					 * uses RomanNumerals Class to determine the int value of the Duplicate
					 */
					version = RomanNumerals.romanNumToInt(duplicate);
					
					
				}
				
				/*
				 * Now, we determine if there is a format other than in-theaters.
				 */
				
				if (reverseLine.indexOf(")V(") > 0 || 
						reverseLine.indexOf(")VT(") > 0){//determines if format is available.
					
					//checks specifically if the format is "V"
					if (reverseLine.indexOf(")V(") > 0){
						
						StringBuilder reverseFormat = new
								StringBuilder(reverseLine.substring(reverseLine.indexOf(")V("), 
								reverseLine.indexOf(")V(") + 3));
						
						//Now creates the actual format
						 format = reverseFormat.reverse().toString();
						
				}
					/*
					 * Checks Specifically for "TV"
					 * Must use else-if for accuracy
					 */
					else if(reverseLine.indexOf(")VT(") > 0){
						
						StringBuilder reverseFormat = new
								StringBuilder(reverseLine.substring(reverseLine.indexOf(")VT("), 
								reverseLine.indexOf(")VT(") + 4));
						
						//Creates format
						 format = reverseFormat.reverse().toString();
						
					}
				}
				
				/*
				 * Now that all other variables have been declared, 
				 * the Title can now be created.
				 */
				int endTitleIndex = reverseLine.length();
				
				//'+ 2' removes the spaces between the parentheses in the String title.
				int beginTitleIndex = reverseLine.lastIndexOf("(") + 2;
				
				
				//Create full title.
				StringBuilder titleReverse = new 
						StringBuilder(reverseLine.substring(beginTitleIndex,
								endTitleIndex));
				
				title = titleReverse.reverse().toString();
				
				/*
				 *  Checks all possibilities to create the right Movie Object.
				 *  Utilizes format and version since those variables determine the object.
				 */
				
				if(!format.equals("") && version != 0){
					
					film = new Movie(title, releaseYear, version, format);	
					return film;
				}
				else if(!format.equals("") && version == 0){
					
					film = new Movie(title, releaseYear, format);
					return film;
					
				}
				else if(format.equals("") && version != 0){
					
					film = new Movie(title, releaseYear, version);
					return film;
				}
				else{
					
					film = new Movie(title, releaseYear);
					return film;
				}
			}
			
		return null;//only if all If-else methods fail
	}
	
	/**
	 * <p> This method is designed to parse through a line of text from a TV file, 
	 * containing information about a television series. The line contains title, release year, 
	 * and possibly episode information. </p>
	 * <p>When episode information is found, the method calls the parseEpisode method,
	 * and it adds the Episode to the Episodes ArrayList.
	 * 
	 * @param line - a String containing all of the text information of a series, including Episode text
	 * 
	 * @return Series - a Series Object with all information parsed 
	 * into different parameters
	 */
	
	public static Series parseSeries(String line){
		//TODO: use while and for methods to parse lines of File
		return null;
	}
	
	/**
	 * <p>This method takes a substring created in the parseSeries method,
	 *  if line of text contains episode information.
	 * It parses out season, episode number, and releaseYear of the episode.</p>
	 * 
	 * @param line - a String containing all of the text information of an episode
	 * 
	 * @return Episodes - an Episodes Object with all information parsed 
	 * into different parameters
	 */
	
	public static Episodes parseEpisode(String line){
		//TODO: use while and for methods to parse lines of File
		return null;
	}
	
/**<p> This method creates an ArrayList of All the Movies, Series and Episodes
	 * so that all Media can be easily be compared and printed by title.</p>
	 * 
	 *  @param allStuff - an Unsorted array that contains all the Media that match the parameters
	 * inputed and parsed in the search method
	 * 
	 * @return ArrayList - an ArrayList of all Media sorted by title. 
	 */
	public static void sortByTitleList(ArrayList<Media> allStuff){
		//TODO: add all media  sorted by title
		
	}
	/**<p> This method creates an ArrayList of All the Movies, Series and Episodes
	 * so that all Media can be easily be compared and printed by year.</p>
	 * 
	 * @param allStuff - an Unsorted array that contains all the Media that match the parameters
	 * inputed and parsed in the search method  
	 * 
	 * @return ArrayList - an ArrayList of all Media sorted by year. 
	 */
	public static void sortByYearList(ArrayList<Media> allStuff){
		//TODO: add all media  sorted by year: utilize binarySearch and Sort.
		
		Collections.sort(allStuff);
		
		for(int i = 0; i < allStuff.size(); ++i){
			System.out.println(allStuff.get(i).getTitle() + " " + allStuff.get(i).getReleaseYear().toString());
		}
		
		
		
	}
	
	/**
	 * <p>This method prompts for the input of the users to specify how he/she wants to search the media.
	 * The search prompts the user to pick a medium (or all media), exact or partial title,
	 *  the years searched(if specified), and how he/she wants it sorted. </p>
	 *  
	 *  <p>Through this input, the program will use the specified sorted ArrayList, 
	 *  and it will search the ArrayList based on the other specified parameters.</p>
	 *  
	 *  <p> After all is printed, the search will ask the user if he/she wants a file of the found Media,
	 *  prompting for a y/n answer.</p>
	 *  
	 *  <p> If no matches are found, the console will print "no matches"</p>
	 * 
	 *  
	 *  @param inputs - an Array of inputs that the user has entered
	 *  @return foundMedia - a String with every media matching the inputs on a new line
	 */
	public static String search(){
		//TODO: create various statements for searching MediaList
		String firstQ = "";
		String secondQ = "";
		String thirdQseries = "";
		String titleQ = "";
		String inputTitle = "";
		String inputYears = "";
		String sortPref = "";
		
		Scanner inputs = new Scanner(System.in);
		//Prompt
		System.out.println("Search (m)ovies, (s)eries, or (b)oth?");
		firstQ = inputs.nextLine();
		
		System.out.println("Search (t)itle, (y)ear, or (b)oth?");
		secondQ = inputs.nextLine();
		
		if((firstQ.equalsIgnoreCase("s") || firstQ.equalsIgnoreCase("b")) && 
				(secondQ.equalsIgnoreCase("t") || secondQ.equalsIgnoreCase("b"))){
			
			System.out.println("Include episode titles in search and output (y/n)?");
			thirdQseries = inputs.nextLine();
		}
		
		
		if((secondQ.equalsIgnoreCase("t") || secondQ.equalsIgnoreCase("b"))){
			System.out.println("Search for (e)xact or (p)artial matches");
			titleQ = inputs.nextLine();
		}
		
		
		if(secondQ.equalsIgnoreCase("t")){
			System.out.println("Title?");
			inputTitle = inputs.nextLine();
			inputYears = "Any";
		}
		
		
		else if(secondQ.equalsIgnoreCase("y")){
			System.out.println("Years?");
			inputYears = inputs.nextLine();
			inputTitle = "Any";
		}
		
		else if(secondQ.equalsIgnoreCase("b")){
			System.out.println("Title?");
			inputTitle = inputs.nextLine();
			System.out.println("Years?");
			inputYears = inputs.nextLine();
		}
		
		System.out.println("Sort by (t)itle or (y)ear?");
		sortPref = inputs.nextLine();
		
	return null;	
	}
	
}
