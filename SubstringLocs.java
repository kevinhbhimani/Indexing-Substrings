import java.util.ArrayList;

/*
 * SubstringLocs class will keep track of the locations associated with a number of 
 * different substrings
 * Modified by: Kevin H. Bhimani
 * Date: October 1, 2017
 */

public class SubstringLocs 

{

	private String substring;
	private ArrayList<Location> substringLocation;

	/**
	 * Constructor for the Substring Location
	 * @param substring The substring whose location we are tracking.
	 */
	public SubstringLocs(String substring)

	{
		this.substring = substring;
		this.substringLocation = new ArrayList<Location>();
	}

	/**
	 * This method returns the substring attached to this object
	 * 
	 * @return The substring of this object
	 */
	public String getSubstring() 
	
	{
		return this.substring;
	}

	/**
	 * This method returns the ArrayList containing Location objects
	 * 
	 * @return The ArrayList of Location objects
	 */
	public ArrayList<Location> getSubstringLocation()
	
	{
		return this.substringLocation;
	}

	/**
	 * This method adds a given Location object to the ArrayList of Location objects
	 * 
	 * @param substringLocation
	 *            The Location object of the substring
	 */
	public void addLocation(Location substringLocation)
	
	{
		this.substringLocation.add(substringLocation);
	}

	/**
	 * This method returns the DNA sequence substring and all of the locations where this
	 * substring was found
	 * 
	 * @return A string containing information about the locations where the
	 *         substring was found
	 */
	public String toString()
	
	{
		// Adds the DNA sequence substring to the return string
		String returnString = this.substring + ":";

		// Loops through the ArrayList of locations and adds them to the return string
		for (Location substringLocation1 : substringLocation) {
			returnString += " " + substringLocation1.toString();
		}

		return returnString;
	}
}