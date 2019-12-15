/**
 * The location class will hold a pair of integers indicating (a) the DNA
 * sequence string, and (b) the starting location of the substring within the
 * sequence string.
 * 
 * Modified by: Kevin H. Bhimani
 * Date: October 1, 2017
 */

public class Location

{
	private int NumberOfStrings;
	private int substringStartingLocation;

	/**
	 * Constructor for the Location object
	 * 
	 * @param NumberOfString
	 *            The number of the string sequence
	 * @param substringStartingLocation
	 *            The starting point of the substring
	 */
	public Location(int NumberOfStrings, int substringStartingLocation)

	{
		this.NumberOfStrings = NumberOfStrings;
		this.substringStartingLocation = substringStartingLocation;
	}

	/**
	 * This method gets the value of the string number
	 * 
	 * @return The value of the string number
	 */
	public int getNumberOfStrings()

	{
		return this.NumberOfStrings;
	}

	/**
	 * This method returns the value of the substringLocation
	 * 
	 * @return The value of the substringLocation
	 */
	public int getSubstringStartingLocation()

	{
		return this.substringStartingLocation;
	}

	/**
	 * This method returns the values of the location object in the form of an
	 * ordered pair
	 * 
	 * @return A string containing an ordered pair with the string number and
	 *         substring starting point
	 */
	public String toString()

	{
		return "(" + this.NumberOfStrings + ", " + this.substringStartingLocation + ")";
	}
}