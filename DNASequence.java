/**DNASequence class allows the user to access the sequence information,
 * but users are not be allowed to modify it.
 * Modified by: Kevin H. Bhimani
 * Date: October 1, 2017
 */


public class DNASequence 
{
    private String stringNumber;
    private String DNASequenceName;
    private String DNASequence;

    /**
     * Constructor for a DNASequence object
     * 
     * @param	stringNumber		identification number of the DNA sequence
     * @param	DNASequenceName		name of the DNA sequence
     * @param	DNASequence			the DNA sequence
     */
    
    public DNASequence(String stringNumber, String DNASequenceName, String DNASequence)
    {
        //Sets the instance variables:
        this.stringNumber = stringNumber;
        this.DNASequenceName = DNASequenceName;
        this.DNASequence = DNASequence;
    }

    /**
     * This method gets the String number of the sequence
     * 
     * @return	A String containing stringNumber of the sequence
     */
    public String getStringNumber()
    {
        return this.stringNumber;
    }

    /**
     * This method gets the DNASequenceName of the DNA sequence
     * 
     * @return	A String containing the DNASequenceName of the sequence
     */
    public String getDNASequenceName()
    {
        return this.DNASequenceName;
    }

    /**
     * This method gets the DNASequence of the DNA
     * 
     * @return	a String containing the DNASequence of the DNA
     */
    public String getDNASequence()
    {
        return this.DNASequence;
    }

    /**
     * This method gets all the information about the DNA sequence
     * 
     * @return a String
     */
    public String toString()
    {
        return "Code:\t" + this.stringNumber + "\tDescription:\t" + this.DNASequenceName + "\tSequence:\t" + this.DNASequence;   
    }
}