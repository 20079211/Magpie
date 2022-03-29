/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);

    // activity 3 tester code
    int notFoundPsn = sample.indexOf("slow");
    System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
    
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);

    // demonstration of 2 parameter indexOf(str, int) method
    // 1 parameter
    int notFoundPsn2 = lowerCase.indexOf("the", 1);
    System.out.println("Index of \'the\' starting at index 1: " + notFoundPsn2);
		// 2 parameters
		//  Try other methods here:

	}

}
