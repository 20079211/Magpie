/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
    statement = statement.toLowerCase(); 
    // makes it easier to parse through strings with mixed-casing
		String response = "";
    if(!((statement.trim()).length()>0)) {
      response = "Say something, please.";
    }
    else if(statement.indexOf("shawver") >= 0) {
      response = "She sounds like a great teacher!";
    }
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
    else if((statement.indexOf("dog") >= 0) || statement.indexOf("cat") >= 0) {
        response = "Tell me more about your pets.";
      }
    else if(statement.indexOf("how are you") >=0) {
      response = "Fantastic. How about you?";
    }

    else if(statement.indexOf("sports") >=0 || statement.indexOf("sport") >=0) {
      response = "What are your favorite sports?";
    }
    else if(statement.indexOf("what is") >=0 || statement.indexOf("why is") >=0 || statement.indexOf("when was") >=0 || statement.indexOf("who is") >=0)
    {
      response = "I don't know... have you tried Google?";
    }
    else if (statement.indexOf("no") >= 0) // Since a lot of words have 'no' in them, I believe that this is the least important keyword
		{
			response = "Why so negative?";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
    // This code's if-logic was unnecessary considering it just pulls a random value.
    String[] responses = {"Interesting, tell me more.", "Hmmm.", "Do you really think so?", "You don't say.", "Wow... I never knew.", "Mhm, go on."}; 
    // Two additional responses
    // #1 Wow... I never knew.
    // #2 Mhm, go on.
		final int NUMBER_OF_RESPONSES = responses.length;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = responses[whichResponse];

		return response;
	}
}
