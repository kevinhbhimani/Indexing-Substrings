/**
 * The IndexerTester class creates an Indexer object, tells it to run and prints the results.
 * 
 * Modified by: Kevin H. Bhimani 
 * Date: October 1, 2017
 */

public class IndexerTester {

	public static void main(String[] args) 
	
	{
		// Creates a new Indexer object
		Indexer testIndexer = new Indexer();

		// Runs
		testIndexer.run();

		// Prints out all information contained in the Indexer class
		testIndexer.printResults();
	}
}