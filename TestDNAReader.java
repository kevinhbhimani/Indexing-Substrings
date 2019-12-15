
/**
 * This class will help us test the early stages of this program.
 * Modified by: Kevin H. Bhimani
 * Date: October 1, 2017
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TestDNAReader

{

	public static void main(String[] args)

	{
		// Turns debugging on
		Debug.turnOn();

		ValidatedInputReader fileReader = new ValidatedInputReader();

		String fileName = fileReader.getString("Enter a filename", "DNAData.txt");

		Debug.println(fileName + "\n");

		DNADataReader dataCollector = new DNADataReader(fileName);

		// Creates an ArrayList to hold the sequencing data
		ArrayList<ArrayList<DNASequence>> DNACaseList = new ArrayList<ArrayList<DNASequence>>();

		// Adds the data to the ArrayList
		DNACaseList.add(dataCollector.readData());

		// Prints out the sequencing data
		// uses the new format to print from array list
		for (ArrayList<DNASequence> arrayListData : DNACaseList)

		{
			Debug.println(arrayListData + "\n");
		}

		
		// Creates a test object 
		Location testLocation = new Location(0, 5);

		
		
		Debug.println("\n" + testLocation.toString());

		// Creates a test object
		SubstringLocs testSubstringLocs = new SubstringLocs("acgt");

	
		testSubstringLocs.addLocation(testLocation);

		Debug.println("\n" + testSubstringLocs.toString());

	}
}