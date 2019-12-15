import java.util.ArrayList;

/**
 * The indexer class will be used to find all of the n-letter substrings and
 * their locations within a set of DNA sequences. 
 * Modified by: Kevin H. Bhimani
 * Date: October 1, 2017
 */

public class Indexer {

	private DNADataReader fileName;
	private int lengthOfString;
	private ArrayList<DNASequence> DNAInformation;
	private ArrayList<SubstringLocs> substringAndLocation;

	public Indexer()

	{
		// Ask the user for the name of the data file.
		// Ask the user what length substrings to use.
		// Creates a DNADataReader object with the user-specified information.

		fileName = new DNADataReader(new ValidatedInputReader().getString("Enter a filename", "TestData.txt"));
		
		lengthOfString = new ValidatedInputReader().getInteger("Enter the length of " + "the substring", 4, "Enter an integer");

		DNAInformation = fileName.readData();

		substringAndLocation = new ArrayList<SubstringLocs>();

	}

	/**
	 * This method gets the substring length entered by the user
	 * 
	 * @return The substring length entered by the user
	 */
	public int getlengthOfString()
	
	{
		return this.lengthOfString;
	}
	
	/**
	 * This method gets the file name entered by the user
	 * 
	 * @return The file name entered by the user
	 */

	public DNADataReader getFileName() 
	
	{
		return this.fileName;
	}

	

	/**
	 * This method gets the ArrayList of SubstringLocs objects
	 * 
	 * @return The ArrayList of SubstringLocs objects
	 */
	public ArrayList<SubstringLocs> getsubstringAndLocation()
	
	{
		return this.substringAndLocation;
	}
	
	
	/**
	 * This method gets the ArrayList of DNASequence objects
	 * 
	 * @return The ArrayList of DNASequence objects
	 */
	public ArrayList<DNASequence> getDNACaseInformation() {
		return this.DNAInformation;
	}
	

	/**
	 * This method prints all the substrings and their respective locations
	 */
	public void printResults() {
		// Goes through all the objects in the ArrayList of SubstringLocs
		for (SubstringLocs substringAndLocation1 : substringAndLocation) {
			// Prints out the substring and locations where it was found
			System.out.println(substringAndLocation1.toString() + "\n");
		}
	}

	/**
	 * This method runs the Indexer using all the DNASequence data
	 */
	public void run() 
	
	{
		// This loop runs through all DNASequence objects in the ArrayList of DNASequence objects
		for (int count = 0; count< DNAInformation.size(); count++)
		{
			DNASequence DNACase = this.DNAInformation.get(count);
			
			// This loop goes through all substrings in the sequence of length substringLength
			for (int index = 0; index < DNACase.getDNASequence().length() - this.lengthOfString + 1; index++)
			
			{
				// Creates a new substring for each new substring combination found
				String substring = DNACase.getDNASequence().substring(index, index + this.lengthOfString);

				// This loop runs through all DNASequence objects in the ArrayList of DNASequence objects
				for (DNASequence DNAComparisonCase : this.DNAInformation) 
				
				{
					// This loop runs through every substring combination for the DNA sequence
					for (int startingLocation = 0; startingLocation < DNAComparisonCase.getDNASequence().length()
							- this.lengthOfString + 1; startingLocation++) 
					
					{
						// Checks to see if the substring matches any possible combinations of
						// substrings
						if (substring.equals(DNAComparisonCase.getDNASequence().substring(startingLocation,
								startingLocation + this.lengthOfString)))
						
						{
							// Checks to see if this substring has already been found before
							if (hasSubstringAlreadyBeenFound(substring)) 
							
							{
								// Checks to see if the location has already been found before
								if (!hasLocationAlreadyBeenFound(SubstringLocsObject(substring),
										count, startingLocation)) 
								
								{
									// Adds a Location object to the SubstringLocs object
									SubstringLocsObject(substring).addLocation(
											new Location(count, startingLocation));
								}
							} 
							
							else 
							
							{
								// Creates a temporary SubstringLocs object
								SubstringLocs tempSubstrinLocs = new SubstringLocs(substring);

								// Adds the Location object of where the substring was found to the
								// SubstringLocs object
								tempSubstrinLocs.addLocation(
										new Location(count, startingLocation));

								// Adds the SubstringLocs object to the ArrayList of
								// SubstringLocs objects
								substringAndLocation.add(tempSubstrinLocs);
							}
						}
					}
				}
			}
		}
	}

	
	/**
	 * This method determines if the given substring has already been found and is
	 * in a SubstringLocs object
	 * 
	 * @return true if it is, false if not
	 */
	private boolean hasSubstringAlreadyBeenFound(String substring) {
		// Goes through every SubstringLocs object in the ArrayList of
		// SubstringLocs objects
		
		for (SubstringLocs substringAndLocations : this.substringAndLocation) {
			// Checks to see if the given substring matches any of the substrings from the
			// SubstringLocs object
			if (substring.equals(substringAndLocations.getSubstring())) 
			
			{
				return true;
			}
		}

		return false;
	}

	
	/**
	 * This method gets the SubstringLocs object of a given substring
	 * 
	 * @return The SubstringLocs object that has already been found
	 */
	
	
	private SubstringLocs SubstringLocsObject(String substring) 
	
	{
		// Creates a temporary variable to hold the SubstringLocs object that
		// was found
		SubstringLocs tempSubstringLocs = null;

		// This loop  goes through every SubstringLocs object in the ArrayList 
		
		for (SubstringLocs SubstringLocs : this.substringAndLocation) 
		
		{
			// Checks to see which SubstringLocs object the given substring matches
			if (substring.equals(SubstringLocs.getSubstring()))
			
			{
				tempSubstringLocs = SubstringLocs;
			}
		}

		return tempSubstringLocs;
	}

	/**
	 * This method determines if the given SubstringLocs object already has
	 * the location of the substring documented
	 * 
	 * @return true if it does, false if not
	 */
	private boolean hasLocationAlreadyBeenFound(SubstringLocs SubstringLocsObject, int stringNumber,
			int substringStartingLocation) 
	{
		
		// This loop goes through all Location objects in the SubstringLocsObject object
		for (Location substringLocation : SubstringLocsObject.getSubstringLocation()) 
		
		{
			// Checks to see if the Location has already been found previously
			if (substringLocation.toString()
					.equals((new Location(stringNumber, substringStartingLocation).toString()))) 
			
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * This method gets all the information associated with this object
	 * 
	 * @return A String with all the information present in this object
	 */
	public String toString()
	
	{
		return "File Name:\t" + this.fileName + "\n\nSubstring Length:\t" + this.lengthOfString + "\n\nDNA"
				+ " Sequence Information:\t" + this.DNAInformation + "\n\nSubstring And Locations:\t"
				+ this.substringAndLocation;
	}
}
